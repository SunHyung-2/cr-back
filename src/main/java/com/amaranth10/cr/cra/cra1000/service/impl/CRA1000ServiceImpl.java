package com.amaranth10.cr.cra.cra1000.service.impl;

import com.amaranth10.backendcommon.util.helper.ExtractUtil;
import com.amaranth10.backendcommon.util.model.APIResult;
import com.amaranth10.backendcommon.util.model.SessionInfo;
import com.amaranth10.cr.cra.cra1000.mapper.CRA1000Mapper;
import com.amaranth10.cr.cra.cra1000.service.ICRA1000Service;
import com.amaranth10.cr.model.RequestModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 진료 메인 Service
 */
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRA1000ServiceImpl implements ICRA1000Service {
    @Autowired
    CRA1000Mapper cra1000Mapper;

    @Autowired
    private CRA1000ServiceImpl CRA1000ServiceImpl;

    @Override
    public APIResult selectTest(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        try {
            result.setResultCode(HttpServletResponse.SC_OK); // 결과 코드(int)
            result.setResultMsg("성공"); // 결과 메시지(String)
            result.setResultData(cra1000Mapper.testData()); // 결과 값(Object)
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }


    /** CLRS0101 환자현황 ========================================================================================================================================== */
    /** 환자현황 대기 환자수 조회 ------------------------------------------------------------------------------------------------------------------------------------   */
    @Override
    public APIResult patientCount(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();

        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.patientCount(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 환자현황 대기 리스트 ----------------------------------------------------------------------------------------------------------------------------------------   */
    @Override
    public APIResult patientList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        System.out.println("param = " + param);

        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.patientList(param));
            return result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
    /** ========================================================================================================================================================== */


    /** CLRS0102 환자정보 ========================================================================================================================================== */
    /** 환자정보 접수정보 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult patientDetails(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.patientDetails(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 관심환자 여부 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult updatePtCncn(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
//            result.setResultData(cra1000Mapper.updatePtCncn(param));
            cra1000Mapper.updatePtCncn(param);
//            return result;
            return null;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 접수메모 수정 및 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult patientRcpnMemo(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            cra1000Mapper.patientRcpnMemo(param);
            return null;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 진료메모 & 환자메모 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult saveClrPtMemo(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            cra1000Mapper.saveClrPtMemo(param);
            return null;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 진료메모 & 환자메모 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult updateClrPtMemo(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            cra1000Mapper.updateClrPtMemo(param);
            return null;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 환자정보 접수정보 수정 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
            public APIResult updatePtRcpn(RequestInfo requestInfo, RequestModel requestModel) {
                APIResult result = new APIResult();

                Object param = requestModel.getData();
                try {
                    cra1000Mapper.updatePtRcpn(param);
                    return null;
                } catch (Exception e) {
                    KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
                    result.setResultCode(50);
                    result.setResultMsg("에러");
                    return result;
        }
    }


    /** ========================================================================================================================================================== */


    /** CLRS0103 신체사정정보 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0104 검사결과 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0105 경과기록 ========================================================================================================================================== */
    /** ========================================================================================================================================================== */


    /** CLRS0106 처방조회 ========================================================================================================================================== */
    /** Slip 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult slipList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.slipList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** Slip 수가 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult slipPrscList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.slipPrscList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
    /** ========================================================================================================================================================== */


    /** CLRS0107 진단 ========================================================================================================================================== */
    /** 진단 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult dgnsMList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.dgnsMList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 진단 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult dgnsList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.dgnsList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 진단 저장 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult savePtDgns(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            cra1000Mapper.savePtDgns(param);
            return null;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }
    /** ========================================================================================================================================================== */


    /** CLRS0108 처방 ========================================================================================================================================== */
    /** 처방 검색 목록 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult prscMList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.prscMList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }

    /** 처방 내역 조회 -------------------------------------------------------------------------------------------------------------------------------------  */
    @Override
    public APIResult prscList(RequestInfo requestInfo, RequestModel requestModel) {
        APIResult result = new APIResult();

        Object param = requestModel.getData();
        try {
            result.setResultCode(HttpServletResponse.SC_OK);
            result.setResultMsg("성공");
            result.setResultData(cra1000Mapper.prscList(param));
            return  result;
        } catch (Exception e) {
            KlagoLog.logError(requestInfo, "[cr]\n" + e.getMessage());
            result.setResultCode(50);
            result.setResultMsg("에러");
            return result;
        }
    }


    /** ========================================================================================================================================================== */

}
