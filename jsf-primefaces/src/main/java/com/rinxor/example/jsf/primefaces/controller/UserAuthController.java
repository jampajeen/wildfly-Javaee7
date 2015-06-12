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
package com.rinxor.example.jsf.primefaces.controller;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */

import com.rinxor.example.jsf.primefaces.model.Staff;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userAuth")
@SessionScoped
public class UserAuthController implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent event) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        
        Staff staff = new Staff();
        if (staff.getUsername().equals(this.username) && staff.getPassword().equals(this.password)) {
            
            session.setAttribute("Staff", staff);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", this.username);
            
            try {
                facesContext.getExternalContext().redirect("index.xhtml");
                
            } catch (IOException ex) {
                
            }   
        }

        facesContext.addMessage(null, message);
    }

    public void logout() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.invalidate();
            
            facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/login.xhtml");

        } catch (IOException ex) {
            Logger.getLogger(UserAuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
