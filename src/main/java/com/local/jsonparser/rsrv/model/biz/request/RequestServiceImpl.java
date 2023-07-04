package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObject;
import com.local.jsonparser.rsrv.model.biz.filereader.FileReaderService;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJson;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

// 사용자 서비스 선택에 따른 요청 JSON 생성
public class RequestServiceImpl implements RequestService {
    private final JsonToObject jsonToObject;
    private final FileReaderService fileReaderService;
    private final ObjectToJson objectToJson;

    public RequestServiceImpl(JsonToObject jsonToObject, FileReaderService fileReaderService, ObjectToJson objectToJson) {
        this.jsonToObject = jsonToObject;
        this.fileReaderService = fileReaderService;
        this.objectToJson = objectToJson;
    }

    @Override
    public String createRequestJson(int select){
        // 요청 파일 읽기
       String jsonFileContent = fileReaderService.fileRead(select);
        // 요청 Json 전문 Object 바인딩
        RsrvRequest rsrvRequest = (RsrvRequest) jsonToObject.bindingObject(jsonFileContent);
        // 요청 Json 전문 생성
        String jsonContent = objectToJson.parsingJson(rsrvRequest);

        return jsonContent;
    }
}
