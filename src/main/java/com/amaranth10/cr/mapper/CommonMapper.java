package com.amaranth10.cr.mapper;

import com.amaranth10.backendcommon.util.model.UCUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonMapper {

    //고객사 리스트 반환 테스트
    List<Map<String, Object>> selectCompList(Map<String, Object> param);

    //사용자 정보 반환
    UCUserInfo devLogin(Map<String, Object> param);

    //사용자 아이디로 사용자 명 반환
    Map<String, Object> selectUserName(Map<String, Object> param);
    List<Map<String, Object>> selectGroupInfo(Map<String, Object> param);


}
