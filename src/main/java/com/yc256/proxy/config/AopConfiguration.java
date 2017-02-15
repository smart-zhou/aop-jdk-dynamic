package com.yc256.proxy.config;

/**
 * AopConfiguration
 *
 * @author Smart Zhou
 */
public class AopConfiguration {
    private String basePackage; // 基础扫描包

    private String aopBeanClass; // 需做Aop增强的类,可空,表示包下所有类

    private String beforeMethod; // 前置增强方法

    private String afterMethod; // 后置增强方法

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getAopBeanClass() {
        return aopBeanClass;
    }

    public void setAopBeanClass(String aopBeanClass) {
        this.aopBeanClass = aopBeanClass;
    }

    public String getBeforeMethod() {
        return beforeMethod;
    }

    public void setBeforeMethod(String beforeMethod) {
        this.beforeMethod = beforeMethod;
    }

    public String getAfterMethod() {
        return afterMethod;
    }

    public void setAfterMethod(String afterMethod) {
        this.afterMethod = afterMethod;
    }
}
