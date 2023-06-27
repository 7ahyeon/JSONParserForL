package com.local.jsonparser.rsrv.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Command : 작업을 처리할 커맨드의 추상화 인터페이스 (커맨드 패턴 이용)
// Command Pattern : 커맨드에 따라서 로직 처리 부분을 별도의 클래스로 분리
public interface Command {
    public String execute(HttpServletRequest req, HttpServletResponse res);
}
