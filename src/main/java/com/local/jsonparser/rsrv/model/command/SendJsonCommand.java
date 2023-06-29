package com.local.jsonparser.rsrv.model.command;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.biz.Application;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectService;
import com.local.jsonparser.rsrv.model.dto.resp.RsrvResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendJsonCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int select = Integer.parseInt(req.getParameter("select"));
        String sendRequest = Application.application(select);

        HttpURLConnection con = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        StringBuffer sb = null;

        try {
            // 요청을 보낼 URL
            URL url = new URL("http://localhost:8002/receiveJson.do");

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setConnectTimeout(20 * 1000);

            // POST 방식으로 JSON 전송
            con.setDoOutput(true);
            bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            bw.write(sendRequest);
            System.out.println("요청 JSON 전송");
            System.out.println(sendRequest);
            bw.flush();
            bw.close();

            con.connect();
            // 서버에서 보낸 응답 데이터 수신
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String strData;
            sb = new StringBuffer();
            while ((strData = br.readLine()) != null) {
                sb.append(strData);
            }
            br.close();

            String jsonContent = sb.toString();
            System.out.println("응답 JSON 수신");
            System.out.println(jsonContent);

            int resCode = con.getResponseCode();
            System.out.println(resCode);
            AppConfig appConfig = new AppConfig();
            JsonToObjectService jsonToObjectService = appConfig.jsonToObjectService();
            RsrvResponse rsrvResponse = (RsrvResponse) jsonToObjectService.JsonToObject(jsonContent);
            System.out.println("응답 JSON Object 바인딩 결과");
            System.out.println(rsrvResponse);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return "/WEB-INF/view/main.jsp";
    }
}
