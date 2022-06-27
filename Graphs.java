/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphs;

/**
 *
 * @author 071920496
 */
public class Graphs {
    public static void main(String[] args) {
        System.out.println("HAHAHAHAHA");
	Grafo grafo = Grafo.criarGrafo();
       // for(Vertice v : grafo.verticesAdjacentes(2)) System.out.println(v);
       //if(grafo.verificaConexo())System.out.println("Grafo conexo");
       //else System.out.println("Grafo não conexo");
       int[][] matriz_adjacencia = grafo.matrizAdjacencia();
       
       for(int i=0;i<grafo.vertices.size();i++){
           System.out.print(grafo.vertices.get(i));
           for(int j=0;j<grafo.vertices.size();j++){
               System.out.print(" | "+matriz_adjacencia[i][j]+" |");
           }
           System.out.print("\n");
       }
    }
}

