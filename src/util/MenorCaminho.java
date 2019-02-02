package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe que calcula o menor caminho entre dois vertices de um grafo.
 *
 * @author Daniel
 */
public class MenorCaminho {

    private ArrayList<Vertice> naoVisitados;
    private HashMap<Vertice, Vertice> antecessores;
    private HashMap<Vertice, Integer> custos;
    private ArrayList<Vertice> teste, teste2;

    private Grafo grafo;

    /**
     * Construtor da classe, nele são inicializados todos os componentes
     * necessários para sua funcionalidade, recebe um grafo o qual será traçado
     * o menor caminho
     *
     * @param grafo grafo para ser calculado o menor caminho
     */
    public MenorCaminho(Grafo grafo) {

        this.grafo = grafo;
        naoVisitados = new ArrayList<Vertice>();
        antecessores = new HashMap<Vertice, Vertice>();
        teste = new ArrayList<Vertice>();
        teste2 = new ArrayList<Vertice>();
        custos = new HashMap<Vertice, Integer>();

    }

    /**
     * Método que gera o menor caminho entre dois vertices
     *
     * @param origem Vertice de Partida
     * @param destino Vertice onde deseja chegar
     */
    public void caminhoCustoMinimo(Vertice origem, Vertice destino) {
        naoVisitados = grafo.vertices();

        atribuiCusto();
        custos.put(origem, 0);

        int peso, pesoVertice, pesoTotal;
        Vertice menorcust;
        HashMap<Vertice, Aresta> arestas = null;
        Object[] adjacentes; // vetor de vertice adjacente ao vertice escolhido

        do {

            menorcust = calculaMenor(); // recebe menor vertice
            menorcust.setDados("fechado"); // marca como visitado
            arestas = menorcust.getAdjacentes(); // recebe as arestas adjacentes do vértice visitado
            adjacentes = arestas.keySet().toArray();

            pesoVertice = custos.get(menorcust); // peso do vertice visitado

            for (int i = 0; i < arestas.size(); i++) {
                peso = arestas.get(adjacentes[i]).getPeso(); // passa o peso da aresta

                pesoTotal = pesoVertice + peso;

                if (custos.containsKey(adjacentes[i])) {
                    if (pesoTotal < custos.get(adjacentes[i])) {
                        custos.put((Vertice) adjacentes[i], pesoTotal);
                        antecessores.put((Vertice) adjacentes[i], menorcust);

                    }

                }

            }
        } while (isFechado() == false);
        listaVertices(origem, destino); // lista os vertices com peso menor do que o destino

    }

    /**
     * Lista os vértices percorridos no menor caminho
     *
     * @param destino vertice de chegada
     */
    private void listaVertices(Vertice origem, Vertice destino) {

        for (Vertice a : custos.keySet()) {
            int b = custos.get(a);
            if (b <= custos.get(destino)) {
                teste.add(a);
            }
        }
        selecionaCaminho(origem, destino);

    }

    /**
     * Método responsavel por mostrar os vertices visitados
     *
     * @param origem
     * @param destino
     */
    private void selecionaCaminho(Vertice origem, Vertice destino) {

        HashMap<Vertice, Aresta> ori = origem.getAdjacentes(); // PEGO OS ADJACENTES A ORIGEM
        Iterator t = teste.iterator(); // iterador da lista de menores caminhos  
        Set<Vertice> adj1 = ori.keySet(); // obtenho um array de vertices do vertice origem;
        Iterator ver = adj1.iterator();
        int o = 0;
        Vertice[] adj = new Vertice[adj1.size()];

        while (ver.hasNext()) {
            adj[o] = (Vertice) ver.next();
            o++;
        }

        for (int i = 0; i < ori.size(); i++) {
            for (int k = 0; k < teste.size(); k++) {

                if (adj[i].equals(teste.get(k))) {

                    if (destino.equals((Vertice) adj[i])) {
                        if (!teste2.contains(origem)) {

                            teste2.add(origem); // vertice antecessor
                        }
                        teste2.add((Vertice) adj[i]); // vertice final
                        break;

                    } else {

                        // pego os visinhos adjacentes do vertice atual
                        Vertice cid = (Vertice) adj[i];
                        HashMap<Vertice, Aresta> adjVertice = cid.getAdjacentes();
                        Set<Vertice> set = adjVertice.keySet(); // obtenho todos os vertices adj;
                        Object[] v = set.toArray();

                        for (int h = 0; h < v.length; h++) {
                            for (int p = 0; p < teste.size(); p++) {
                                if (v[h].equals(teste.get(p))) {
                                    if (v[h] != origem) {

                                        if (destino.equals(v[h])) {
                                            teste2.add((Vertice) v[h]);
                                            break;

                                        } else {

                                            if (!teste2.contains(origem)) {
                                                teste2.add(origem);
                                                if (!teste2.contains(cid)) {
                                                    teste2.add(cid);
                                                }
                                            }
                                            selecionaCaminho((Vertice) v[h], destino);
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            }
        }
    }

    public HashMap<Vertice, Vertice> getAntecessores() {
        return antecessores;
    }

    public HashMap<Vertice, Integer> getCustos() {
        return custos;
    }

    /**
     * Retorna todos os caminhos percorridos para chegar ao destino com o menor
     * peso
     *
     * @return
     */
    /*
    public ArrayList<Vertice> getTeste() {
        return teste;
    }*/
    
    /**
     * Retorna todos os caminhos percorridos para chegar ao destino com o menor
     * peso
     *
     * @return
     */
    public ArrayList<Vertice> getTeste2() {
        return teste2;
    }

    /**
     * Retorna o custo total do vertice de origem ao vertice de destino
     *
     * @param destino
     * @return
     */
    public int getCustos(Vertice destino) {
        return custos.get(destino);
    }

    /**
     * Este método atribui para cada vértice o valor máximo permitido.
     */
    private void atribuiCusto() {
        for (int i = 0; i < grafo.qtd(); i++) {
            custos.put(naoVisitados.get(i), Integer.MAX_VALUE);
            antecessores.put(naoVisitados.get(i), null);
        }

    }

    /**
     * Este métoodo encontra o vertice que contém o menor peso(Distância) entre
     * seus vizinhos
     *
     * @return vertice com menor distância
     */
    private Vertice calculaMenor() {
        Integer menor = Integer.MAX_VALUE;
        Integer aux;
        Vertice vertMenor = null;

        for (int i = 0; i < grafo.qtd(); i++) {
            aux = custos.get(naoVisitados.get(i));
            if (aux <= menor && naoVisitados.get(i).getDados().equals("") == true) {
                menor = aux;
                vertMenor = naoVisitados.get(i);
            }

        }
        return vertMenor;
    }

    /**
     * Este método é responsável po verificar se todos os vértices do grafo
     * foram percorridos
     *
     * @return retorna verdadeiro se todos os vértices foram visitados ou falso
     * caso contrário.
     */
    private boolean isFechado() {
        for (int i = 0; i < grafo.qtd(); i++) {
            if (!naoVisitados.get(i).getDados().equals("fechado")) {
                return false;
            }
        }
        return true;
    }

}
