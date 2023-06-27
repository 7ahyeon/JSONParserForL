package com.local.jsonparser.rsrv.model.biz.serialize;

import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

public interface ObjectToJson { // 직렬화
    // 요청 JSON 전문 생성
    String parsingJson(RsrvRequest rsrvRequest);
}
