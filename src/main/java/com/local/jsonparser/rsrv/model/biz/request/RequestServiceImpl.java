package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObject;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
// 사용자 서비스 선택에 따른 요청 JSON 생성
public class RequestServiceImpl implements RequestService {
    private final JsonToObject jsonToObject;

    public RequestServiceImpl(JsonToObject jsonToObject) {
        this.jsonToObject = jsonToObject;
    }

    @Override
    public Object createRequestJson(int select){
        // 예약 서비스 선택에 따른 파일 이름 설정
        String jsonFileName = jsonToObject.setJsonFileName(select);
        // JSON 파일 경로 얻기
        String jsonFilePath = jsonToObject.getFilePath(jsonFileName);
        // 파일 읽기
        String jsonFileContent = jsonToObject.readFile(jsonFilePath);
        // 요청 Json 전문 Object 바인딩
        RsrvRequest rsrvRequest = (RsrvRequest) jsonToObject.bindingObject(jsonFileContent);

        return rsrvRequest;
    }
}
