package com.mycompany.grafos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Grafo {
    
    Map<Vertice, List<Vertice>> adjVertices;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    
    public Grafo(){
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }
    private String nome;

    void adicionarVertice(int valor){
        vertices.add(new Vertice(valor));
    }
    
    void removerVertice (int valor){
        vertices.remove(new Vertice(valor));
        arestas.stream().filter(a -> a.getVertice1().getValor()==valor||a
                .getVertice2().getValor()==valor)
                .forEach(a -> arestas.remove(a));
    }
    boolean procurarVertice (int valor){
        return vertices.contains(new Vertice(valor));
    }
    
    void adicionarAresta (int valor_1, int valor_2){
        Vertice v1 = new Vertice(valor_1);
        Vertice v2 = new Vertice(valor_2);
        if(procurarVertice(valor_2)&&procurarVertice(valor_2)){
            arestas.add(new Aresta(v1,v2));
        }
    }
    
    void removerAresta (int valor_1, int valor_2){
        Vertice v1 = new Vertice(valor_1);
        Vertice v2 = new Vertice(valor_2);
        arestas.stream().filter(a -> a.getVertice1()==v1&&a.getVertice2()==v2)
                .forEach(a -> arestas.remove(a));
    }
    
    boolean procurarAresta(int valor_1, int valor_2){
        Vertice v1 = new Vertice(valor_1);
        Vertice v2 = new Vertice(valor_2);
        return arestas.contains(new Aresta(v1,v2));
    }
   
    List<Vertice> verticesAdjacentes(int valor){
        Vertice v = new Vertice(valor);
        List<Vertice> adjacentes = new ArrayList<>();
        arestas.stream().filter(a -> a.getVertice1()==v || a.getVertice2()==v)
                .forEach(a -> {
                    if(a.getVertice1()==v)adjacentes.add(a.getVertice2());
                    else adjacentes.add(a.getVertice1());
                });
        return adjacentes;
    }
    int verticeGrau(int valor){
        Vertice v = new Vertice(valor);
        return (int) arestas.stream().filter(a -> a.getVertice1()==v || a.getVertice2()==v)
                .count();
    }
    int menorGrau(){
        List<Integer> graus = new ArrayList<>();
        vertices.forEach(v -> {
            graus.add(verticeGrau(v.getValor()));
        });
        return Collections.min(graus);
    }
    int maiorGrau(){
        List<Integer> graus = new ArrayList<>();
        vertices.forEach(v -> {
            graus.add(verticeGrau(v.getValor()));
        });
        return Collections.max(graus);
    }
    int grauMedio(){
        int grau_soma;
        
        grau_soma = vertices.stream()
                .mapToInt(it -> verticeGrau(it.getValor()))
                .sum();
        return grau_soma/vertices.size();
    }
    boolean verificaConexo(int valor){
        List<Vertice> vertices = 
    }
    Grafo criarGrafo() {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarVertice(5);
        grafo.adicionarAresta(1,2);
        grafo.adicionarAresta(1,4);
        grafo.adicionarAresta(2,3);
        grafo.adicionarAresta(4,3);
        grafo.adicionarAresta(2,5);
        grafo.adicionarAresta(1,5);
        return grafo;
    }
    
    List<Vertice> pegarVerticesAdjacentes(int valor){
        return adjVertices.get(new Vertice(valor));
    }
   /* 
    boolean checarAresta(){
        return 
    }*/
}
