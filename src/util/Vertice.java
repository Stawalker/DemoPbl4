package util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Esta classe Vertice é responsável por ser os vértices do grafo e representa
 * as cidades
 *
 * @author Daniel
 */
public class Vertice {

    private final String nome;
    private final int x;
    private final int y;
    private final HashMap<Vertice, Aresta> adj;
    private int distancia;
    private String dados;

    /**
     * Construtor da classe Vertice que recebe o nome da cidade e suas posições
     * cartesianas
     *
     * @param nome Nome da cidade
     * @param x posição referente ao eixo x
     * @param y posicção referente ao eixo y
     */
    public Vertice(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        dados = "";

        adj = new HashMap<>();
    }

    /**
     * Método que adiciona todos os vértices adjacentes, ou cidades vizinhas
     *
     * @param cid2 Cidade vizinha ou Vertice adjacente
     * @param peso Distancia entre as cidades ou vertice
     */

    public void addVizinho(Vertice cid2, Aresta peso) {
        if (!adj.containsKey(cid2)) {
            adj.put(cid2, peso);
        }
    }

    public String getNome() {
        return nome;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Verifica se os vértices são iguais
     *
     * @param c vertice para ser comparado
     * @return retorna verdadeiro se os objetos são iguais ou falso caso
     * contrario.
     */
    @Override
    public boolean equals(Object c) {
        Vertice aux = (Vertice) c;
        return this.nome.equals(aux.getNome()) && this.x == aux.getX() && this.y == aux.getY();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return nome;
    }
/**
 * Método que retorna um HashMap das cidades ou vértices adjacentes.
 * @return retorna as cidades ou vertices adjacentes.
 */
    public HashMap<Vertice, Aresta> getAdjacentes() {
        return adj;
    }
    
    public Collection<Aresta> getArestaAdj(){
        return adj.values();
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

}
