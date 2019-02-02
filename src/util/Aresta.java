package util;

/**
 * Esta classe Aresta representa todas as arestas presente no grafo
 *
 * @author Daniel
 */
public class Aresta {

    //  private Vertice destino, origem;
    private int peso;

    /**
     * Construtor da classe que recebe um peso(Distancia entre os vertices)
     *
     * @param _peso distancia entre um vertice e outro
     */
    public Aresta(int _peso) {
        peso = _peso;
    }

    /**
     * Retorna o valor da distância
     *
     * @return distância
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Método que modifica a distância entre as cidades
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String toString() {
        return "Peso = " + peso;
    }
}
