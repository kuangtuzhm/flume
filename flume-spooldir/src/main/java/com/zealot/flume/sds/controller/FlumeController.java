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
    
    //输出统一采集的业务日志或者监控日志
    private final static Logger flumeLog = LoggerFactory.getLogger("flumelog");
    
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
        
        logger.warn(json);
        flumeLog.info(json);
        return "done";
      
    }
}
