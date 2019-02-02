package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import util.Aresta;
import util.Grafo;
import util.Vertice;
import util.exceções.newpackage.ArquivoNaoEncontradoException;
import util.exceções.newpackage.ListaVerticeVaziaException;

/**
 * Esta classe é responsável por fazer a leitura do Mapa.
 *
 * @author Daniel
 */
public class LerArquivo {

    FileReader ler;

    BufferedReader buf;
    HashMap<Vertice, Vertice> aux;
    String cidade1, cidade2, pontoX1, pontoX2, pontoY1, pontoY2, distancia;
    Grafo graf;
    LinkedList cidades;
    int size;

    /**
     * Construtor da classe LerArquivo, o arquivo já é lido automaticamente.
     */
    public LerArquivo() throws ArquivoNaoEncontradoException {
        try {
            this.ler = new FileReader("src\\mapa\\Mapa Bahia.txt");
            this.buf = new BufferedReader(ler);

        } catch (FileNotFoundException ex) {
            throw new ArquivoNaoEncontradoException(" O arquivo não foi encontrado no diretorio");
        }
        cidades = new LinkedList();
        graf = new Grafo();
    }

    /**
     * Método responsável por testar a leitura e guardar os dados em uma lista
     * para serem enviada ao grafo.
     *
     * @throws IOException
     */
    public void leitura() throws IOException, ListaVerticeVaziaException {
        String cont = " ";
        String text = " ";
        try {
            buf.readLine(); // Faz o pulo para a segunda Linha
            while (text != null) {
                /* Começa ler da segunda Linha*/
                text = buf.readLine();

                if (text == null) { // verifica se text é null
                    break;
                }

                String[] array = text.split(";");
                cidade1 = array[0];
                cidade2 = array[1];
                distancia = array[2];

                int rot = Integer.parseInt(distancia);// DISTANCIA ENTRE AS CIDADES = PESO

                pontoX1 = array[3];
                pontoY1 = array[4];

                pontoX2 = array[5];
                pontoY2 = array[6];

                // CONVERTE OS PONTOS CARTESIANOS EM INTEIROS
                // PRECISA CONVERTER A ROTA TAMBÉM!!
                int cX1 = Integer.parseInt(pontoX1);
                int cY1 = Integer.parseInt(pontoY1);
                int cX2 = Integer.parseInt(pontoX2);
                int cY2 = Integer.parseInt(pontoY2);

                Vertice cid1 = new Vertice(cidade1, cX1, cY1);
                Vertice cid2 = new Vertice(cidade2, cX2, cY2);
                Aresta dist = new Aresta(rot);
                
                addVizinhos(cid1,cid2,dist);

             
            }
            ler.close();
            buf.close();
            addVertice(cidades);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    private void addVizinhos(Vertice cid1, Vertice cid2, Aresta dist){
       //LISTA DE VERTICES
                if (cidades.contains(cid1)) {

                    Iterator it = cidades.iterator();
                    while (it.hasNext()) {
                        Vertice aux = (Vertice) it.next();
                        if (aux.equals(cid1)) {
                            aux.addVizinho(cid2, dist);
                        }
                    }
                } else {
                    cid1.addVizinho(cid2, dist);
                    cidades.add(cid1);
                }

                if (cidades.contains(cid2)) {
                    //cidades.add(cid2);

                    Iterator its = cidades.iterator();
                    while (its.hasNext()) {
                        Vertice aux = (Vertice) its.next();
                        if (aux.equals(cid2)) {
                            aux.addVizinho(cid1, dist);
                        }

                    }
                } else {
                    cid2.addVizinho(cid1, dist);
                    cidades.add(cid2);
                }

        
    }

    /**
     * Envia uma lista de vértices(Cidade) para construir o grafo
     *
     * @param lista Lista de vértices
     */
    public void addVertice(List lista) throws ListaVerticeVaziaException {
        graf.addVertice(lista);
    }
    
    /**
     * Método que retorna um grafo
     *
     * @return grafo
     */
    public Grafo grafh() {
        return graf;
    }

    /**
     * Método que retorna uma lista de vértices lidos do arquivo.
     *
     * @return lista de vértices
     */
    public LinkedList listcid() {
        return cidades;
    }

    /**
     * Método que retorna a quantidade de vértices lidos do arquivos
     *
     * @return tamanho da lista
     */
    public int getSize() {
        return cidades.size();
    }

}
