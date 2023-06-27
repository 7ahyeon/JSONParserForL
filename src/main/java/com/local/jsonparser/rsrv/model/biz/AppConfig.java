package com.local.jsonparser.rsrv.model.biz;

import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelect;
import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectImpl;
import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectService;
import com.local.jsonparser.rsrv.model.biz.cli.RsrvSelectServiceImpl;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObject;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectImpl;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectService;
import com.local.jsonparser.rsrv.model.biz.deserialize.JsonToObjectServiceImpl;
import com.local.jsonparser.rsrv.model.biz.request.RequestService;
import com.local.jsonparser.rsrv.model.biz.request.RequestServiceImpl;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJson;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJsonImpl;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJsonService;
import com.local.jsonparser.rsrv.model.biz.serialize.ObjectToJsonServiceImpl;

public class AppConfig {  // DI(의존관계 주입) : 객체 생성 및 구현체 할당 (외부(스프링 컨테이너) 역할)
    public RsrvSelectService rsrvSelectService() {
        return new RsrvSelectServiceImpl(rsrvSelect());
    }
    public RsrvSelect rsrvSelect() {
        return new RsrvSelectImpl();
    }

    public RequestService requestService() {
        return new RequestServiceImpl(jsonToObject());
    }
    public JsonToObjectService jsonToObjectService() {
        return new JsonToObjectServiceImpl(jsonToObject());
    }
    public JsonToObject jsonToObject() {
        return new JsonToObjectImpl();
    }

    public ObjectToJsonService objectToJsonService() {
        return new ObjectToJsonServiceImpl(objectToJson());
    }

    public ObjectToJson objectToJson() {
        return new ObjectToJsonImpl();
    }

}
