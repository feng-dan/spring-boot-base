package com.company.project.core;

/**
 * 服务接口类
 *
 * @author 冯丹
 */
public interface BaseErrorInfoInterface {

    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
