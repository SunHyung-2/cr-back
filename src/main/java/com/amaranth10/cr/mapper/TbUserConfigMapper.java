package com.amaranth10.cr.mapper;

import com.amaranth10.cr.controller.model.TbUserConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TbUserConfigMapper {

    // 사용자 설정 가져오기
    List<TbUserConfig> selectUserInfo(Map<String, Object> record);

    List<TbUserConfig> selectUserInfo2(Map<String, Object> record);

    // 사용자 설정 변경
    int insertUserInfo(Map<String, Object> record);

    // 사용자 설정 존재 여부
    int selectUserInfoCnt(Map<String, Object> record);

    // 사용자 설정 수정
    int updateUserInfo(Map<String, Object> record);

    // 최근 사용한 회신번호 수정
    int updateRecentCallbackNo(Map<String, Object> record);

}