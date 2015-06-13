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
package com.rinxor.example.spring.mvc.controller;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
import com.rinxor.example.spring.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("create")
public class CreateController {

    @RequestMapping(method = RequestMethod.GET)
    void getInitialMessage() {

    }

    @RequestMapping(method = RequestMethod.POST)
    public @ModelAttribute("message")
    String create(User user) {
        return "A new user [ user = " + user.getUsername() + ", FirstName = " + user.getLastName() +", LastName = " + user.getLastName() + "] has been created successfully";
    }
}
