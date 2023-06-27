package com.local.jsonparser.rsrv.model.biz.filereader;

public interface FileReader { // 파일 리딩
    // 예약 서비스 선택에 따른 파일 이름 설정
    String selectService(int select);
    // JSON 파일 경로 얻기
    String getFilePath(String jsonFileName);
    // JSON 파일 읽기
    String readFile(String jsonFilePath);
}
