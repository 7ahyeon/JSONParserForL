package com.local.jsonparser.rsrv.model.biz.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import com.local.jsonparser.rsrv.model.dto.resp.RsrvResponse;
import com.local.jsonparser.rsrv.model.biz.util.localdate.LocalDateDeserializer;
import com.local.jsonparser.rsrv.model.biz.util.localdatetime.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class JsonToObjectImpl implements JsonToObject {
    // JSON 전문 Object 바인딩
    @Override
    public Object bindingObject(String jsonContent) {
        //.serializeNulls() .setPrettyPrinting() : toJson (직렬화 시 사용)
        // .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) : Underscore를 CamelCase로 자동 변환 / 작동 불가 이슈
        // Object @SerializedName 설정 부여
        GsonBuilder gsonBuilder = new GsonBuilder();
        // 역직렬화시 LocalDate formatting
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        if (jsonContent.contains("ds_rsrvInfo")||jsonContent.contains("ds_cnclInfo")||jsonContent.contains("ds_search")) {
            // 요청
            RsrvRequest rsrvRequest = gson.fromJson(jsonContent, RsrvRequest.class);
            return rsrvRequest;
        } else if (jsonContent.contains("ds_prcsResult")||jsonContent.contains("ds_prcsResults")) {
            // 응답
            RsrvResponse rsrvResponse = gson.fromJson(jsonContent, RsrvResponse.class);
            return rsrvResponse;
        } else {
            // 예외 처리 패턴 getOrElse : 예외 대신 기본 값을 리턴함(null이 아닌 기본 값)
            return Collections.emptyList();
        }
    }
}
