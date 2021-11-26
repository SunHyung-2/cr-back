package com.amaranth10.cr.service;

import com.amaranth10.backendcommon.util.exception.PatchException;
import com.amaranth10.backendcommon.util.helper.PropertiesHelper;
import com.amaranth10.backendcommon.util.patch.db.DBPatchManager;
import com.amaranth10.cr.util.RedisManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ServiceInitializer {
	@Autowired
	DBPatchManager patchManager;
	
	@Autowired
	RedisManager redisManager;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	PropertiesHelper propertiesHelper;
	
	public void init() throws PatchException, IOException, NoSuchAlgorithmException {
//		String tempp = kph.encryptValue("1234");
//		String temp = kph.getPassword("Klago.Password");
		
//		patchManager.setJedisInfoClient(redisManager.getJedisInfoClient());
//		patchManager.init().execute(sqlSession.getMapper(PatchMapper.class));
	}
}