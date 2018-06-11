/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package saaya.murakami.mylasta;

import org.dbflute.utflute.lastaflute.police.InjectedResourceDefinitionPolice;
import org.dbflute.utflute.lastaflute.police.LastaPresentsSomethingPolice;
import org.dbflute.utflute.lastaflute.police.NonActionExtendsActionPolice;
import org.dbflute.utflute.lastaflute.police.NonWebHasWebReferencePolice;
import org.dbflute.utflute.lastaflute.police.WebPackageNinjaReferencePolice;
import saaya.murakami.unit.UnitCommonPjTestCase;

/**
 * @author jflute
 */
public class KakeibochanActionDefTest extends UnitCommonPjTestCase {

    public void test_nonActionExtendsAction() throws Exception {
        policeStoryOfJavaClassChase(new NonActionExtendsActionPolice());
    }

    public void test_nonWebHasWebReference() throws Exception {
        policeStoryOfJavaClassChase(new NonWebHasWebReferencePolice());
    }

    public void test_webPackageNinjaReferencePolice() throws Exception {
        policeStoryOfJavaClassChase(new WebPackageNinjaReferencePolice());
    }

    public void test_injectedResourceDefinitionPolice() throws Exception {
        policeStoryOfJavaClassChase(new InjectedResourceDefinitionPolice().shouldBePrivateField(field -> {
            return true; // means all fields
        }));
    }

    public void test_lastaPresentsSomethingPolice() throws Exception {
        policeStoryOfJavaClassChase(new LastaPresentsSomethingPolice());
    }
}