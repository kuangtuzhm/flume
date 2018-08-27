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
 * @FileName Module.java
 * @Description: 
 *
 * @Date 2018年8月24日 上午9:26:25
 * @author Zhao Haiming
 * @version 1.0
 */
public enum LogLevel {

    DEBUG("debug"),INFO("info"),WARN("warn"),ERROR("error");
    
    private String name;
    
    private LogLevel(String name)
    {
        this.name = name;
    }
    
    // get set 方法
    public String getName() {
        return name;
    }
}
