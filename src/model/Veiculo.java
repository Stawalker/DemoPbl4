package model;

/**
 * Esta classe Veículo representa um veículo da empresa
 *
 * @author Daniel
 */
public class Veiculo {

    private String placa;
    private double consumoLt;

    /**
     * Construtor da classe que recebe como parâmetro a placa do veículo e o
     * consumo por litros
     *
     * @param placa indentificação do veículo
     * @param consumoLt consumo do veículo em litros por KM rodado
     */
    public Veiculo(String placa, double consumoLt) {
        this.placa = placa;
        this.consumoLt = consumoLt;
    }

    /**
     * Retorna a identificação do veículo, sua placa
     *
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Retorna o consumo em litros por km rodado
     *
     * @return
     */
    public double getConsumoLt() {
        return consumoLt;
    }

}
