/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2021
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
package it.infn.mw.iam.test.actuator;

public class ActuatorTestSupport {

  static final String ADMIN_USERNAME = "admin";
  static final String ADMIN_ROLE = "ADMIN";

  static final String ACTUATOR_ROLE = "ACTUATOR";

  static final String USER_USERNAME = "test";
  static final String USER_ROLE = "USER";

  static final String STATUS_UP = "UP";
  static final String STATUS_DOWN = "DOWN";

  static final String HEALTH_ENDPOINT = "/actuator/health";

  static final String INFO_ENDPOINT = "/actuator/info";

}
