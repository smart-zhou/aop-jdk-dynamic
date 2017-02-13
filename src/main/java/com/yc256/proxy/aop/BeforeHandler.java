package com.yc256.proxy.aop;

import java.lang.reflect.Method;

/**
 * BeforeHandler
 *
 * @author Smart Zhou
 */
public class BeforeHandler extends AbstractHandler {

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleExecute(proxy, method, new Object[]{});
        return method.invoke(getTargetObject(), args);
    }
}
