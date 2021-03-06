/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package deployment;

import com.hazelcast.jet.AbstractProcessor;

import static org.junit.Assert.fail;

public class LoadPersonAndCar extends AbstractProcessor {

    @Override
    public boolean complete() {
        ClassLoader cl = getClass().getClassLoader();
        try {
            cl.loadClass("com.sample.pojo.car.Car");
        } catch (ClassNotFoundException e) {
            fail();
        }
        try {
            cl.loadClass("com.sample.pojo.person.Person$Appereance");
        } catch (ClassNotFoundException ignored) {
            fail();
        }
        return true;
    }
}
