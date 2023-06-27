package com.local.jsonparser.rsrv.model.biz.serialize;

public interface ObjectToJson { // 직렬화

    // 신청/조회/수정/취소/기간조회 처리 결정
    String selectService(String jsonFileName);
    // 요청/응답 전문 생성
    String parsingJson(String rsrvSelect);
}
