/*
 * Copyright 2016 Thitipong Jampajeen <jampajeen@gmail.com>.
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

package com.rinxor.example.jax.ws.servlet;

import com.rinxor.example.jax.ws.client.CalculatorWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;


/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
@WebServlet("CalculatorClientServlet")
public class CalculatorClientServlet extends HttpServlet {
    
    @WebServiceRef(wsdlLocation = "http://localhost:8080/jax-ws-service-1.0-SNAPSHOT/CalculatorWS/CalculatorWS?wsdl")
    private CalculatorWS_Service service;
   
    
    private int calculateAdd(int i, int j) {
        com.rinxor.example.jax.ws.client.CalculatorWS port =  service.getCalculatorWSPort();
        return port.add(i, j);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet CalculatorClientServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorClientServlet at " + request.getContextPath () + "</h1>");
            out.println("<p> 3 + 2 = " + calculateAdd(3, 2) + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e) {
            
        }

    }
}
