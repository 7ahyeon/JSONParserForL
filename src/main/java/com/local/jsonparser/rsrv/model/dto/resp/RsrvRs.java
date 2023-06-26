package com.local.jsonparser.rsrv.model.dto.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class RsrvRs { // 한화 리조트에서의 예약 관련 응답
    @SerializedName("ds_prcsResult") // 예약 신청/수정/삭제 JSON Key
    private List<RsrvInfo> rsrvInfoList1;
    @SerializedName("ds_prcsResults") // 예약 기간 조회 JSON Key
    private List<RsrvInfo> rsrvInfoList2;
    @SerializedName("ds_roomStatus") // 예약 기간 조회 JSON Key
    private List<RsrvDateInfo> rsrvDateInfoList;
}
