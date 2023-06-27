package com.local.jsonparser.rsrv.model.command;

import com.local.jsonparser.rsrv.model.biz.Application;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendJsonCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        HttpURLConnection con = null;
        try {
            // 요청을 보낼 URL
            URL url = new URL("http://localhost:8002/main.do");
            String sendRequest = Application.application();
            con = null;
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.connect();

            send(con, ("RsrvRequest=" + sendRequest).getBytes());
            int resCode = con.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                String result = read(con);
                ServletOutputStream out = res.getOutputStream();
                out.println(result);
            } else {
                throw new IOException(
                        "ERROR : Communication Error\nMSG Code : " + resCode);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }
    private void send(HttpURLConnection con, byte[] p_writeMsg) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(con.getOutputStream());
            dos.write(p_writeMsg);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(HttpURLConnection con) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String strData = null;
        StringBuffer sb = new StringBuffer();
        while ((strData = br.readLine()) != null) {
            sb.append(strData);
        }
        return new String(sb.toString().getBytes());
    }
}
