package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import util.exceções.newpackage.ListaVerticeVaziaException;

/**
 * Esta classe Grafo representa uma estrutura de dados do tipo Grafo onde ela é
 * classificada como grafo ponderado.
 *
 * @author Daniel
 */
public class Grafo {

    private ArrayList<Vertice> grafo;
    private List<Vertice> list;
    int size;

    /**
     * Construtor da classe Grafo, onde inicializa seus atributos
     */
    public Grafo() {
        //vertices = new ArrayList<>();
        grafo = new ArrayList<>();
    }

    /**
     * Este método addVertice é o responsável por adicionar todos os vértices no
     * grafo. Ele recebe como parâmetro uma lista que contém todos os vértices a
     * serem adicionados no grafo
     *
     * @param lista Lista de Vertices
     */
    public void addVertice(List lista) throws ListaVerticeVaziaException {
        if (!lista.isEmpty()) {
            Iterator it = lista.iterator();
            Vertice vert;
            size = lista.size();
            list = lista;
            while (it.hasNext()) {
                vert = (Vertice) it.next();
                grafo.add(vert);
            }
        }else{
            throw new ListaVerticeVaziaException("Não Existe vertice na lista");
        }
    }

    /**
     * Este método ligaCidades é o responsável por fazer a ligação de um vértice
     * a outro, ou seja, conecta os vértices adjacentes do grafo
     *
     * @param origem vertice incial
     * @param destino vertice adjacente
     * @param peso é a distância entre um vértice e outro.
     */
    public void ligaCidades(Vertice origem, Vertice destino, Aresta peso) {

        if (!origem.getAdjacentes().containsKey(destino)) {
            origem.addVizinho(destino, peso);
            destino.addVizinho(origem, peso);
        }

    }

    /**
     * Este método returnAdj, retorna todos os vértices adjacente ao vértice
     * informado
     *
     * @param obj vértice que deseja pesquisar
     * @return lista de adjacencia do vértice informado.
     */
    public Set<Vertice> returnAdj(Vertice obj) {

        return obj.getAdjacentes().keySet();
    }
    
      public Set<Map.Entry<Vertice, Aresta>> getArestaAdj(Vertice adj){
        return adj.getAdjacentes().entrySet();
    }

    /**
     * Retorna a quantidade de vértices do grafo
     *
     * @return quantidade de vertices
     */
    public int qtd() {
        return grafo.size();
    }

    @Override
    public String toString() {
        return grafo.toString();
    }

    /**
     * Retorna o vértice referente ao indice indicado
     *
     * @param i indice da cidade desejada
     * @return Cidade (Vertice) desejada
     */
    public Vertice getvertice(int i) {

        return list.get(i);
    }

    /**
     * Este método retorna uma lista de vértices do grafo
     *
     * @return lista de vertices
     */
    public ArrayList<Vertice> vertices() {
        return grafo;
    }

}
