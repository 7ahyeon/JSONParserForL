package com.local.jsonparser.rsrv.model.common.deserialize;

import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

public class JsonToObjectServiceImpl implements JsonToObjectService {
    private final JsonToObject jsonToObject;

    public JsonToObjectServiceImpl(JsonToObject jsonToObject) {
        this.jsonToObject = jsonToObject;
    }

    @Override
    public Object JsonToObject(String jsonFileName){
        // JSON 파일 경로 얻기
        String jsonFilePath = jsonToObject.getFilePath(jsonFileName);

        // 파일 읽기
        String jsonFileContent = null;
        jsonFileContent = jsonToObject.readFile(jsonFilePath);
        if (jsonFileContent != null) { // 파일 내용이 있을 시
            // Json 전문 Object 바인딩
            RsrvRequest rsrvRequest = (RsrvRequest) jsonToObject.bindingObject(jsonFileContent, jsonFileName);
            return rsrvRequest;
        } else {
            return false;
        }
    }
}
