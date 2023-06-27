package com.local.jsonparser.rsrv.controller;

import com.local.jsonparser.rsrv.model.command.Command;
import com.local.jsonparser.rsrv.model.command.MainCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet() : 서블릿 자동 등록(접근 경로 맵핑 어노테이션)
// *.do : 보안을 위하여 기존 서블릿 이름이 아닌 .do URL 패턴 호출
@WebServlet("*.do")
// HttpServlet :  웹 상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 상속
public class FrontController extends HttpServlet {
    // SUID(serialVersionUID) : 자바 직렬화 버전 값은 직접 관리해야 함(선언하지 않으면 클래스의 기본 해시값 사용)
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
       doAction(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // setCharacterEncoding : 요청 데이터 문자 타입 UTF-8 처리
        doAction(req, resp);
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp) {
//        req.setCharacterEncoding("UTF-8");
        // getServletPath : 파일명만 가져옴
        String uri = req.getRequestURI();
        String conPath = req.getContextPath();
        String com = uri.substring(conPath.length());
        //String com = req.getServletPath();

        Command command = null;

        // 메인 페이지 이동
        if (com.equals("/main.do")) {
            command = new MainCommand();
        }

        // 커맨드 실행
        String path = command.execute(req, resp);

        // 커맨드 실행 실패시 메인 페이지 포워딩
        if (path == null || path.equals("") ) {
            // include() : 다른 자원의 수행 결과를 클라이언트로부터 요청된 Servlet 안에 포함하여 응답
            // forward() : 다른 자원의 수행 결과가 대신 클라이언트로 응답
            try {
                req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
        }
    }
}
