package com.mycompany.grafos;

public class Vertice {
    
    private int valor;
    public Vertice(int valor) {
        this.valor = valor;  
    }
    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Vértice de chave: "+this.getValor();
    }
    

}