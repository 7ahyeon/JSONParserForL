package com.local.jsonparser.rsrv.model.biz.deserialize;

public interface JsonToObject { // 역직렬화
    // JSON 전문 Object 바인딩
    Object bindingObject(String jsonFileContent);
}
