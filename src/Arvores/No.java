/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

import java.util.Objects;

/**
 *
 * @author EriikD
 */
public class No<T> {
    
    private T nome;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;

    public No(T nome, No pai) {
        this.nome = nome;
        this.pai = pai;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
    }

    public No(T nome) {
        this(nome, null);
    }
    
    public boolean possuiFilhoEsquerdo(){
        return this.filhoEsquerdo != null;
    }
    
    public boolean possuiFilhoDireito(){
        return this.filhoDireito != null;
    }
    
    public boolean possuiPai(){
        return this.pai != null;
    }
    
    public T getNome() {
        return nome;
    }

    public void setNome(T nome) {
        this.nome = nome;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        No<T> other = (No<T>) obj;
        
        return this.nome == other.nome;
    }

    
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nome: ").append(this.nome);
        return string.toString();
    }
    
    
}
