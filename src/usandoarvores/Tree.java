/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoarvores;

/**
 *
 * @author marcelo
 */
public class Tree {
    private Tree pai;
    private Tree ramoDireito;
    private Tree ramoEsquerdo;
    private int fatorBalanceamento;
    private int valor;

    public Tree(int valor) {
        this.valor = valor;
        this.fatorBalanceamento = 0;
        this.ramoDireito = null;
        this.ramoEsquerdo = null;
        this.pai = null;
    }

    public Tree getRamoDireito() {
        return ramoDireito;
    }

    public void setRamoDireito(Tree ramoDireito) {
        this.ramoDireito = ramoDireito;
    }

    public Tree getRamoEsquerdo() {
        return ramoEsquerdo;
    }

    public void setRamoEsquerdo(Tree ramoEsquerdo) {
        this.ramoEsquerdo = ramoEsquerdo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Tree getPai() {
        return pai;
    }

    public void setPai(Tree pai) {
        this.pai = pai;
    }
    
    
    
    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }
    
    
    
    public boolean inserirNo(Tree tree) {
        if(tree.valor > this.valor) {
            return inserirNoDireita(tree);
        }else{
            if(tree.valor < this.valor) {
             return  inserirNoEsquerda(tree);
            }
        }
        return true;
    }
    
    public void procurar(int valor) {
        if(valor > this.valor) {
            procurarDireita(valor);
        }else{
            if(valor < this.valor) {
                procurarEsquerda(valor);
            }else{
                System.out.println("Encontrado");
            }
        }
    }
    
    private void procurarDireita(int valor) {
        if(this.ramoDireito != null) {
            this.ramoDireito.procurar(valor);
        }else{
            System.out.println("valor não encontrado");
        }
    }
    
    private void procurarEsquerda(int valor) {
        if(this.ramoEsquerdo != null) {
            this.ramoEsquerdo.procurar(valor);
        }else{
            System.out.println("valor não encontrado");
        }
    }
    
    private boolean inserirNoDireita(Tree tree) {
        if(this.ramoDireito == null) {
            this.ramoDireito = tree;
            this.ramoDireito.setPai(this);
            this.fatorBalanceamento = this.fatorBalanceamento -1;
            return this.fatorBalanceamento == 0; 
        }else{
            if(!this.ramoDireito.inserirNo(tree)) {
                this.fatorBalanceamento = this.fatorBalanceamento -1;
                return this.fatorBalanceamento == 0;
            }else{
                return true;
            }
        }
    }
    
    private boolean inserirNoEsquerda(Tree tree) {
        if(this.ramoEsquerdo == null) {
            this.ramoEsquerdo = tree;
            this.ramoEsquerdo.setPai(this);
            this.fatorBalanceamento = this.fatorBalanceamento +1;
            return this.fatorBalanceamento == 0;   
        }else{
            if(!this.ramoEsquerdo.inserirNo(tree)) {
                this.fatorBalanceamento = this.fatorBalanceamento +1;
                return this.fatorBalanceamento == 0;
            }else{
                return true;
            }
        }
    }
    
    private void verificarBalanceamento() {
        if(this.fatorBalanceamento > 1 || this.fatorBalanceamento < -1) {
            //rodar balanceamento
            System.out.println("nó "+this.valor+": está desbalanceada");
            System.out.println("FB: "+this.fatorBalanceamento);
        }
    }
    
}
