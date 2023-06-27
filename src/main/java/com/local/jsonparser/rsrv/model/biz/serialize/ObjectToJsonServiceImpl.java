package com.local.jsonparser.rsrv.model.biz.serialize;

import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

public class ObjectToJsonServiceImpl implements ObjectToJsonService {
    private final ObjectToJson objectToJson;

    public ObjectToJsonServiceImpl(ObjectToJson objectToJson) {
        this.objectToJson = objectToJson;
    }

    @Override
    public String objectToJson(RsrvRequest rsrvRequest) {
        String jsonContent = objectToJson.parsingJson(rsrvRequest);
        return jsonContent;
    }

}
