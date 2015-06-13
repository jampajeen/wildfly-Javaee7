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
package com.rinxor.example.jpa.hibernate.jsf.session;

import com.rinxor.example.jpa.hibernate.jsf.entity.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> {
    @PersistenceContext(unitName = "com.rinxor.example_jpa-hibernate-jsf_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffFacade() {
        super(Staff.class);
    }
    
}
