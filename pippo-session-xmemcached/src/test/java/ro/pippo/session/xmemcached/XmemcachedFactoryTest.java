/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.pippo.session.xmemcached;

import java.io.IOException;
import net.rubyeye.xmemcached.CommandFactory;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ro.pippo.core.Application;

/**
 * @author Herman Barrantes
 */
@Ignore("You need run MemCached localy")
public class XmemcachedFactoryTest {

    private static Application application;

    @BeforeClass
    public static void setUpClass() {
        application = new Application();
    }

    /**
     * Test of create method, of class SpymemcachedUtil.
     */
    @Test
    public void testCreate_PippoSettings() throws IOException {
        System.out.println("create");
        MemcachedClient result = XmemcachedFactory.create(application.getPippoSettings());
        assertNotNull(result);
        assertFalse(result.isShutdown());
        result.shutdown();
        assertTrue(result.isShutdown());
    }

    /**
     * Test of create method, of class SpymemcachedUtil.
     */
    @Test
    public void testCreate_5args() throws IOException {
        System.out.println("create");
        String hosts = "localhost:11211";
        CommandFactory protocol = new BinaryCommandFactory();
        String user = "";
        String pass = "";
        String[] authMechanisms = new String[]{"PLAIN"};
        MemcachedClient result = XmemcachedFactory.create(hosts, protocol, user, pass, authMechanisms);
        assertNotNull(result);
        assertFalse(result.isShutdown());
        result.shutdown();
        assertTrue(result.isShutdown());
    }

}