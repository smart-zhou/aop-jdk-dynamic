package com.yc256.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * AbstractHandler.
 *
 * @author Smart Zhou
 */
public abstract class AbstractHandler implements InvocationHandler {

    /**
     * The target object.
     */
    private Object targetObject;

    /**
     * The aop class
     */
    private Class aopClass;

    /**
     * The aop method
     */
    private Method aopMethod;

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Class getAopClass() {
        return aopClass;
    }

    public void setAopClass(Class aopClass) {
        this.aopClass = aopClass;
    }

    public Method getAopMethod() {
        return aopMethod;
    }

    public void setAopMethod(Method aopMethod) {
        this.aopMethod = aopMethod;
    }

    protected void handleExecute(Object proxy, Method method, Object[] args) throws Throwable {
        getAopMethod().invoke(aopClass.newInstance(), args);
    }
}
