/*
 * Copyright 2022 helloapp project
 * 
 * Website: https://github.com/lambdaprime
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package id.bootstrap.helloapp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import id.xfunction.cli.CommandLineInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class HelloAppTest {

    @Test
    public void test() {
        HelloApp.main(null);
        Assertions.assertTrue(true);

        var cli = mock(CommandLineInterface.class);
        when(cli.askConfirm(any())).thenReturn(true);
        var capture = ArgumentCaptor.forClass(String.class);

        var confirmed = cli.askConfirm("1");
        cli.print("Hello");

        verify(cli, atLeastOnce()).print(capture.capture());
        Assertions.assertEquals("Hello", capture.getValue().toString());
        Assertions.assertEquals(true, confirmed);
    }
}
