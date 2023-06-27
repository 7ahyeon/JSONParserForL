package com.local.jsonparser.rsrv.model.biz.deserialize;

public interface JsonToObject { // 역직렬화
    // 예약 서비스 선택에 따른 파일 이름 설정
    String setJsonFileName(int select);
    // JSON 파일 경로 얻기
    String getFilePath(String jsonFileName);
    // JSON 파일 읽기
    String readFile(String jsonFilePath);
    // 요청 읽기(JSON 전문 Object 바인딩)
    Object bindingObject(String jsonFileContent);
}
