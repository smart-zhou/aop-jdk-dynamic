package com.yc256.proxy.beans;

/**
 * AopAction
 *
 * @author Smart Zhou
 */
public class AopAction {
    public void beforePrint() {
        System.out.println(this.getClass() + "-before");
    }

    public void afterPrint() {
        System.out.println(this.getClass() + "-after");
    }
}
