package com.local.jsonparser.rsrv.model.biz;

import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectService;
import com.local.jsonparser.rsrv.model.biz.request.RequestService;

public class Application {
    public static String application() {
        AppConfig appConfig = new AppConfig();
        RsrvSelectService rsrvSelectService = appConfig.rsrvSelectService();
        RequestService requestService = appConfig.requestService();

        int select = rsrvSelectService.serviceSelect();
        String jsonContent = requestService.createRequestJson(select);
        return jsonContent;
    }
}
