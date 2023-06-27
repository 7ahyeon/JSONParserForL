package com.local.jsonparser.rsrv.model.biz.filereader;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader fileReader;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        fileReader = appConfig.fileReader();
    }

    @Test
    void selectService() {
        // given
        int select = 1;
        String fileName = "RsrvReqRq.json";

        // when
        String jsonFileName = fileReader.selectService(select);

        // then
        assertEquals(jsonFileName, fileName);
    }

    @Test
    void getFilePath() {
        // given
        int select = 1;
        String jsonFileName = fileReader.selectService(select);
        URL resource = getClass().getClassLoader().getResource("file/" + "RsrvReqRq.json");
        String jsonFilePath = resource.getFile();

        // when
        String filePath = fileReader.getFilePath(jsonFileName);

        // then
        assertEquals(jsonFilePath, filePath);
    }

    @Test
    void readFile() {
        // given
        int select = 1;
        String jsonFileName = fileReader.selectService(select);
        String filePath = fileReader.getFilePath(jsonFileName);

        String jsonFileContent = null;
        File file = new File(filePath);
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
            jsonFileContent = sb.toString();
            // 파일을 찾지 못했을 경우
        } catch (FileNotFoundException e) {
            jsonFileContent = "FileNotFoundException";
            // 파일을 읽지 못했을 경우
        } catch (IOException e) {
            jsonFileContent = "IOException";
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

        // when
        String jsonContent = fileReader.readFile(filePath);

        // then
        assertEquals(jsonContent, jsonFileContent);
    }
}