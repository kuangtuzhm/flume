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
 * 2018年2月2日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.flume.statistics.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zealot.flume.log.bean.StatisticsBean;
import com.zealot.flume.statistics.auth.AccessTokenMap;
import com.zealot.flume.statistics.util.IPUtil;

/**
 * @FileName IGacontroller.java
 * @Description: 
 *
 * @Date 2018年2月2日 上午9:23:03
 * @author Li.Shangzhi
 * @version 1.0
 */
@Controller  
@RequestMapping("/iga")  
public class IGacontroller {
	
    //输出统一采集的业务日志或者监控日志
    private final static Logger flumeLog = LoggerFactory.getLogger("flumelog");
	
	
	/**
	 * @Title: analysis 
	 * @Description:
	 * @param args
	 * @param response
	 * @throws IOException
	 * @author Li.Shangzhi
	 * @date 2018年2月1日 下午6:12:17
	 */
	@RequestMapping(value = "log.gif")  
	public void analysis(HttpServletRequest request, HttpServletResponse response, StatisticsBean args) throws IOException {  
		
		boolean auth = false;
		//用户验证
		if(!StringUtils.isEmpty(args.getAccount()))
		{
			StringBuffer url = request.getRequestURL();
			String domain = url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
			auth = AccessTokenMap.auth(args.getAccount(), domain);
			args.setDomain(domain);
		}
		if(auth)
		{
			//日志收集   
		    //客户端信息
	        String ip = IPUtil.getIpAddr(request);
	        //String userAgent = request.getHeader("User-Agent");
	        args.setRemoteIp(ip);
	        //args.setUserAgent(userAgent);
			args.setCreateTime(new Date());

			String s = JSON.toJSONString(args);

		}
		response.setHeader("Pragma", "No-cache");  
		response.setHeader("Cache-Control", "no-cache");           
		response.setDateHeader("Expires", 0);  
		response.setContentType("image/gif");  
		OutputStream out = response.getOutputStream();  
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);  
		ImageIO.write(image, "gif", out); 
		out.flush();
		
	}  
}
