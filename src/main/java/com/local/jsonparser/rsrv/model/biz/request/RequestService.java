package com.local.jsonparser.rsrv.model.biz.request;

public interface RequestService {
    // 사용자 서비스 선택에 따른 요청 JSON 생성
    String createRequestJson(int select);
}
