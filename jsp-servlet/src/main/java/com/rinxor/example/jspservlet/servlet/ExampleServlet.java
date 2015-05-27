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
package com.rinxor.example.jspservlet.servlet;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
import com.rinxor.example.jspservlet.controller.ExampleController;
import com.rinxor.example.jspservlet.model.ExampleEntity;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class ExampleServlet extends HttpServlet {

    @Inject
    ExampleController service;

    public ExampleServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder errorMessage = new StringBuilder();

        /*
        * try process business logic in controller class
        */
        try {

            ExampleEntity entity = service.getEntity();
            
            String value = request.getParameter("name");
            entity.setName(value);
            
            service.process();
            
            request.setAttribute("infoMessage", entity.getName());

        } catch (Exception e) {
            errorMessage.append("Error: ").append(e.getMessage());

        } finally {

            request.setAttribute("errorMessage", errorMessage.toString());
            
            RequestDispatcher resultView = request.getRequestDispatcher("index.jsp");
            resultView.forward(request, response);
        }
    }

}
