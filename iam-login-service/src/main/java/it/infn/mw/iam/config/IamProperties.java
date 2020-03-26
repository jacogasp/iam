/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.infn.mw.iam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import it.infn.mw.iam.config.login.LoginButtonProperties;

@Component
@ConfigurationProperties(prefix = "iam")
public class IamProperties {

  public static class DeviceCodeProperties {
    Boolean allowCompleteVerificationUri = true;

    public Boolean getAllowCompleteVerificationUri() {
      return allowCompleteVerificationUri;
    }

    public void setAllowCompleteVerificationUri(Boolean allowCompleteVerificationUri) {
      this.allowCompleteVerificationUri = allowCompleteVerificationUri;
    }
  }

  public static class JWKProperties {
    String keystoreLocation;
    String defaultKeyId = "rsa1";

    public String getKeystoreLocation() {
      return keystoreLocation;
    }

    public void setKeystoreLocation(String keystoreLocation) {
      this.keystoreLocation = keystoreLocation;
    }

    public String getDefaultKeyId() {
      return defaultKeyId;
    }
  }

  public static class JWTProfile {

    public enum Profile {
      IAM,
      WLCG,
      AARC
    }

    Profile defaultProfile = Profile.IAM;

    public Profile getDefaultProfile() {
      return defaultProfile;
    }

    public void setDefaultProfile(Profile defaultProfile) {
      this.defaultProfile = defaultProfile;
    }
  }


  public static class SuperUser {
    String username;
    String password;

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
  public static class PrivacyPolicy {
    String url;
    String text = "Privacy policy";

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }
  }

  public static class RegistractionAccessToken {
    long lifetime = -1;

    public long getLifetime() {
      return lifetime;
    }

    public void setLifetime(long lifetime) {
      this.lifetime = lifetime;
    }
  }

  public static class AccessToken {

    boolean includeAuthnInfo = false;
    boolean includeScope = false;
    boolean includeNbf = false;

    public boolean isIncludeAuthnInfo() {
      return includeAuthnInfo;
    }

    public void setIncludeAuthnInfo(boolean includeAuthnInfo) {
      this.includeAuthnInfo = includeAuthnInfo;
    }

    public boolean isIncludeScope() {
      return includeScope;
    }

    public void setIncludeScope(boolean includeScope) {
      this.includeScope = includeScope;
    }

    public boolean isIncludeNbf() {
      return includeNbf;
    }

    public void setIncludeNbf(boolean includeNbf) {
      this.includeNbf = includeNbf;
    }
  }

  public static class Organisation {
    private String name = "indigo-dc";

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static class Logo {
    private String url = "resources/images/indigo-logo.png";
    private int dimension = 200;
    private int height = 200;
    private int width = 200;

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public int getDimension() {
      return dimension;
    }

    public void setDimension(int dimension) {
      this.dimension = dimension;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

  }

  public static class LocalResources {

    private boolean enable = false;
    private String location;

    public boolean isEnable() {
      return enable;
    }

    public void setEnable(boolean enable) {
      this.enable = enable;
    }

    public String getLocation() {
      return location;
    }

    public void setLocation(String location) {
      this.location = location;
    }
  }

  public static class AarcProfileProperties {

    private String urnNamespace = "geant:iam";

    public String getUrnNamespace() {
      return urnNamespace;
    }

    public void setUrnNamespace(String urnNamespace) {
      this.urnNamespace = urnNamespace;
    }

  }

  private String host;

  private String issuer;

  private String baseUrl;

  private String topbarTitle;

  private boolean enableScopeAuthz = true;

  private LocalResources localResources = new LocalResources();

  private Logo logo = new Logo();

  private Organisation organisation = new Organisation();

  private AccessToken accessToken = new AccessToken();

  private LoginButtonProperties loginButton = new LoginButtonProperties();

  private RegistractionAccessToken token = new RegistractionAccessToken();

  private PrivacyPolicy privacyPolicy = new PrivacyPolicy();

  private SuperUser superuser = new SuperUser();

  private JWTProfile jwtProfile = new JWTProfile();

  private JWKProperties jwk = new JWKProperties();

  private DeviceCodeProperties deviceCode = new DeviceCodeProperties();

  private boolean generateDdlSqlScript = false;

  private AarcProfileProperties aarcProfile = new AarcProfileProperties();

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public LocalResources getLocalResources() {
    return localResources;
  }

  public void setLocalResources(LocalResources localResources) {
    this.localResources = localResources;
  }

  public Logo getLogo() {
    return logo;
  }

  public void setLogo(Logo logo) {
    this.logo = logo;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public Organisation getOrganisation() {
    return organisation;
  }

  public void setOrganisation(Organisation organisation) {
    this.organisation = organisation;
  }

  public AccessToken getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(AccessToken accessToken) {
    this.accessToken = accessToken;
  }

  public boolean isEnableScopeAuthz() {
    return enableScopeAuthz;
  }

  public void setEnableScopeAuthz(boolean enableScopeAuthz) {
    this.enableScopeAuthz = enableScopeAuthz;
  }

  public LoginButtonProperties getLoginButton() {
    return loginButton;
  }

  public void setLoginButton(LoginButtonProperties loginButton) {
    this.loginButton = loginButton;
  }

  public void setPrivacyPolicy(PrivacyPolicy privacyPolicy) {
    this.privacyPolicy = privacyPolicy;
  }

  public PrivacyPolicy getPrivacyPolicy() {
    return privacyPolicy;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getTopbarTitle() {
    return topbarTitle;
  }

  public void setTopbarTitle(String topbarTitle) {
    this.topbarTitle = topbarTitle;
  }

  public RegistractionAccessToken getToken() {
    return token;
  }

  public void setToken(RegistractionAccessToken token) {
    this.token = token;
  }

  public SuperUser getSuperuser() {
    return superuser;
  }

  public void setSuperuser(SuperUser superuser) {
    this.superuser = superuser;
  }

  public JWTProfile getJwtProfile() {
    return jwtProfile;
  }

  public void setJwtProfile(JWTProfile jwtProfile) {
    this.jwtProfile = jwtProfile;
  }

  public void setJwk(JWKProperties jwk) {
    this.jwk = jwk;
  }

  public JWKProperties getJwk() {
    return jwk;
  }

  public void setDeviceCode(DeviceCodeProperties deviceCode) {
    this.deviceCode = deviceCode;
  }

  public DeviceCodeProperties getDeviceCode() {
    return deviceCode;
  }

  public void setGenerateDdlSqlScript(boolean generateDdlSqlScript) {
    this.generateDdlSqlScript = generateDdlSqlScript;
  }

  public boolean isGenerateDdlSqlScript() {
    return generateDdlSqlScript;
  }

  public AarcProfileProperties getAarcProfile() {
    return aarcProfile;
  }

  public void setAarcProfile(AarcProfileProperties aarcProfile) {
    this.aarcProfile = aarcProfile;
  }
}
