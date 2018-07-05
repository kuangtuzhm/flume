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

package com.zealot.flume.logAppend.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    private final static Logger logger = LoggerFactory.getLogger(FlumeController.class);    
    
    @RequestMapping(value = "/stu")
    @ResponseBody
    public String stu(HttpServletRequest req){
        
        logger.warn("{'oper':'add','imei':'123456789123456'}");
        return "done";
      
    }
}
