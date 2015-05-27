/*
 * Copyright 2015 Thitipong Jampajeen <jampajeen@gmail.com>.
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
package com.rinxor.example.jspservlet.controller;

import com.rinxor.example.jspservlet.model.ExampleEntity;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
@Stateful
@Model // The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an EL name
public class ExampleController {

    private ExampleEntity entity;

    @Produces
    @Named
    public ExampleEntity getEntity() {
        return entity;
    }

    public void process() {
        try {

            System.out.println("Input Name : " + entity.getName());
            /*
            * Handle our business logic here
            */

        } catch (Exception e) {
            throw e;
        }
    }

    @PostConstruct
    public void initEntity() {
        entity = new ExampleEntity();
    }
}
