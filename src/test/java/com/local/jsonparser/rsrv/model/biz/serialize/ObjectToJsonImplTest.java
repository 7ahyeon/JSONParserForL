package com.local.jsonparser.rsrv.model.biz.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObject;
import com.local.jsonparser.rsrv.model.biz.filereader.FileReaderService;
import com.local.jsonparser.rsrv.model.biz.util.localdate.LocalDateSerializer;
import com.local.jsonparser.rsrv.model.biz.util.localdatetime.LocalDateTimeSerializer;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ObjectToJsonImplTest {
    JsonToObject jsonToObject;
    FileReaderService fileReaderService;
    ObjectToJson objectToJson;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        jsonToObject = appConfig.jsonToObject();
        fileReaderService = appConfig.fileReaderService();
        objectToJson = appConfig.objectToJson();
    }
    @Test
    void parsingJson() {
        // given
        int select = 1;
        String jsonContent = fileReaderService.fileRead(select);
        RsrvRequest rsrvRequest = (RsrvRequest) jsonToObject.bindingObject(jsonContent);

        // when
        String jsonContent1 = objectToJson.parsingJson(rsrvRequest);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();

        String jsonContent2 = gson.toJson(rsrvRequest);

        // then
        assertEquals(jsonContent2, jsonContent1);
    }
}