package com.mycompany.grafos1;


import java.util.List;
import java.util.Map;

public class Grafo {
    
    Map<Vertice, List<Vertice>> adjVertices;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    
    
    private String nome;

    void adicionarVertice(int valor){
        vertices.add(new Vertice(valor));
    }
    
    void removerVertice (int valor){
        vertices.remove(new Vertice(valor));
        arestas.stream().filter(a -> (a.getVertice1().getValor()==valor||a
                .getVertice2().getValor()==valor)).forEachOrdered(a -> {
            arestas.remove(a);
        });
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
        List<Vertice> lista_vertice1 = adjVertices.get(v1);
        List<Vertice> lista_vertice2 = adjVertices.get(v2);
        if(lista_vertice1 != null) lista_vertice1.remove(v2);
        if(lista_vertice2 != null) lista_vertice2.remove(v1);
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
