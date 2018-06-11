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
package saaya.murakami.app.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.lastaflute.job.LaJob;
import org.lastaflute.job.LaJobRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakeiboJob implements LaJob {

    private static final Logger logger = LoggerFactory.getLogger(KakeiboJob.class);

    // ===================================================================================
    //                                                                             Job Run
    //                                                                             =======
    @Override
    public void run(LaJobRuntime runtime) { // exception job!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = inputNumber("入力してね", reader);
        System.out.println(num);

        try {
            reader.reset();
        } catch (IOException e) {}
    }

    private int inputNumber(String message, BufferedReader reader) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        do {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
            } catch (IOException e) {
                throw new RuntimeException("エラー", e);
            }
        } while (true);
    }
}
