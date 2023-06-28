package com.local.jsonparser.rsrv.model.biz.cli;

import com.local.jsonparser.rsrv.model.biz.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RsrvSelectImplTest {
    final static String REGEX = "[0-9]+";

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
    }

    @Test
    void selectService() {
        // given
        int selectCnt = 4;

        // when
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 > ");
        sc.nextLine();
        String selectSC = sc.nextLine();
        System.out.println(selectSC);
        if (selectSC.matches(REGEX)) {
            if (selectSC.getBytes().length == 1) {
                choice = Integer.parseInt(selectSC);
                System.out.println(choice);
                if (choice > selectCnt || choice < 0) {
                    System.err.println("[오류] 주어진 선택지를 입력해주십시오.");
                    choice = 0;
                } else {
                }
            } else {
                System.err.println("[오류] 한자리 숫자를 입력해주십시오.");
                choice = 0;
            }
        } else {
            System.err.println("[오류] 숫자를 입력해주십시오.");
            choice = 0;
        }
        // then
    }

    @Test
    void selectNum() {
    }
}