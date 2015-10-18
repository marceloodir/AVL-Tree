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
        //verificar se a arvore nao tem filho
        if(tree.valor > this.valor) {
            return inserirNoDireita(tree);
        }else{
            if(tree.valor < this.valor) {
             return  inserirNoEsquerda(tree);
            }
        }
        return true;
    }
    
    public Tree procurar(int valor) {
        if(valor > this.valor) {
            return procurarDireita(valor);
        }else{
            if(valor < this.valor) {
                return procurarEsquerda(valor);
            }else{
                return this;
                //System.out.println("Encontrado");
            }
        }
    }
    
    private Tree procurarDireita(int valor) {
        if(this.ramoDireito != null) {
            return this.ramoDireito.procurar(valor);
        }else{
            return null;
        }
    }
    
    private Tree procurarEsquerda(int valor) {
        if(this.ramoEsquerdo != null) {
            return this.ramoEsquerdo.procurar(valor);
        }else{
            return null;
        }
    }
    
    private boolean inserirNoDireita(Tree tree) {
        if(this.ramoDireito == null) {
            this.ramoDireito = tree;
            this.ramoDireito.setPai(this);
            this.fatorBalanceamento = this.fatorBalanceamento -1;
            verificarBalanceamento();
            return this.fatorBalanceamento == 0; 
        }else{
            if(!this.ramoDireito.inserirNo(tree)) {
                this.fatorBalanceamento = this.fatorBalanceamento -1;
                verificarBalanceamento();
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
            verificarBalanceamento();
            return this.fatorBalanceamento == 0;   
        }else{
            if(!this.ramoEsquerdo.inserirNo(tree)) {
                this.fatorBalanceamento = this.fatorBalanceamento +1;
                verificarBalanceamento();
                return this.fatorBalanceamento == 0;
            }else{
                return true;
            }
        }
    }
    
    private void verificarBalanceamento() {
        if(this.fatorBalanceamento > 1 || this.fatorBalanceamento < -1) {
            //rodar balanceamento
            //balancear();
            System.out.println("nó "+this.valor+": está desbalanceada");
            System.out.println("FB: "+this.fatorBalanceamento);
        }
    }
    
    public void removerNo(Tree tree) {
        Tree encontrada = procurar(tree.getValor());
        if (encontrada != null) {
            if(encontrada.getRamoDireito() == null && encontrada.getRamoEsquerdo() == null) {
                removerNoSemFilho(encontrada);
            }else{
                if(encontrada.getRamoDireito() != null && encontrada.getRamoEsquerdo() != null) {
                    removerNoComDoisFilhos(encontrada);
                }else{
                    removerNoComUmFilho(encontrada);
                }
            }
        }else{
            System.out.println("Nó não existe nesta arvore");
        }
    }
    
    private void removerNoSemFilho(Tree tree) {
        
    }
    
    private void removerNoComUmFilho(Tree tree) {
        
    }
    
    private void removerNoComDoisFilhos(Tree tree) {
        
    }
    
    private void balancear() {
        //ainda será implementado
    }
    
    private void simplesDireita() {
        //ainda será implementado
    }
    
    private void simplesEsquerda() {
        //ainda será implementado
    }
    
    private void duplaDireita() {
        //ainda será implementado
    }
    
    private void duplaEsquerda() {
        //ainda será implementado
    }
    
}
