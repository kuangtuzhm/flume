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
 * 2018年8月27日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.log.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @FileName StatisticsBean.java
 * @Description: 
 *
 * @Date 2018年8月27日 下午2:10:31
 * @author Zhao Haiming
 * @version 1.0
 */
public class StatisticsBean implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6947824633652617914L;
    
    /**
     * 校验的账号
     */
    private String account;

    /**
     * 项目标识
     */
    private String projectId;
    
    /**
     * 请求uri
     */
    private String uri;
    
    /**
     * 参数
     */
    private String params;
    
    /**
     * 响应时间 毫秒
     */
    private int procTime;
    
    /**
     * 响应成功，失败(1成功 0失败)
     */
    private int resultCode;
    
    /**
     * 浏览器信息
     */
    private String browser;
    
    /**
     * 客户端类型web,app
     */
    private String clientType;
    
    /**
     * 手机型号
     */
    private String mobileType;
    
    /**
     * 用户ip
     */
    private String remoteIp;
    
    /**
     * userAgent
     */
    private String userAgent;
    
    private Date createTime;
    
    /**
     * 统计来源项目的domain
     */
    private String domain;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getProcTime() {
        return procTime;
    }

    public void setProcTime(int procTime) {
        this.procTime = procTime;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
