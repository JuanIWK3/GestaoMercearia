
package Menu;

import Controller.EstoqueController;
import Model.DAO.EstoqueDAO;
import Model.Estoque;
import java.io.File;
import java.util.Scanner;

public class SecaoProduto {
    
    public static Scanner teclado = new Scanner(System.in); //teclado global
    public static File arquivo = null;     
    
    public static void cadastrar(){
        
        System.out.println("\nComo deseja cadastrar?\n1-Lista de produtos\n2-Unico produto");
        String opcaoProduto = teclado.nextLine();
        
        boolean validaProduto= true;                
                
        while(validaProduto == true){   
            
            if(opcaoProduto.equals("1")!= true && opcaoProduto.equals("2")!= true){                        
                System.out.println("Entrada invalida!! Informe novamente:");                        
                System.out.println("Como deseja cadastrar?\n1-Lista de produtos\n2-Unico produto");
                        
                opcaoProduto = teclado.nextLine();                   
            }else{                       
                
                validaProduto = false;                    
            }
        }    
        
        if(opcaoProduto.equals("1")){   
            
            //Arquivo dentro do diretorio do projeto;
            File arquivo = new File("ListaProdutos.csv");
            
            
            EstoqueController.carregaArquivo(arquivo);
            
        }else if(opcaoProduto.equals("2")){
            
            Estoque novoProduto = new Estoque();
            
            System.out.println("\nInserindo produto manualmente...");
            
            System.out.println("Informe o nome do produto:");
            novoProduto.setNome(teclado.nextLine().trim());
            
            System.out.println("Informe o código do produto:");
            novoProduto.setCodigo(teclado.nextInt());
                        
            System.out.println("Informe o preço do produto:");
            novoProduto.setPreco(teclado.nextDouble());
            
            System.out.println("Informe a quantidade de produto:");
            novoProduto.setQuantidade(teclado.nextInt());
            
            EstoqueDAO.insereProdutoManual(novoProduto);
        }
    }
    
    public static void deletar(){
        System.out.println("\nInforme o código do produto:");
        int codigo = teclado.nextInt();
        
        System.out.println("\nDeseja realmente deletar?\n1-SIM\n2-NÃO");
        int opcaoDeleta = teclado.nextInt();
        
        boolean validaDeleta= true;                
        while(validaDeleta == true){ 
            if((opcaoDeleta ==1 != true) && (opcaoDeleta ==2 != true)){
                System.out.println("Entrada invalida!! Informe novamente:");
                System.out.println("Deseja realmente deletar?\n1-SIM\n2-NÃO");
                opcaoDeleta = teclado.nextInt();
            }else{
                validaDeleta = false;
            }
        } 
                
        if(opcaoDeleta == 1){
            EstoqueDAO.deletaProduto(codigo);
        }else{
            Menu.listSecao();
        }
    }
    
    public static void atualizar(){
        System.out.println("\nInforme o codigo do produto:");
        int codigo = teclado.nextInt();
        
        System.out.println("\nO que deseja atualizar:\n1-Preço\n2-Quantidade\n3-Tudo");
        int opcaoAtt = teclado.nextInt();
        
        boolean validaAtt= true;                
        while(validaAtt == true){         
            
            if((opcaoAtt == 1 != true) && (opcaoAtt ==2 != true) && (opcaoAtt == 3 != true)){
                System.out.println("Entrada invalida!! Informe novamente:");
                System.out.println("O que deseja atualizar:\n1-Preço\n2-Quantidade\n3-Tudo");
                opcaoAtt = teclado.nextInt();
            }else{
                validaAtt = false;
            }
        }
                 
        double preco=0; 
        int quantidade =0;
        
        if(opcaoAtt == 1){
            System.out.println("Novo preço:");     
            preco = teclado.nextDouble();
        
            EstoqueDAO.atualizaProduto(opcaoAtt, preco, quantidade, codigo);         
        
        }else if(opcaoAtt == 2){            
            System.out.println("Nova quantidade:");
            quantidade = teclado.nextInt();
            
            EstoqueDAO.atualizaProduto(opcaoAtt, preco, quantidade, codigo);
            
        }else if(opcaoAtt == 3){
            System.out.println("Novo preço:");     
            preco = teclado.nextDouble();
            
            System.out.println("Nova quantidade:");
            quantidade = teclado.nextInt();
            
            EstoqueDAO.atualizaProduto(opcaoAtt, preco, quantidade, codigo);
        }
    }
    
    public static void listar(){
        System.out.println("------------- LISTANDO PRODUTOS ---------------");
        System.out.println("Id | Codigo | Nome | Preço | Quantidade\n");
        
        EstoqueDAO.listaProduto();
    }    
}
