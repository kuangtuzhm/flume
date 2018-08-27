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

package com.zealot.flume.log.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @FileName LogInfo.java
 * @Description: 
 *
 * @Date 2018年8月24日 上午9:03:19
 * @author Zhao Haiming
 * @version 1.0
 */
public class LogInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 9148218598786634738L;

    private String uuid;
    
    /**
     * 项目标识
     */
    private String projectId;
    
    /**
     * 服务器ip
     */
    private String serverIp;
    
    /**
     * 操作模块，比如系统错误的输出统计模块。用户模块，设备模块等，业务根据项目情况定义为静态变量或者enum,禁止在代码中各自写
     */
    private String module;
    
    /**
     * 日志级别warn,error,info等
     */
    private String level;
    
    /**
     * 被操作的对象的主键，如用户id,设备imei等
     */
    private String operObj;
    
    /**
     * 日志信息
     */
    private String content;
    
    /**
     * 操作日志类型0-->普通业务日志 1-->登陆 2-->添加 3-->修改 4-->删除(除软删除)业务根据项目情况定义为静态变量或者enum,禁止在代码中各自写
     */
    private int operAction = 0;
    
    /**
     * 响应成功，失败(1成功 0失败)
     */
    private int resultCode = 1;
    
    /**
     * 时间
     */
    private Date createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOperObj() {
        return operObj;
    }

    public void setOperObj(String operObj) {
        this.operObj = operObj;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOperAction() {
        return operAction;
    }

    public void setOperAction(int operAction) {
        this.operAction = operAction;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}
