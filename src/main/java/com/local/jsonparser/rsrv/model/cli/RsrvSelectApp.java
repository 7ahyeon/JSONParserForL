package com.local.jsonparser.rsrv.model.cli;

import com.local.jsonparser.rsrv.model.common.AppConfig;

public class RsrvSelectApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RsrvSelectService rsrvSelectService = appConfig.rsrvSelectService();
        rsrvSelectService.serviceSelect();
    }
}
