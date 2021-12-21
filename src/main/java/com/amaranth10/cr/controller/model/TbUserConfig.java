package com.amaranth10.cr.controller.model;

import java.util.Date;

/*
 * 사용자 환경설정 데이터
 *
 * */

public class TbUserConfig {

    private Integer userkey_pk;
    private String compseq;
    private String groupseq;
    private String empseq;
    private String smsresult_view_type;
    private int smsresult_list_count;
    private String user_font_size;
    private String recent_callbackno;
    private Date add_date;

    public Integer getUserkey_pk() {
        return userkey_pk;
    }
    public void setUserkey_pk(Integer userkey_pk) {
        this.userkey_pk = userkey_pk;
    }
    public String getCompseq() {
        return compseq;
    }
    public void setCompseq(String compseq) {
        this.compseq = compseq;
    }
    public String getGroupseq() {
        return groupseq;
    }
    public void setGroupseq(String groupseq) {
        this.groupseq = groupseq;
    }
    public String getEmpseq() {
        return empseq;
    }
    public void setEmpseq(String empseq) {
        this.empseq = empseq;
    }
    public String getSmsresult_view_type() {
        return smsresult_view_type;
    }
    public void setSmsresult_view_type(String smsresult_view_type) {
        this.smsresult_view_type = smsresult_view_type;
    }
    public int getSmsresult_list_count() {
        return smsresult_list_count;
    }
    public void setSmsresult_list_count(int smsresult_list_count) {
        this.smsresult_list_count = smsresult_list_count;
    }
    public String getUser_font_size() {
        return user_font_size;
    }
    public void setUser_font_size(String user_font_size) {
        this.user_font_size = user_font_size;
    }
    public String getRecent_callbackno() {
        return recent_callbackno;
    }
    public void setRecent_callbackno(String recent_callbackno) {
        this.recent_callbackno = recent_callbackno;
    }
    public Date getAdd_date() {
        return add_date;
    }
    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }


}