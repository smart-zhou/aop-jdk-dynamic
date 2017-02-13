package com.yc256.proxy.beans;

/**
 * CalculatorImpl.
 *
 * @author Smart Zhou
 */
public class CalculatorImpl implements Calculator {

    /* (non-Javadoc)
     * @see Calculator#calculate(int, int)
     */
    @Override
    public int calculate(int a, int b) {
        System.out.println("**********Actual Method Execution**********");
        return a / b;
    }

}
