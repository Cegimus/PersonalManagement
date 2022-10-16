/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/bootids
 */

package org.cegimus.pms.infrastructure.jaxrs;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * @author yxh1316185617@gmail.com
 * @since 2022/10/17 00:11 TZ=Asia/Shanghai
 */
public abstract class CommonResponse {

  private static final Logger log = LoggerFactory.getLogger(CommonResponse.class);

  /**
   * send custom response to client
   */
  public static Response send(Response.Status status, String message) {
    return Response.status(status).type(MediaType.APPLICATION_JSON).entity(message).build();
  }

  /**
   * send failure response to client
   */
  public static Response failure(String message) {
    return send(Response.Status.INTERNAL_SERVER_ERROR, message);
  }

  /**
   * send success response with message to client
   */
  public static Response success(String message) {
    return send(Response.Status.OK, message);
  }

  /**
   * send success response to client
   */
  public static Response success() {
    return send(Response.Status.OK, "操作已成功");
  }

  /**
   * execute executor, if executor throw exception, send failure response to client
   * else send success response to client
   */
  public static Response op(Runnable executor) {
    return op(executor, e -> log.error(e.getMessage(), e));
  }

  /**
   * execute executor, if executor throw exception, send failure response to client
   * else send success response to client
   */
  public static Response op(Runnable executor, Consumer<Exception> exceptionConsumer) {
    try {
      executor.run();
      return CommonResponse.success();
    } catch (Exception e) {
      exceptionConsumer.accept(e);
      return CommonResponse.failure(e.getMessage());
    }
  }

}
