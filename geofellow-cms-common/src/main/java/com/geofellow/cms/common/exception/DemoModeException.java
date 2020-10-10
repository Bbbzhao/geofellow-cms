package com.geofellow.cms.common.exception;

/**
 * 演示模式异常
 *
 * @author 
 */
public class DemoModeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage(){
        return "演示模式，禁止操作";
    }
}
