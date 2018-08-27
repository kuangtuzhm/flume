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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.springframework.util.StringUtils;

/**
 * @FileName IpUtil.java
 * @Description: 
 *
 * @Date 2018年8月24日 下午4:52:52
 * @author Zhao Haiming
 * @version 1.0
 */
public class IpUtil {
    
    private static String ip ;

    /**
     * 获取服务器地址
     *
     * @return Ip地址
     */
    public static String getServerIp() {
        // 获取操作系统类型
        if(StringUtils.isEmpty(ip))
        {
            String sysType = System.getProperties().getProperty("os.name");
            if (sysType.toLowerCase().startsWith("win")) {  // 如果是Windows系统，获取本地IP地址
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException e) {
                    ip = "获取服务器IP错误";
                }
            } else {
                ip = getIpByEthNum("eth0"); // 兼容Linux
            }
        }
        return ip;
    }

    /**
     * 根据网络接口获取IP地址
     * @param ethNum 网络接口名，Linux下是eth0
     * @return
     */
    private static String getIpByEthNum(String ethNum) {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (ethNum.equals(netInterface.getName())) {
                    Enumeration addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = (InetAddress) addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            //logger.error(e.getMessage(), e);
        }
        return "获取服务器IP错误";
    }
    
    public static void main(String [] args)
    {
        String ip = getServerIp();
        System.out.println(ip);
    }
}
