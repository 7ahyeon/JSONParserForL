package com.local.jsonparser.rsrv.model.biz.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import com.local.jsonparser.rsrv.model.biz.util.localdate.LocalDateSerializer;
import com.local.jsonparser.rsrv.model.biz.util.localdatetime.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjectToJsonImpl implements ObjectToJson {
    // 요청 JSON 전문 생성
    @Override
    public String parsingJson(RsrvRequest rsrvRequest) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();

        String jsonContent = gson.toJson(rsrvRequest);
        return jsonContent;
    }
}
