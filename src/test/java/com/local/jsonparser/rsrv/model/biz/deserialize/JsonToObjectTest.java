package com.local.jsonparser.rsrv.model.biz.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.biz.filereader.FileReaderService;
import com.local.jsonparser.rsrv.model.biz.util.localdate.LocalDateDeserializer;
import com.local.jsonparser.rsrv.model.biz.util.localdatetime.LocalDateTimeDeserializer;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

class JsonToObjectTest {
    JsonToObject jsonToObject;
    FileReaderService fileReaderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        jsonToObject = appConfig.jsonToObject();
        fileReaderService = appConfig.fileReaderService();
    }
    @Test
    void bindingObject() {
        // given
        int select = 1;
        String jsonContent = fileReaderService.fileRead(select);

        GsonBuilder gsonBuilder2 = new GsonBuilder();
        // 역직렬화시 LocalDate formatting
        gsonBuilder2.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder2.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson2 = gsonBuilder2.setPrettyPrinting().create();
        RsrvRequest rsrvRequest = null;
        if (jsonContent.contains("ds_rsrvInfo")||jsonContent.contains("ds_cnclInfo")||jsonContent.contains("ds_search")) {
            // 요청
            rsrvRequest = gson2.fromJson(jsonContent, RsrvRequest.class);
        } else if (jsonContent.contains("ds_prcsResult")||jsonContent.contains("ds_prcsResults")) {
            // 응답
        } else {
            // 예외 처리 패턴 getOrElse : 예외 대신 기본 값을 리턴함(null이 아닌 기본 값)
        }
        System.out.println(rsrvRequest.toString());
        System.out.println(rsrvRequest.hashCode());

        // when
        RsrvRequest rsrvRequest1 = (RsrvRequest) jsonToObject.bindingObject(jsonContent);
        System.out.println(rsrvRequest1.toString());
        System.out.println(rsrvRequest1.hashCode());

        // then
//        Assertions.assertEquals(rsrvRequest1, rsrvRequest);
    }
}