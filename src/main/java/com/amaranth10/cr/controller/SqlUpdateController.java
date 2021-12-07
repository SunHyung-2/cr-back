package com.amaranth10.cr.controller;

import com.amaranth10.backendcommon.util.constant.CommonConstants;
import com.amaranth10.backendcommon.util.constant.PatchConstants;
import com.amaranth10.backendcommon.util.patch.db.DBPatchManager;
import com.amaranth10.cr.model.properties.BasicPropertiesModels;
import com.amaranth10.cr.util.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class SqlUpdateController {


    @Autowired
    DBPatchManager patchManager;

    @Autowired
    RedisManager redisManager;

    @Autowired
    BasicPropertiesModels basicPropertiesModels;

    @RequestMapping(value="/sqlUpdate", method={RequestMethod.POST})
    @ResponseBody
    public Object sqlUpdate(HttpServletRequest servletRequest, HttpServletResponse servletResponse, @RequestBody Map<String, String> params) throws Exception {
        params.put(CommonConstants.SERVER_SIGN_KEY, basicPropertiesModels.getKlagoSignValue());
        params.put(PatchConstants.CONTEXT_NAME, servletRequest.getContextPath().replaceAll("/", ""));


        patchManager.setJedisInfoClient(redisManager.getJedisInfoClient());
        patchManager.start(params);

        return true;
    }
}