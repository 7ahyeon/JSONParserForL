package com.local.jsonparser.rsrv.model.command;

import com.local.jsonparser.rsrv.model.biz.Application;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendJsonCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        HttpURLConnection con = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        StringBuffer sb = null;
        ServletOutputStream out = null;

        try {
            // 요청을 보낼 URL
            URL url = new URL("http://localhost:8002/main.do");

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(20 * 1000);

            String sendRequest = Application.application();
            // POST 방식으로 JSON 전송
            con.setDoOutput(true);
            bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            bw.write(sendRequest);
            System.out.println(sendRequest);
            bw.flush();
            bw.close();

            int resCode = con.getResponseCode();
            System.out.println(resCode);
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
