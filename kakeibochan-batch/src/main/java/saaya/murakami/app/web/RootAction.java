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
package saaya.murakami.app.web;

import javax.annotation.Resource;

import org.lastaflute.job.JobManager;
import org.lastaflute.job.LaScheduledJob;
import org.lastaflute.job.key.LaJobUnique;
import org.lastaflute.web.Execute;
import org.lastaflute.web.login.AllowAnyoneAccess;
import org.lastaflute.web.response.JsonResponse;
import org.lastaflute.web.servlet.request.ResponseManager;

import saaya.murakami.app.job.KakeiboJob;
import saaya.murakami.app.web.base.BatchBaseAction;

/**
 * @author jflute
 */
@AllowAnyoneAccess
public class RootAction extends BatchBaseAction {

    @Resource
    JobManager jobManager;

    @Resource
    ResponseManager responseManager;

    @Execute
    public JsonResponse index() {
        LaScheduledJob job =
                jobManager.findJobByUniqueOf(LaJobUnique.of(KakeiboJob.class.getSimpleName())).orElseTranslatingThrow(cause -> {
                    return responseManager.new400("NG");
                });

        job.launchNow();
        return JsonResponse.asJsonDirectly("OK");
    }
}
