/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jpa.web;

import java.util.Collections;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author miolivc
 */

@Stateful
public class PessoaService {
    
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager manager;
    
    public void addPessoa(Pessoa pessoa) {
        manager.persist(this);
    }
    
    public List<Pessoa> list() {
        return Collections.unmodifiableList(
                manager.createQuery("SELECT * FROM PESSOA")
                .getResultList());
    }
    
}
