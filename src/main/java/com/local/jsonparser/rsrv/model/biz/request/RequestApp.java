package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.AppConfig;

public class RequestApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RequestService requestService = appConfig.requestService();
        for (int i = 1; i <5; i++) {
            System.out.println(i);
            String jsonContent = requestService.createRequestJson(i);
            System.out.println(jsonContent);
        }
    }
}
