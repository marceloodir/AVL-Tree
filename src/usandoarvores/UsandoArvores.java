/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoarvores;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marcelo
 */
public class UsandoArvores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        Random gerador = new Random();
        
        Tree raiz = new Tree(50);
        ///*
        for(i=0;i<5;i++) {
            Tree av = new Tree(gerador.nextInt(100));
            raiz.inserirNo(av);
            
            System.out.println("**********valor: "+av.getValor());
            System.out.println("**********fb: "+raiz.getFatorBalanceamento());
        }
        //*/
        /*
        raiz.inserirNo(new Tree(11));
        raiz.inserirNo(new Tree(9));
        raiz.inserirNo(new Tree(12));
        raiz.inserirNo(new Tree(13));

        
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Entre o valor a ser procurado: ");
        int valor = reader.nextInt();
        
        raiz.procurar(valor);
        */
         System.out.println("*fb ramo direito: "+raiz.getRamoDireito().getFatorBalanceamento());
         System.out.println("*fb ramo esquerdo: "+raiz.getRamoEsquerdo().getFatorBalanceamento());
         
    }
    
}
