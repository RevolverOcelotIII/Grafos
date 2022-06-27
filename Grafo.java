package com.mycompany.grafos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {
    
    List<Vertice> vertices;
    List<Aresta> arestas;
    
    public Grafo(){
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }
    
    boolean comparaValorVertice(int valor, List<Vertice> lista_vertices){
        for(Vertice v : lista_vertices){
            if(v.getValor()==valor) return true;
        }
        return false;
    }
    boolean comparaValorAresta(int valor_1, int valor_2, List<Aresta> lista_arestas){
        for(Aresta a : lista_arestas){
            if(a.getVertice1().getValor()==valor_1 && a.getVertice2().getValor()==valor_2) return true;
        }
        return false;
    }

    void adicionarVertice(int valor){
        vertices.add(new Vertice(valor));
    }
    
    void removerVertice (int valor){
        vertices.remove(new Vertice(valor));
        for(int i=0;i<arestas.size();i++){
            if(arestas.get(i).getVertice1().getValor()==valor||arestas.get(i).getVertice2().getValor()==valor) arestas.remove(i);
        }
    }
    boolean procurarVertice (int valor){
        return comparaValorVertice(valor, vertices);
    }
    
    void adicionarAresta (int valor_1, int valor_2){
        Vertice v1 = new Vertice(valor_1);
        Vertice v2 = new Vertice(valor_2);
        arestas.add(new Aresta(v1,v2));
    }
    
    void removerAresta (int valor_1, int valor_2){
        for(int i=0;i<arestas.size();i++){
            if(arestas.get(i).getVertice1().getValor()==valor_1&&arestas.get(i).getVertice2().getValor()==valor_2) arestas.remove(i);
        }
    }
    
    boolean procurarAresta(int valor_1, int valor_2){
        return comparaValorAresta(valor_1, valor_2, arestas);
    }
   
    List<Vertice> verticesAdjacentes(int valor){
        List<Vertice> adjacentes = new ArrayList<>();
        for(Aresta a : arestas){
            if(a.getVertice1().getValor()==valor || a.getVertice2().getValor()==valor){
                if(a.getVertice1().getValor()==valor)adjacentes.add(a.getVertice2());
                else adjacentes.add(a.getVertice1());
            }
        }
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
    boolean verificaConexo(){
        List<Integer> visitados;
        for(Vertice v : vertices){
            visitados = verticeConexo(v,null);
            if(visitados.size()!=vertices.size())return false;
        }
        return true;
    }
    
    List<Integer> verticeConexo(Vertice v, List<Integer> visitados){
        if(visitados==null)visitados = new ArrayList<>();
        visitados.add(v.getValor());
        List<Vertice> adjacentes = verticesAdjacentes(v.getValor());
        for(int i=adjacentes.size()-1;i>=0;i--){
            if(visitados.contains(adjacentes.get(i).getValor())) {
               adjacentes.remove(i);
            }
        }
        if(adjacentes.isEmpty()) return visitados;
        for(Vertice vertice : adjacentes){
            visitados = verticeConexo(vertice,visitados);
        }
        return visitados;
    }
    
    int[][] matrizAdjacencia(){
        int[][] matriz_adajcencia = new int[vertices.size()][vertices.size()];
        for(int i=0;i<vertices.size();i++){
            Vertice vertice_base = vertices.get(i);
            List<Vertice> adjacentes = verticesAdjacentes(vertice_base.getValor());
            for(int j=0;j<vertices.size();j++){
                if(comparaValorVertice(vertices.get(j).getValor(),adjacentes)) matriz_adajcencia[i][j]=1;
                else matriz_adajcencia[i][j]=0;
            }
        }
        return matriz_adajcencia;
    }
    public boolean verificaEuler(){
        int contagem_impar=0;
        if(verificaConexo()){
            for(Vertice v : vertices){
                if(verticeGrau(v.getValor())%2!=0) contagem_impar++;
            }
            return contagem_impar==2||contagem_impar==0;
        }
        return false;
    }
    
    public static Grafo criarGrafo() {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);
        grafo.adicionarAresta(1,2);
        grafo.adicionarAresta(2,3);
        grafo.adicionarAresta(3,4);
        return grafo;
    }
    
}
