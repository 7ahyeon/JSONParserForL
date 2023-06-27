package com.local.jsonparser.rsrv.model.biz.serialize;

public class ObjectToJsonServiceImpl implements ObjectToJsonService {
    private final ObjectToJson objectToJson;

    public ObjectToJsonServiceImpl(ObjectToJson objectToJson) {
        this.objectToJson = objectToJson;
    }

    @Override
    public String objectToJson(String jsonFileName) {
        String rsrvSelect = objectToJson.selectService(jsonFileName);
        if (rsrvSelect != "fail") {
            String jsonContext = objectToJson.parsingJson(rsrvSelect);
            if (jsonContext != null) {
                return jsonContext;
            } else {
                return "fail";
            }
        } else {
            return "fail";
        }
    }
}
