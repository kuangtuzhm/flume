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

package com.zealot.flume.log.enums;

/**
 * @FileName OperAction.java
 * @Description: 
 *
 * @Date 2018年8月24日 上午9:26:25
 * @author Zhao Haiming
 * @version 1.0
 */
public enum OperAction {

    /**
     * 操作日志类型 1-->登陆 2-->添加 3-->修改 4-->删除(除软删除) 业务根据项目情况定义为静态变量或者enum,禁止在代码中各自写
     */
    LOGIN(1),ADD(2),EDIT(3),DELETE(4);
    
    private int action;
    
    private OperAction(int action)
    {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
}
