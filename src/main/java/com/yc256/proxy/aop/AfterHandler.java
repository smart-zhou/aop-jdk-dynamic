package com.yc256.proxy.aop;

import java.lang.reflect.Method;

/**
 * AfterHandler
 *
 * @author Smart Zhou
 */
public class AfterHandler extends AbstractHandler {

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(getTargetObject(), args);
        handleExecute(proxy, method, new Object[]{});
        return result;
    }
}
