package com.amaranth10.cr.bean;

import com.amaranth10.backendcommon.util.patch.db.DBPatchManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class DbPatchInit {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public DBPatchManager dbPatchManager() throws IOException {
        DBPatchManager dbPatchManager = new DBPatchManager();
        dbPatchManager.setSqlSessionFactory(sqlSessionFactory);
        Resource[] resource = applicationContext.getResources("classpath:patchQuery/*/*/*.xml");
        dbPatchManager.setPatchLocations(resource);
        return dbPatchManager;
    }
}