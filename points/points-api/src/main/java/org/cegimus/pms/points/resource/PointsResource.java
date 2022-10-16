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

package org.cegimus.pms.points.resource;

import jakarta.ws.rs.core.Response;
import org.cegimus.pms.points.api.PointsApi;
import org.springframework.stereotype.Component;

/**
 * @author yxh1316185617@gmail.com
 * @since 2022/10/17 00:59 TZ=Asia/Shanghai
 */
@Component
public class PointsResource implements PointsApi {

  @Override
  public Long getPoints() {
    return 0L;
  }

  @Override
  public Response changePoints(Long points) {
    return null;
  }
}
