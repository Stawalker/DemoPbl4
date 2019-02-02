package model;

import util.MenorCaminho;
import util.Vertice;

/**
 * Esta classe é responsável por calcular o consumo total do veículo de acordo
 * com a rota que lhe é atribuida
 *
 * @author Daniel
 */
public class GeraDados {

    private MenorCaminho menor;
    private Veiculo veiculo;
    private double consumoTotal;

    /**
     * Construtor da classe, este recebe um menor caminho traçado e o veículo
     * selecionado
     *
     * @param menor Menor rota a ser traçada pelo veículo
     * @param veiculo veículo selecionado pelo usuário
     */
    public GeraDados(MenorCaminho menor, Veiculo veiculo) {
        this.menor = menor;
        this.veiculo = veiculo;
    }

    /**
     * Este método calculaConsumo é responsável por gerar os cáculos de consumo
     * do veículo de acordo com a rota, ele recebe como parâmetro a cidade de
     * destino.
     *
     * @param destino cidade de destino.
     */
    public void calculaConsumo(Vertice destino) {
        int menorDistancia = menor.getCustos(destino);
        consumoTotal = menorDistancia * veiculo.getConsumoLt();

    }

    /**
     * Retorna o consumo total do veículo para a rota selecionada.
     *
     * @return 
     */
    public double getConsumoTotal() {
        return consumoTotal;
    }

}
