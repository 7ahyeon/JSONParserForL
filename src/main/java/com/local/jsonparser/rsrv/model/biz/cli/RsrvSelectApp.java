package com.local.jsonparser.rsrv.model.biz.cli;

import com.local.jsonparser.rsrv.model.biz.AppConfig;

public class RsrvSelectApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RsrvSelectService rsrvSelectService = appConfig.rsrvSelectService();
        int select = rsrvSelectService.serviceSelect();
    }
}
