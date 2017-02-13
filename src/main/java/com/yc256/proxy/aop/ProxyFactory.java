package com.yc256.proxy.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * ProxyFactory a factory for creating Proxy objects.
 *
 * @author Smart Zhou
 */
public class ProxyFactory {

    /**
     * Gets the proxy.
     *
     * @param targetObject the target object
     * @param handlers     the handlers
     * @return the proxy
     */
    public static Object getProxy(Object targetObject,
                                  List<AbstractHandler> handlers) {
        Object proxyObject = null;
        if (handlers.size() > 0) {
            proxyObject = targetObject;
            for (int i = 0; i < handlers.size(); i++) {
                handlers.get(i).setTargetObject(proxyObject);
                proxyObject = Proxy.newProxyInstance(targetObject.getClass()
                        .getClassLoader(), targetObject.getClass()
                        .getInterfaces(), handlers.get(i));
            }
            return proxyObject;
        } else {
            return targetObject;
        }
    }

    public static Object getProxy(Object targetObject) throws Throwable {
        Class clazz = Class.forName("com.yc256.proxy.beans.AopAction");
        AbstractHandler afterHandler = new AfterHandler();
        afterHandler.setAopClass(clazz);
        Method method1 = clazz.getMethod("afterPrint");
        afterHandler.setAopMethod(method1);
        AbstractHandler beforeHandler = new BeforeHandler();
        beforeHandler.setAopClass(clazz);
        Method method2 = clazz.getMethod("beforePrint");
        beforeHandler.setAopMethod(method2);
        List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
        handlers.add(beforeHandler);
        handlers.add(afterHandler);
        return getProxy(targetObject, handlers);
    }
}
