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
 * 2018年8月24日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.flume.log.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zealot.flume.log.bean.LogInfo;
import com.zealot.flume.log.enums.LogLevel;
import com.zealot.flume.log.enums.Module;
import com.zealot.flume.log.enums.OperAction;

/**
 * @FileName LogUtil.java
 * @Description: 
 *
 * @Date 2018年8月24日 上午9:20:38
 * @author Zhao Haiming
 * @version 1.0
 */
@Service
public class LogUtil {

    //输出统一采集的业务日志或者监控日志
    private final static Logger flumeLog = LoggerFactory.getLogger("flumelog");
    
    private static String projectId;
    
    public static void debug(LogInfo logInfo, Object...params)
    {
        logInfo.setLevel(LogLevel.DEBUG.getName());
        String info = JSON.toJSONString(logInfo);
        flumeLog.debug(info, params);
    }
    
    /**
     * @Title: debug 
     * @Description:
     * @param module
     * @param content 
     * @param params 如果content里边有{}这种匹配的占位符，则parmas用来替换
     * @author Zhao Haiming
     * @date 2018年8月24日 下午5:52:11
     */
    public static void debug(Module module, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.DEBUG, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.debug(info, params);
    }
    
    public static void debug(Module module, String msg, Throwable t)
    {
        String content = getExceptionString(t);
        if(msg != null)
        {
            content = msg+content;
        }
        LogInfo logInfo = getLogInfo(module, LogLevel.DEBUG, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.debug(info);
    }
    
    public static void debug(Module module, OperAction operAction, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.DEBUG, content);
        logInfo.setOperAction(operAction.getAction());
        String info = JSON.toJSONString(logInfo);
        flumeLog.debug(info, params);
    }
    
    public static void info(LogInfo logInfo, Object...params)
    {
        logInfo.setLevel(LogLevel.INFO.getName());
        String info = JSON.toJSONString(logInfo);
        flumeLog.info(info, params);
    }
    
    public static void info(Module module, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.INFO, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.info(info, params);
    }
    
    public static void info(Module module, String msg, Throwable t)
    {
        String content = getExceptionString(t);
        if(msg != null)
        {
            content = msg+content;
        }
        LogInfo logInfo = getLogInfo(module, LogLevel.INFO, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.info(info);
    }
    
    public static void info(Module module, OperAction operAction, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.INFO, content);
        logInfo.setOperAction(operAction.getAction());
        String info = JSON.toJSONString(logInfo);
        flumeLog.info(info, params);
    }
    
    public static void warn(LogInfo logInfo, Object...params)
    {
        logInfo.setLevel(LogLevel.WARN.getName());
        String info = JSON.toJSONString(logInfo);
        flumeLog.warn(info, params);
    }
    
    public static void warn(Module module, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.WARN, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.warn(info, params);
    }
    
    public static void warn(Module module, String msg, Throwable t)
    {
        String content = getExceptionString(t);
        if(msg != null)
        {
            content = msg+content;
        }
        LogInfo logInfo = getLogInfo(module, LogLevel.WARN, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.warn(info);
    }
    
    public static void warn(Module module, OperAction operAction, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.WARN, content);
        logInfo.setOperAction(operAction.getAction());
        String info = JSON.toJSONString(logInfo);
        flumeLog.warn(info, params);
    }
    
    public static void error(LogInfo logInfo, Object...params)
    {
        logInfo.setLevel(LogLevel.ERROR.getName());
        String info = JSON.toJSONString(logInfo);
        flumeLog.error(info, params);
    }
    
    public static void error(Module module, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.ERROR, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.error(info, params);
    }
    
    public static void error(Module module, String msg, Throwable t)
    {
        String content = getExceptionString(t);
        if(msg != null)
        {
            content = msg+content;
        }
        LogInfo logInfo = getLogInfo(module, LogLevel.ERROR, content);
        String info = JSON.toJSONString(logInfo);
        flumeLog.error(info);
    }
    
    public static void error(Module module, OperAction operAction, String content, Object...params)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.ERROR, content);
        logInfo.setOperAction(operAction.getAction());
        String info = JSON.toJSONString(logInfo);
        flumeLog.error(info, params);
    }
    
    /**
     * @Title: getLogInfo 
     * @Description: 获取一个LogInfo对象
     * @param module
     * @param content
     * @return 
     * @author Zhao Haiming
     * @date 2018年8月24日 下午5:53:21
     */
    public static LogInfo getLogInfo(Module module, String content)
    {
        LogInfo logInfo = getLogInfo(module, LogLevel.DEBUG, content);
        
        return logInfo;
    }
    
    private static LogInfo getLogInfo(Module module, LogLevel level, String content)
    {
        LogInfo logInfo = new LogInfo();
        logInfo.setUuid(UUIDUtil.getUUID32());
        logInfo.setModule(module.getName());
        logInfo.setContent(content);
        
        logInfo.setLevel(level.getName());
        logInfo.setProjectId(projectId);
        logInfo.setServerIp(IpUtil.getServerIp());
        logInfo.setCreateTime(new Date());
        
        return logInfo;
    }
    
    private static String getExceptionString(Throwable e)
    {
        String  expMessage = null;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            e.printStackTrace(new PrintWriter(buf, true));
            expMessage = buf.toString();
        }finally
        {
           try {
            buf.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        }
        return expMessage;
    }

    @Value("${spring.application.name}")
    public void setProjectId(String projectId) {
        LogUtil.projectId = projectId;
    }
    
    
}
