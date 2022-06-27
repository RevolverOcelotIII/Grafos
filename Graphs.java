/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos;

/**
 *
 * @author 071920496
 */
public class Graphs {
    public static void main(String[] args) {
        Grafo grafo = Grafo.criarGrafo();
        
        if(grafo.verificaConexo())System.out.println("Grafo conexo");
        else System.out.println("Grafo não conexo");
       
        int[][] matriz_adjacencia = grafo.matrizAdjacencia();
        System.out.println("Matriz de adjacência");
        for(int i=0;i<grafo.vertices.size();i++){
           System.out.print(grafo.vertices.get(i));
           for(int j=0;j<grafo.vertices.size();j++){
               System.out.print(" | "+matriz_adjacencia[i][j]+" |");
           }
           System.out.print("\n");
        }
        
        if(grafo.verificaEuler())System.out.println("Euler positivo");
        else System.out.println("Euler negativo");
        
        GrafoEspecial grafo_especial = GrafoEspecial.criarGrafoEspecial();
        int[][] matriz_adjacencia_peso = grafo_especial.matrizAdjacenciaPeso();
        System.out.println("Matriz de adjacência com peso");
        for(int i=0;i<grafo.vertices.size();i++){
            System.out.print(grafo.vertices.get(i));
            for(int j=0;j<grafo.vertices.size();j++){
                System.out.print(" | "+matriz_adjacencia_peso[i][j]+" |");
            }
            System.out.print("\n");
        }
    }
}

