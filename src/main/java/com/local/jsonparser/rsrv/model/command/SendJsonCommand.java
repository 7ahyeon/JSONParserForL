package com.local.jsonparser.rsrv.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;

public class SendJsonCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            // 요청을 보낼 URL
            URL url = new URL("http://localhost:8002/main.do");
//            String SendRequest
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
