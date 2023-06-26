package com.local.jsonparser.rsrv.model.dto.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class RsrvDateInfo { // 한화 리조트에서의 예약 기간 정보
    // 메시지
    @SerializedName("MSG")
    private String msg;
    // 객실 타입 코드
    @SerializedName("ROOM_TYPE_CD")
    private String roomTypeCd;
    // 객장 코드
    @SerializedName("LOC_CD")
    private String locCd;
    // 시즌 날짜
    @SerializedName("SESN_DATE")
    private LocalDate sesnDate;
    // 시즌 명칭
    @SerializedName("SESN_NM")
    private String sesnNm;
    // 할당 객실 수
    @SerializedName("ALLC_ROOM_CNT")
    private String allcRoomCnt;
    // 잔여 객실 수
    @SerializedName("RSRV_POSBL_CNT")
    private String rsrvPosblCnt;
    // 객장 분류 코드(S/C)
    @SerializedName("RSRV_LOC_DIV_CD")
    private String rsrvLocDivCd;
}
