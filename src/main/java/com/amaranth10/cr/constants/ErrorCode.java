package com.amaranth10.cr.constants;

public class ErrorCode {
    public static final String IOException = "INTERNAL SERVER ERROR(IO ERROR)";
    public static final String IOErrorCode = "-1";
    public static final String SQLException = "INTERNAL SERVER ERROR(SQL ERROR)";
    public static final String SQLErrorCode = "-1";
    public static final String JSONParserException = "INTERNAL SERVER ERROR(JSON PARSER ERROR)";
    public static final String JSONParserErrorCode = "-1";
    public static final String CLOUDFAXException = "INTERNAL SERVER ERROR(CLOUDFAX WEBSERVICE ERROR)";
    public static final String WEHAGOAPIErrorCode = "-1";
    public static final String WEHAGOAPIException = "INTERNAL SERVER ERROR(WEHAGO API ERROR)";
    public static final String NULLPointerErrorCode = "-1";
    public static final String NULLPointerException = "INTERNAL SERVER ERROR(NULL POINTER ERROR)";

    public static final int UncertErrorCode = 401;
    public static final String UncertErrorMsg = "서비스이용권한이 없습니다.";

    public static final int ServiceAdminErrorCode = 42;
    public static final String ServiceAdminErrorMsg = "서비스관리자가 아닙니다.";
}