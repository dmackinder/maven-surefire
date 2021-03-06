package org.apache.maven.surefire.its.jiras;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.its.Not2xCompatible;
import org.apache.maven.surefire.its.fixture.SurefireJUnit4IntegrationTestCase;
import org.apache.maven.surefire.its.fixture.SurefireLauncher;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author Kristian Rosenvold
 */
@Category( Not2xCompatible.class )
public class Surefire735ForkFailWithRedirectConsoleOutputIT
    extends SurefireJUnit4IntegrationTestCase
{

    @Test
    public void vmStartFail()
        throws Exception
    {
        unpack().failNever().executeTest().verifyTextInLog( "Invalid maximum heap size: -Xmxxxx712743m" );
    }

    @Test
    public void vmStartFailShouldFailBuildk()
        throws Exception
    {
        unpack().maven().withFailure().executeTest();
    }

    public SurefireLauncher unpack()
    {
        return unpack( "fork-fail" );
    }

}
