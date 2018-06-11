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
package saaya.murakami.mylasta.direction;

import java.util.List;

import javax.annotation.Resource;

import saaya.murakami.mylasta.direction.sponsor.BatchApiFailureHook;
import saaya.murakami.mylasta.direction.sponsor.BatchListedClassificationProvider;
import org.lastaflute.db.dbflute.classification.ListedClassificationProvider;
import org.lastaflute.thymeleaf.ThymeleafRenderingProvider;
import org.lastaflute.web.api.ApiFailureHook;
import org.lastaflute.web.direction.FwWebDirection;
import org.lastaflute.web.ruts.renderer.HtmlRenderingProvider;

/**
 * @author jflute
 */
public class BatchFwAssistantDirector extends KakeibochanFwAssistantDirector {

    @Resource
    private BatchConfig config;

    @Override
    protected void setupAppConfig(List<String> nameList) {
        nameList.add("batch_config.properties"); // base point
        nameList.add("batch_env.properties");
    }

    @Override
    protected void setupAppMessage(List<String> nameList) {
        nameList.add("batch_message"); // base point
        nameList.add("batch_label");
    }

    @Override
    protected ListedClassificationProvider createListedClassificationProvider() {
        return new BatchListedClassificationProvider();
    }

    @Override
    protected void prepareWebDirection(FwWebDirection direction) {
        super.prepareWebDirection(direction);
        direction.directHtmlRendering(createHtmlRenderingProvider());
    }

    protected HtmlRenderingProvider createHtmlRenderingProvider() {
        return new ThymeleafRenderingProvider().asDevelopment(config.isDevelopmentHere());
    }

    @Override
    protected ApiFailureHook createApiFailureHook() {
        return new BatchApiFailureHook();
    }
}
