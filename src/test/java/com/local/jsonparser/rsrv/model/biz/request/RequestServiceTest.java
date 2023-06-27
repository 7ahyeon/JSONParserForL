package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectService;
import com.local.jsonparser.rsrv.model.biz.filereader.FileReaderService;

import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJsonService;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestServiceTest {
    JsonToObjectService jsonToObjectService;
    ObjectToJsonService objectToJsonService;
    RequestService requestService;
    FileReaderService fileReaderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        jsonToObjectService = appConfig.jsonToObjectService();
        objectToJsonService = appConfig.objectToJsonService();
        requestService = appConfig.requestService();
        fileReaderService = appConfig.fileReaderService();

    }
    @Test
    void createRequestJson() {
        // given
        int select = 1;
        // 요청 파일 읽기
        String jsonFileContent = fileReaderService.fileRead(select);
        // 요청 Json 전문 Object 바인딩
        RsrvRequest rsrvRequest = (RsrvRequest) jsonToObjectService.JsonToObject(jsonFileContent);
        // 요청 Json 전문 생성
        String jsonContent1 = objectToJsonService.objectToJson(rsrvRequest);

        // when
        String jsonContent2 = requestService.createRequestJson(select);

        // then
        Assertions.assertEquals(jsonContent1, jsonContent2);
    }
}