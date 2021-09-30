
package Menu;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import java.util.Scanner;

public class SecaoCliente {
    
    public static Scanner teclado = new Scanner(System.in); //teclado global
    
    public static void cadastrar(){
        
        Cliente novoCliente = new Cliente();
        
        System.out.println("Informe o nome:");
        novoCliente.setNome(teclado.nextLine().trim());
        
        System.out.println("Informe o cpf:");
        novoCliente.setCpf(teclado.nextLine().trim());
        
        System.out.println("Informe o endereço:");
        novoCliente.setEndereco(teclado.nextLine().trim());
        
        System.out.println("Informe o telefone:");
        novoCliente.setTelefone(teclado.nextLine().trim());
        
        ClienteDAO.insereCliente(novoCliente);
    }
    
    public static void deletar(){
                
        System.out.println("\nInforme o CPF do cliente:");
        String cpf = teclado.nextLine().trim();
        
        System.out.println("\nDeseja realmente deletar?\n1-SIM\n2-NÃO");
        String opcaoDeleta = teclado.nextLine();
        
        boolean validaDeleta= true;                
        while(validaDeleta == true){ 
            if(opcaoDeleta.equals("1")!= true && opcaoDeleta.equals("2")!= true){
                System.out.println("Entrada invalida!! Informe novamente:");
                System.out.println("Deseja realmente deletar?\n1-SIM\n2-NÃO");
                opcaoDeleta = teclado.nextLine();
            }else{
                validaDeleta = false;
            }
        } 
        
        if(opcaoDeleta.equals("1")){
            ClienteDAO.deletaCliente(cpf);
        }else{
            Menu.listSecao();
        }
    }
    
    public static void atualizar(){
              
        System.out.println("Informe o cpf do cliente:");
        String cpf = teclado.nextLine().trim(); 
        
        System.out.println("O que deseja atualizar:\n1-Telefone\n2-Endereço\n3-Tudo");
        String opcaoAtt = teclado.nextLine();
        
        boolean validaAtt= true;                
        while(validaAtt == true){         
            
            if(opcaoAtt.equals("1")!= true && opcaoAtt.equals("2")!= true && opcaoAtt.equals("3")!= true){
                System.out.println("Entrada invalida!! Informe novamente:");
                System.out.println("O que deseja atualizar:\n1-Telefone\n2-Endereço\n3-Tudo");
                opcaoAtt = teclado.nextLine();
            }else{
                validaAtt = false;
            }
        }
        
        String telefone="";
        String address="";
               
        
        if(opcaoAtt.equals("1")){
            System.out.println("Novo numero:");     
            telefone = teclado.nextLine().trim();
        
            ClienteDAO.atualizaCliente(opcaoAtt, telefone,address, cpf); 
        
        
        }else if(opcaoAtt.equals("2")){            
            System.out.println("Novo endereço");
            address = teclado.nextLine().trim();
            
            ClienteDAO.atualizaCliente(opcaoAtt, telefone,address, cpf); 
            
        }else if(opcaoAtt.equals("3")){
            
            System.out.println("Novo numero:");     
            telefone = teclado.nextLine().trim();
            
            System.out.println("Novo endereço");
            address = teclado.nextLine().trim();
            
            ClienteDAO.atualizaCliente(opcaoAtt, telefone,address, cpf);
        }        
    }
    
    public static void listar(){
        
        System.out.println("\n------------- LISTANDO CLIENTES ---------------");
        System.out.println("Id | Nome | Cpf | Endereço | Telefone\n");
        ClienteDAO.listaCliente();
    }    
}