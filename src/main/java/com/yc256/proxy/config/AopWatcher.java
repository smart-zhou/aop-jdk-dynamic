package com.yc256.proxy.config;

import java.util.Map;

/**
 * AopWatcher
 *
 * @author Smart Zhou
 */
public class AopWatcher {
    private Class clazz;

    private Map<AopAdviceEnum, String> aopMethods;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Map<AopAdviceEnum, String> getAopMethods() {
        return aopMethods;
    }

    public void setAopMethods(Map<AopAdviceEnum, String> aopMethods) {
        this.aopMethods = aopMethods;
    }
}
