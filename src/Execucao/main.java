/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import Arvores.ArvoreBinaria;

/**
 *
 * @author EriikD
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        ArvoreBinaria tree = new ArvoreBinaria();
        
        tree.adicionarNo(0, null, 'e');
        tree.adicionarNo(1, 0, 'd');
        tree.adicionarNo(2, 1, 'e');
        tree.adicionarNo(3, 1, 'd');
        tree.adicionarNo(4, 2, 'e');
        tree.adicionarNo(5, 4, 'd');
        tree.adicionarNo(6, 3, 'd');
        
        
        System.out.println(tree.consultarExistenciaNo(4));
        System.out.println(tree.grauNo(3));
        System.out.println(tree.profundidadeNo(3));
        System.out.println(tree.alturaNo(0));
        System.out.println(tree.nivelNo(4));
        
    }
    
}
