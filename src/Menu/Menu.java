
package Menu;

import java.util.Scanner;

public class Menu {
    
    public static Scanner teclado = new Scanner(System.in); //teclado global
    
    public static void listMenu(String opcao){
        
        switch(opcao){
            
            case "1":
                   
                System.out.println("\n-----------------------------------------------\n");
                System.out.println("Selecione uma opção:");            
                System.out.println("\n1-Cadastrar Cliente\n2-Deletar Cliente\n3-Atualizar Cliente\n4-Listar Cliente");  
                
                String opcaoCliente = teclado.nextLine();
                                
                boolean validaCliente= true;                
                while(validaCliente == true){         
            
                    if(opcaoCliente.equals("1")!= true && opcaoCliente.equals("2")!= true && opcaoCliente.equals("3")!= true && opcaoCliente.equals("4")!= true){
                        System.out.println("Entrada invalida!! Informe novamente:");
                        System.out.println("1-Cadastrar Cliente\n2-Deletar Cliente\n3-Atualizar Cliente\n4-Listar Cliente");  
                        opcaoCliente = teclado.nextLine();
                    }else{
                        validaCliente = false;
                    }
                }                   
           
                if(opcaoCliente.equals("1")){                   
                    SecaoCliente.cadastrar();
                }
                
                if(opcaoCliente.equals("2")){
                    SecaoCliente.deletar();
                }
                
                if(opcaoCliente.equals("3")){
                    SecaoCliente.atualizar();
                }
                
                if(opcaoCliente.equals("4")){
                    SecaoCliente.listar();
                }     
            break;
            
            case "2":
                System.out.println("\n-----------------------------------------------\n");
                System.out.println("Selecione uma opção:");            
                System.out.println("\n1-Cadastrar Produto\n2-Deletar Produto\n3-Atualizar Produto\n4-Listar Produto");  
                
                String opcaoProduto = teclado.nextLine();
                                
                boolean validaProduto= true;                
                while(validaProduto == true){         
            
                    if(opcaoProduto.equals("1")!= true && opcaoProduto.equals("2")!= true && opcaoProduto.equals("3")!= true && opcaoProduto.equals("4")!= true){
                        System.out.println("Entrada invalida!! Informe novamente:");
                        System.out.println("1-Cadastrar Produto\n2-Deletar Produto\n3-Atualizar Produto\n4-Listar Produto");  
                        opcaoCliente = teclado.nextLine();
                    }else{
                        validaProduto = false;
                    }
                }        
                
                if(opcaoProduto.equals("1")){                   
                    SecaoProduto.cadastrar();
                }
                
                if(opcaoProduto.equals("2")){
                    SecaoProduto.deletar();
                }
                
                if(opcaoProduto.equals("3")){
                    SecaoProduto.atualizar();
                }
                
                if(opcaoProduto.equals("4")){
                    SecaoProduto.listar();
                }                    
            break;    
                     
            case "3":
                
            break;  
            
            case "0":
                System.out.println("\n-----------------------------------------------");
                System.out.println("\nFinalizando....");
            break;
        }          
    }   
    
    
    public static void listSecao(){
         
        System.out.println("\n-----------------------------------------------\n");
        System.out.println("Selecione a seção:");
        System.out.println("\n1-Cliente\n2-Produto\n3-Venda\n0-SAIR");
        
        String opcao = teclado.nextLine();
               
        boolean valida= true;                
        while(valida == true){         
            
            if(opcao.equals("1")!= true && opcao.equals("2")!= true && opcao.equals("3")!= true && opcao.equals("0")!= true){                
                System.out.println("\nEntrada invalida!! Informe novamente:");
                System.out.println("\n1-Cliente\n2-Produto\n3-Venda\n0-SAIR");
                opcao = teclado.nextLine();
            }else{
                valida = false;
            }
        }
        
        listMenu(opcao);         
    }
}