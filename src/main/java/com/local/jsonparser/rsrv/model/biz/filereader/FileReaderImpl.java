package com.local.jsonparser.rsrv.model.biz.filereader;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FileReaderImpl implements FileReader {
    @Override
    public String selectService(int select) {
        // 성능 차이 : if문이 3개일 때 까지는 if문이 빠르나 그 외에는  switch case문이 빠름(컴파일러 최적화시 유리함)
        String jsonFileName = null;
        switch(select) {
            case 1:
                jsonFileName = "RsrvReqRq.json";
                break;
            case 2:
                jsonFileName = "RsrvModRq.json";
                break;
            case 3:
                jsonFileName = "RsrvCnclRq.json";
                break;
            case 4:
                jsonFileName = "RsrvCalRq.json";
                break;
        }
        return jsonFileName;
    }

    @Override // JSON 파일 경로 얻기
    public String getFilePath(String jsonFileName) {
        URL resource = getClass().getClassLoader().getResource("file/" + jsonFileName);
        String jsonFilePath = resource.getFile();

        return jsonFilePath;
    }

    // JSON 파일 읽기
    // NULL 처리 하기
    @Override
    public String readFile(String jsonFilePath) {
        File file = new File(jsonFilePath);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String jsonFileContentLine;

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            // StringBuilder : 문자열 연산이 많을 경우, 동기화를 고려하지 않기 때문에 단일 스레드 환경일 경우(StringBuffer보다 성능 뛰어남) 사용
            StringBuilder sb = new StringBuilder();

            while((jsonFileContentLine = br.readLine()) != null){ // 빈 문자열이 없도록 주의(NPE)
                sb.append(jsonFileContentLine);
            }
            return sb.toString();
            // 파일을 찾지 못했을 경우
        } catch (FileNotFoundException e) {
            return "FileNotFoundException";
            // 파일을 읽지 못했을 경우
        } catch (IOException e) {
            return "IOException";
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
