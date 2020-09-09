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
public class No {
    
    private String nome;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;

    public No(String nome, No pai) {
        this.nome = nome;
        this.pai = pai;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
    }

    public No(String nome) {
        this(nome, null);
    }
    
    public boolean possuiFilhoEsquerdo(){
        return this.filhoEsquerdo != null;
    }
    
    public boolean possuiFilhoDireito(){
        return this.filhoDireito != null;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nome: ").append(this.nome);
        return string.toString();
    }
    
    
}
