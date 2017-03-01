package com.yc256.proxy.config;

import junit.framework.TestCase;

/**
 * ConfigurationScannerTest
 *
 * @author hzzjb
 */
public class ConfigurationScannerTest extends TestCase {
    public void testScan() throws Exception {
        ConfigurationScanner configurationScanner = new ConfigurationScanner();
        try {
            configurationScanner.scan("E:\\work\\export\\test.xml");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}