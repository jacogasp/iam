package it.infn.mw.iam.notification;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.infn.mw.iam.core.IamDeliveryStatus;
import it.infn.mw.iam.core.time.TimeProvider;
import it.infn.mw.iam.persistence.model.IamEmailNotification;
import it.infn.mw.iam.persistence.repository.IamEmailNotificationRepository;

@Service
@ConditionalOnProperty(name = "notification.disable", havingValue = "false")
public class JavaMailNotificationDelivery implements NotificationDelivery {

  public static final Logger LOG = LoggerFactory.getLogger(JavaMailNotificationDelivery.class);

  final JavaMailSender mailSender;

  final IamEmailNotificationRepository repo;
  final NotificationProperties properties;
  final TimeProvider timeProvider;

  @Autowired
  public JavaMailNotificationDelivery(JavaMailSender mailSender,
      IamEmailNotificationRepository repo, NotificationProperties properties,
      TimeProvider timeProvider) {
    this.mailSender = mailSender;
    this.repo = repo;
    this.properties = properties;
    this.timeProvider = timeProvider;
  }

  protected SimpleMailMessage messageFromNotification(IamEmailNotification notification) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(properties.getMailFrom());
    message.setSubject(notification.getSubject());
    message.setText(notification.getBody());
    notification.getReceivers().forEach(r -> message.setTo(r.getEmailAddress()));
    return message;
  }


  @Override
  @Transactional
  public void sendPendingNotifications() {
    List<IamEmailNotification> pendingMessages =
        repo.findByDeliveryStatus(IamDeliveryStatus.PENDING);

    if (pendingMessages.isEmpty()) {
      LOG.debug("No pending messages found in repository");
      return;
    }

    for (IamEmailNotification e : pendingMessages) {
      SimpleMailMessage message = messageFromNotification(e);

      try {
        mailSender.send(message);
        e.setDeliveryStatus(IamDeliveryStatus.DELIVERED);

        LOG.info(
            "Email message delivered. "
                + "message_id:{} message_type:{} rcpt_to:{} subject:{}",
            e.getUuid(), e.getType(), message.getTo(), message.getSubject());


      } catch (MailException ex) {
        e.setDeliveryStatus(IamDeliveryStatus.DELIVERY_ERROR);
        LOG.error("Email message delivery error: message_id:{} reason:{}", e.getUuid(),
            ex.getMessage(), ex);
      }

      e.setLastUpdate(new Date(timeProvider.currentTimeMillis()));
      repo.save(e);
    }

  }

}
