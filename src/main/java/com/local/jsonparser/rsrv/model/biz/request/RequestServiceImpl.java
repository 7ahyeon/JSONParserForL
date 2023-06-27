package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectService;
import com.local.jsonparser.rsrv.model.biz.filereader.FileReaderService;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJsonService;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
// 사용자 서비스 선택에 따른 요청 JSON 생성
public class RequestServiceImpl implements RequestService {
    private final JsonToObjectService jsonToObjectService;
    private final FileReaderService fileReaderService;
    private final ObjectToJsonService objectToJsonService;

    public RequestServiceImpl(JsonToObjectService jsonToObjectService, FileReaderService fileReaderService, ObjectToJsonService objectToJsonService) {
        this.jsonToObjectService = jsonToObjectService;
        this.fileReaderService = fileReaderService;
        this.objectToJsonService = objectToJsonService;
    }

    @Override
    public String createRequestJson(int select){
        // 요청 파일 읽기
       String jsonFileContent = fileReaderService.fileRead(select);
        // 요청 Json 전문 Object 바인딩
        RsrvRequest rsrvRequest = (RsrvRequest) jsonToObjectService.JsonToObject(jsonFileContent);
        // 요청 Json 전문 생성
        String jsonContent = objectToJsonService.objectToJson(rsrvRequest);

        return jsonContent;
    }
}
