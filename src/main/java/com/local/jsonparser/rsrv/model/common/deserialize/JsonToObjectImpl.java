package com.local.jsonparser.rsrv.model.common.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;
import com.local.jsonparser.rsrv.model.util.localdate.LocalDateDeserializer;
import com.local.jsonparser.rsrv.model.util.localdatetime.LocalDateTimeDeserializer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonToObjectImpl implements JsonToObject {

    @Override // JSON 파일 경로 얻기
    public String getFilePath(String jsonFileName) {
        String jsonFilePath = "C:\\Users\\user\\Desktop\\JSONParserForH\\src\\main\\resources\\file\\" + jsonFileName;
        return jsonFilePath;
    }

    // JSON 파일 읽기
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

    // JSON 전문 Object 바인딩
    @Override
    public Object bindingObject(String jsonFileContent, String jsonFileName) {
        //.serializeNulls() .setPrettyPrinting() : toJson (직렬화 시 사용)
        // .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) : Underscore를 CamelCase로 자동 변환 / 작동 불가 이슈
        // Object @SerializedName 설정 부여
        GsonBuilder gsonBuilder = new GsonBuilder();
        // 역직렬화시 LocalDate formatting
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        if (jsonFileName.endsWith(".json")) {
            jsonFileName = jsonFileName.replace(".json", "");
            // 예약 요청
            if (jsonFileName.endsWith("ReqRq")) {
                RsrvRequest rsrvRequest = gson.fromJson(jsonFileContent, RsrvRequest.class);
                return rsrvRequest;
            }
        }
        return null;
    }
}
