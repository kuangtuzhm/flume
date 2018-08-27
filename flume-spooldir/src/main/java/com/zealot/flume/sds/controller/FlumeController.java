/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年7月2日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.flume.sds.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zealot.flume.log.bean.LogInfo;
import com.zealot.flume.log.enums.Module;
import com.zealot.flume.log.enums.OperAction;
import com.zealot.flume.log.util.LogUtil;
import com.zealot.log.bean.OperLogBean;

/**
 * @FileName FlumeController.java
 * @Description: 
 *
 * @Date 2018年7月2日 下午3:21:12
 * @author Zhao Haiming
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/flume")
public class FlumeController {

    //输出普通日志
    private final static Logger logger = LoggerFactory.getLogger(FlumeController.class);
    
    @RequestMapping(value = "/stu")
    @ResponseBody
    public String stu(HttpServletRequest req){
        
        OperLogBean log = new OperLogBean();
        log.setProjectId("TUQIANG");
        log.setOperatorDesc("增加用户[张三]成功");
        log.setOperAction(2);
        log.setUserId(1);
        log.setOperObj("1234");
        
        String json = JSON.toJSONString(log);
        
        LogInfo logInfo = LogUtil.getLogInfo(Module.USER, "增加用户{},{}成功");
        logInfo.setOperAction(OperAction.ADD.getAction());
        logInfo.setOperObj("123456789");
        logInfo.setResultCode(1);
        LogUtil.debug(logInfo, "张三","李四");
        
        LogUtil.debug(Module.USER, "增加用户[{}]成功", "张三");
        
        LogUtil.debug(Module.USER, OperAction.ADD, "增加用户[{}]成功", "张三");
        
        Throwable e=new Exception("1324");
        
        LogUtil.debug(Module.USER, "增加用户出错:", e);
        
        
        LogUtil.info(logInfo, "张三","李四");
        
        LogUtil.info(Module.USER, "增加用户[{}]成功", "张三");
        
        LogUtil.info(Module.USER, OperAction.ADD, "增加用户[{}]成功", "张三");

        LogUtil.info(Module.USER, "增加用户出错:", e);
        
        LogUtil.warn(logInfo, "张三","李四");
        
        LogUtil.warn(Module.USER, "增加用户[{}]成功", "张三");
        
        LogUtil.warn(Module.USER, OperAction.ADD, "增加用户[{}]成功", "张三");

        LogUtil.warn(Module.USER, "增加用户出错:", e);
        
        LogUtil.error(logInfo, "张三","李四");
        
        LogUtil.error(Module.USER, "增加用户[{}]成功", "张三");
        
        LogUtil.error(Module.USER, OperAction.ADD, "增加用户[{}]成功", "张三");

        LogUtil.error(Module.USER, "增加用户出错:", e);
        
        return "done";
      
    }
}
