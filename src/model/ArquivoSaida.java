package model;

import java.io.File;
import java.util.List;
import util.MenorCaminho;
import util.Vertice;

/**
 * Esta classe é responsável por fazer a escrita do arquivo de texto, contendo
 * as cidades da rota traçada, as cidades que serão visitadas e o consumo total
 * do veículo
 *
 * @author Daniel
 */
public class ArquivoSaida {

    private GeraDados dado;
    private MenorCaminho menor;
    private List<Vertice> menores;
    private File escrita;

    /**
     * Construtor da classe, nele é passado como parâmetro o consumo total do
     * veículo, e a rota traçada
     *
     * @param dado consumo total do veículo
     * @param menor Menor caminho traçado entre as cidades
     */
    public ArquivoSaida(GeraDados dado, MenorCaminho menor) {
        this.dado = dado;
        this.menor = menor;
    }

    /**
     * Esta classe é responsavel por escrever os dados obtidos em um arquivo de
     * texto.
     */
    public void escrita() {
        recebeMenores(menor);
    
    }

    private void recebeMenores(MenorCaminho menor) {
        menores = menor.getTeste2();
   
    }

}
