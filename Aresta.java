
package com.mycompany.grafos;

public class Aresta {
    
    private Vertice vertice1;
    private Vertice vertice2;
    private int peso;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
  
    public Aresta(Vertice v1, Vertice v2){
        this.vertice1 = v1;
        this.vertice2 = v2;
    }
    public Aresta(Vertice v1, Vertice v2, int peso){
        this.vertice1 = v1;
        this.vertice2 = v2;
        this.peso = peso;
    }

    public Vertice getVertice1() {
        return this.vertice1;
    }

    public void setVertice1(Vertice vertice1) {
        this.vertice1 = vertice1;
    }

    public Vertice getVertice2() {
        return this.vertice2;
    }

    public void setVertice2(Vertice vertice2) {
        this.vertice2 = vertice2;
    }
    
    
    @Override
    public String toString() {
        return "Aresta de conexão: "+this.getVertice1().getValor()+" - "+this.getVertice2().getValor();
    }

}