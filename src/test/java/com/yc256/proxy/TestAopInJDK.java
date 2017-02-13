package com.yc256.proxy;

import com.yc256.proxy.aop.ProxyFactory;
import com.yc256.proxy.beans.Calculator;
import com.yc256.proxy.beans.CalculatorImpl;

/**
 * The Test class to verify our own aop using JDK proxy.
 *
 * @author Smart Zhou
 */
public class TestAopInJDK {

    public static void main(String[] args) {
        CalculatorImpl calcImpl = new CalculatorImpl();
        Calculator proxy = null;
        try {
            proxy = (Calculator) ProxyFactory.getProxy(calcImpl);
            int result = proxy.calculate(20, 10);
            System.out.println("Final Result :::" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
