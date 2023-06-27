package com.local.jsonparser.rsrv.model.biz.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import com.local.jsonparser.rsrv.model.biz.util.localdate.LocalDateSerializer;
import com.local.jsonparser.rsrv.model.biz.util.localdatetime.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjectToJsonImpl implements ObjectToJson {

    @Override // 신청/조회/수정/취소/기간조회 처리 결정
    public String selectService(String jsonFileName) {
        String select = "fail";
        if (jsonFileName.endsWith(".json")) {
            jsonFileName = jsonFileName.replace(".json", "");
            // 예약 요청
            if (jsonFileName.endsWith("ReqRq")||jsonFileName.endsWith("ReqRs")) {
                select = "req";
            } else {
                select = "fail";
            }
        }
        return select;
    }

    @Override // 요청/응답 전문 생성
    public String parsingJson(String rsrvSelect) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonContext = null;

        switch (rsrvSelect) {
            case "req":
                RsrvRequest rsrvRequest = new RsrvRequest();
                String rsrvRequest1 = gson.toJson(rsrvRequest);
                jsonContext = rsrvRequest1;
                break;
        }
        return jsonContext;
    }
}
