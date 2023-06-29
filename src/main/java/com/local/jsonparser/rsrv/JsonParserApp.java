package com.local.jsonparser.rsrv;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectService;

public class JsonParserApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RsrvSelectService rsrvSelectService = appConfig.rsrvSelectService();

        int select = rsrvSelectService.serviceSelect();

    }
}
