/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jpa.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author miolivc
 */

@Named
@SessionScoped
public class PessoaController implements Serializable {
    
    @EJB
    private PessoaService service;
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String add() {
        Pessoa pessoa = new Pessoa(id, nome);
        service.addPessoa(pessoa);
        return null;
    }
    
    public List<Pessoa> list() {
        return service.list();
    }
}
