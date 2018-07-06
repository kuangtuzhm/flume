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
 * 2018年7月6日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.log.bean;

/**
 * @FileName OperLogBean.java
 * @Description: 
 *
 * @Date 2018年7月6日 上午11:22:40
 * @author Zhao Haiming
 * @version 1.0
 */
public class OperLogBean {

    private int userId;
    
    private int operAction;
    
    private String projectId;
    
    private String operObj;
    
    private String operatorDesc;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOperAction() {
        return operAction;
    }

    public void setOperAction(int operAction) {
        this.operAction = operAction;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOperObj() {
        return operObj;
    }

    public void setOperObj(String operObj) {
        this.operObj = operObj;
    }

    public String getOperatorDesc() {
        return operatorDesc;
    }

    public void setOperatorDesc(String operatorDesc) {
        this.operatorDesc = operatorDesc;
    }
}
