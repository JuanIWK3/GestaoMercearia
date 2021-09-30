
package Controller;

import Model.DAO.EstoqueDAO;
import Model.Estoque;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EstoqueController {
    
    public static void carregaArquivo(File arquivo){
        ArrayList<Estoque> listaProduto = new ArrayList<>();
        
        if (arquivo!=null && arquivo.exists() && arquivo.isFile()) {
            try {  
                FileReader marcaLeitura = new FileReader(arquivo);                    
                BufferedReader leitor = new BufferedReader(marcaLeitura);
                  
                //leitura das linhas dos produtos                  
                String linha = leitor.readLine();
                  
                while (linha!=null) {                    
                    String infos[] = linha.split(";"); 
                    
                    if (infos.length == 4) {                     
                        String nome = infos[1];
                      
                        try {
                                
                            int codigo = Integer.parseInt(infos[0]);
                            double preco = Double.parseDouble(infos[2]);                        
                            int quantidade = Integer.parseInt(infos[3]);
                        
                            Estoque novoProduto = new Estoque(codigo, nome, preco, quantidade);                        
                            listaProduto.add(novoProduto);
                      
                        } catch (NumberFormatException ex) {                        
                            System.err.println("Erro nos valores da linha: "+linha);                      
                        }                    
                    }                    
                    linha = leitor.readLine();                  
                }
                  
                leitor.close();            
            } catch (FileNotFoundException ex) {              
                ex.printStackTrace();            
            }catch(IOException ex){              
                ex.printStackTrace();            
            }
    }
    if(!listaProduto.isEmpty()){
      //chamada ao ProdutoEstoqueDao para armazenar os valores em Banco de Dados      
        EstoqueDAO.insereProdutoEstoque(listaProduto);
    }
    }
}
