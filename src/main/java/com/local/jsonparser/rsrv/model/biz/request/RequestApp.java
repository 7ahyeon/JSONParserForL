package com.local.jsonparser.rsrv.model.biz.request;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.dto.req.RsrvRequest;

public class RequestApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RequestService requestService = appConfig.requestService();
        for (int i = 1; i <5; i++) {
            System.out.println(i);
            RsrvRequest rsrvRequest = (RsrvRequest) requestService.createRequestJson(i);
            System.out.println(rsrvRequest.toString());
        }
    }
}
