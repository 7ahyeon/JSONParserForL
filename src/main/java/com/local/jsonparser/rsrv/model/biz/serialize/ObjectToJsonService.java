package com.local.jsonparser.rsrv.model.biz.serialize;

import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

public interface ObjectToJsonService {
    // 직렬화
    String objectToJson(RsrvRequest rsrvRequest);
}
