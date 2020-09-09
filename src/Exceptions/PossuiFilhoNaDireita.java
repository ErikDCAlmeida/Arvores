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
public class PossuiFilhoNaDireita extends Exception{
    
    @Override
    public String getMessage() {
        return "O nó pai já possui filho na sua direita!";
    }
    
}
