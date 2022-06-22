/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos1;

public class Aresta {
    
    private Vertice vertice1;
    private Vertice vertice2;
    private String nome;
  
    public Aresta(Vertice v1, Vertice v2){
        this.vertice1 = v1;
        this.vertice2 = v2;
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
    
    public String getNome() {
        return this.nome;
    }

    public void setValor(String nome) {
        this.nome = nome;
    }
    

}