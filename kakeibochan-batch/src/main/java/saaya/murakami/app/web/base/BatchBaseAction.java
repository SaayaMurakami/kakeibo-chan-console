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
package saaya.murakami.app.web.base;

import javax.annotation.Resource;

import org.dbflute.optional.OptionalThing;
import org.lastaflute.web.login.LoginManager;
import org.lastaflute.web.ruts.process.ActionRuntime;
import org.lastaflute.web.validation.ActionValidator;
import org.lastaflute.web.validation.LaValidatable;

import saaya.murakami.app.web.base.login.BatchLoginAssist;
import saaya.murakami.mylasta.action.BatchHtmlPath;
import saaya.murakami.mylasta.action.BatchMessages;
import saaya.murakami.mylasta.action.BatchUserBean;
import saaya.murakami.mylasta.direction.BatchConfig;

/**
 * @author jflute
 */
public abstract class BatchBaseAction extends KakeibochanBaseAction // has several interfaces for direct use
        implements LaValidatable<BatchMessages>, BatchHtmlPath {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The application type for ORLeans, e.g. used by access context. */
    protected static final String APP_TYPE = "ORL"; // #change_it_first

    /** The user type for Member, e.g. used by access context. */
    protected static final String USER_TYPE = "M"; // #change_it_first (can delete if no login)

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private BatchConfig config;
    @Resource
    private BatchLoginAssist loginAssist;

    // ===================================================================================
    //                                                                               Hook
    //                                                                              ======
    // #app_customize you can customize the action hook
    @Override
    public void hookFinally(ActionRuntime runtime) {
        super.hookFinally(runtime);
    }

    // ===================================================================================
    //                                                                           User Info
    //                                                                           =========
    // -----------------------------------------------------
    //                                      Application Info
    //                                      ----------------
    @Override
    protected String myAppType() { // for framework
        return APP_TYPE;
    }

    // -----------------------------------------------------
    //                                            Login Info
    //                                            ----------
    // #app_customize return empty if login is unused
    @Override
    protected OptionalThing<BatchUserBean> getUserBean() { // application may call, overriding for co-variant
        return loginAssist.getSavedUserBean();
    }

    @Override
    protected OptionalThing<String> myUserType() { // for framework
        return OptionalThing.of(USER_TYPE);
    }

    @Override
    protected OptionalThing<LoginManager> myLoginManager() { // for framework
        return OptionalThing.of(loginAssist);
    }

    // ===================================================================================
    //                                                                          Validation
    //                                                                          ==========
    @SuppressWarnings("unchecked")
    @Override
    public ActionValidator<BatchMessages> createValidator() { // for co-variant
        return super.createValidator();
    }

    @Override
    public BatchMessages createMessages() { // application may call
        return new BatchMessages(); // overriding to change return type to concrete-class
    }
}
