/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvores;

/**
 *
 * @author EriikD
 */
public class No<T> {
    
    private T nome;
    private No<T> filhoEsquerdo;
    private No<T> filhoDireito;
    private No<T> pai;

    public No(T nome, No<T> pai) {
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

    public No<T> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No<T> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No<T> getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No<T> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No<T> getPai() {
        return pai;
    }

    public void setPai(No<T> pai) {
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
