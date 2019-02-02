
package util;

import model.LerArquivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import util.exceções.newpackage.ArquivoNaoEncontradoException;
import util.exceções.newpackage.ListaVerticeVaziaException;

/**
 *
 * @author Daniel
 */
public class teste {

    public static void main(String[] args) throws IOException, ArquivoNaoEncontradoException, ListaVerticeVaziaException {
        Grafo graf;
        LerArquivo leitura = new LerArquivo();
        MenorCaminho menor;

        leitura.leitura();

        graf = leitura.grafh();
        menor = new MenorCaminho(graf);
        Vertice cid = (Vertice) graf.getvertice(0);
        Vertice cid2 = (Vertice) graf.getvertice(10);
      
        System.out.println(cid2);
        System.out.println( graf.returnAdj(cid2));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("------------------------------------------------- ");
         menor.caminhoCustoMinimo(cid, cid2);
        System.out.println(graf.getArestaAdj(cid2));
        
         
         /*
         Set<Vertice>test1 = graf.returnAdj(cid2);
       Collection<Aresta> c = graf.getArestaAdj(cid2);
         System.out.println(test1 +" "+c);*/
         System.out.println("-----------------------------------------------");
         
        System.out.println(cid);
        System.out.println(cid2);
            System.out.println(menor.getCustos(cid2));
            
    
      
        
         ArrayList<Vertice>test = menor.getTeste2();
         
         Iterator it= test.iterator();
         System.out.println(test);
  
         
    }

}
