/* Copyright 2022. All rights reserved */
package id.bootstrap.helloapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloAppTest {

    @Test
    public void test() {
        HelloApp.main(null);
        Assertions.assertTrue(true);
    }
}
