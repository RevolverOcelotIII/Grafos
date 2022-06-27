/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos;

import java.util.ArrayList;
import java.util.List;


public class GrafoEspecial extends Grafo {
    void adicionarArestaPeso(int valor_1, int valor_2, int peso){
        arestas.add(new Aresta(new Vertice(valor_1),new Vertice(valor_2), peso));
    }
    int[][] matrizAdjacenciaPeso(){
        int[][] matriz_adajcencia = new int[vertices.size()][vertices.size()];
        for(int i=0;i<vertices.size();i++){
            Vertice vertice_base = vertices.get(i);
            List<Vertice> adjacentes = verticesAdjacentes(vertice_base.getValor());
            for(int j=0;j<vertices.size();j++){
                if(comparaValorVertice(vertices.get(j).getValor(),adjacentes)) matriz_adajcencia[i][j]=getArestaPeso(vertices.get(i).getValor(), vertices.get(j).getValor());
                else matriz_adajcencia[i][j]=0;
            }
        }
        return matriz_adajcencia;
    }
    int getArestaPeso(int valor_1, int valor_2){
        for(Aresta a : arestas){
            if(a.getVertice1().getValor()==valor_1 && a.getVertice2().getValor()==valor_2||a.getVertice1().getValor()==valor_2 && a.getVertice2().getValor()==valor_1) return a.getPeso();
        }
        return 0;
    }
    public static GrafoEspecial criarGrafoEspecial() {
        GrafoEspecial grafo = new GrafoEspecial();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);
        grafo.adicionarArestaPeso(1,2, 10);
        grafo.adicionarArestaPeso(2,3, 8);
        grafo.adicionarArestaPeso(3,4, 5);
        grafo.adicionarArestaPeso(4,1, 2);
        return grafo;
    }
}
