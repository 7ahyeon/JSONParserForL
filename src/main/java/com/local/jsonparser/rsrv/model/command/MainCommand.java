package com.local.jsonparser.rsrv.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res){
        //try catch io servlet
        return "/WEB-INF/view/main.jsp";
    }
}
