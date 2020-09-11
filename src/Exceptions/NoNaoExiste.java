/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author EriikD
 */
public class NoNaoExiste extends Exception{

    private String info;
    
    public NoNaoExiste(String info) {
        this.info = info;
    }
    
    @Override
    public String getMessage() {
        return "O nó com elemento '" + this.info + "' não existe!";
    }
    
}
