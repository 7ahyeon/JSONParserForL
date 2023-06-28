package com.local.jsonparser.rsrv.model.biz;

import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectService;
import com.local.jsonparser.rsrv.model.biz.request.RequestService;

public class Application {
    public static String application() {
        AppConfig appConfig = new AppConfig();
        RequestService requestService = appConfig.requestService();
       /* RsrvSelectService rsrvSelectService = appConfig.rsrvSelectService();

        int select = rsrvSelectService.serviceSelect();*/
        int select = 1;
        String jsonContent = requestService.createRequestJson(select);
        return jsonContent;
    }

}
