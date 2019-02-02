package controller;

import model.ArquivoSaida;
import model.LerArquivo;
import model.Veiculo;
import util.Grafo;
import util.MenorCaminho;

/**
 *
 * @author Daniel
 */
public class Controller {
    LerArquivo arq;
    Grafo grafo;
    MenorCaminho dijkstra;
    Veiculo vei;
    ArquivoSaida salvaRota;

    public Controller(LerArquivo arq, Grafo grafo, MenorCaminho dijkstra, Veiculo vei, ArquivoSaida salvaRota) {
        this.arq = arq;
        this.grafo = grafo;
        this.dijkstra = dijkstra;
        this.vei = vei;
        this.salvaRota = salvaRota;
    }
            
    
    public void leituraArq(){}
    public void desenhaGrafo(){}
    public void cadastraVeiculo(){}
    public void menorCaminho(){}
    public void salvarRota(){}
    
    
}
