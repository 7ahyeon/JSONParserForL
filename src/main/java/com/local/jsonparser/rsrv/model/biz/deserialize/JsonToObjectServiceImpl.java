package com.local.jsonparser.rsrv.model.biz.deserialize;

import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import com.local.jsonparser.rsrv.model.dto.resp.RsrvResponse;

import java.util.Collections;

public class JsonToObjectServiceImpl implements JsonToObjectService {
    private final JsonToObject jsonToObject;

    public JsonToObjectServiceImpl(JsonToObject jsonToObject) {
        this.jsonToObject = jsonToObject;
    }

    @Override
    public Object JsonToObject(String jsonContent){
        if (jsonContent.contains("ds_rsrvInfo")||jsonContent.contains("ds_cnclInfo")||jsonContent.contains("ds_search")) {
            // 요청
            RsrvRequest rsrvRequest = (RsrvRequest) jsonToObject.bindingObject(jsonContent);
            return rsrvRequest;
        } else if (jsonContent.contains("ds_prcsResult")||jsonContent.contains("ds_prcsResults")) {
            // 응답
            RsrvResponse rsrvResponse = (RsrvResponse) jsonToObject.bindingObject(jsonContent);
            return rsrvResponse;
        } else {
            // 예외 처리 패턴 getOrElse : 예외 대신 기본 값을 리턴함(null이 아닌 기본 값)
            return Collections.emptyList();
        }

    }
}
