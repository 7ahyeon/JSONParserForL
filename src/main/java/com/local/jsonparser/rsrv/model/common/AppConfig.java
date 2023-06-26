package com.local.jsonparser.rsrv.model.common;

import com.local.jsonparser.rsrv.model.cli.RsrvSelect;
import com.local.jsonparser.rsrv.model.cli.RsrvSelectImpl;
import com.local.jsonparser.rsrv.model.cli.RsrvSelectService;
import com.local.jsonparser.rsrv.model.cli.RsrvSelectServiceImpl;

public class AppConfig {  // DI(의존관계 주입) : 객체 생성 및 구현체 할당 (외부(스프링 컨테이너) 역할)

    public RsrvSelectService rsrvSelectService() {
        return new RsrvSelectServiceImpl(rsrvSelect());
    }

    public RsrvSelect rsrvSelect() {
        return new RsrvSelectImpl();
    }

}
