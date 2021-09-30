
package Model.DAO;

import java.sql.ResultSet;
import Model.Cliente;
import Menu.Menu;
import Tools.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
        
    public static void insereCliente(Cliente novoCliente){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql = "INSERT INTO cliente(nome,cpf,endereco,telefone) VALUES(?,?,?,?)"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, novoCliente.getNome());
            stmt.setString(2, novoCliente.getCpf());
            stmt.setString(3, novoCliente.getEndereco());
            stmt.setString(4, novoCliente.getTelefone());
           
            stmt.execute();   
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        Menu.listSecao();
    }
    
    public static void deletaCliente(String cpf){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql = "DELETE FROM cliente WHERE cpf like '" + cpf + "'"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
  
            stmt.execute();   
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        Menu.listSecao();
    }   
    
    public static void atualizaCliente(String opcao, String telefone, String address, String cpf){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            if(opcao.equals("1")){               
                String sql = "UPDATE cliente SET telefone = '"+ telefone +"' WHERE cpf like '" + cpf + "'";             
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute(); 
            
            }else if(opcao.equals("2")){
                
                String sql = "UPDATE cliente SET endereco = '"+ address +"' WHERE cpf like '" + cpf + "'";             
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute(); 
            }else if(opcao.equals("3")){
                
                String sql = "UPDATE cliente SET telefone = '"+ telefone +"' WHERE cpf like '" + cpf + "'";             
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute();                 
                
                sql = "UPDATE cliente SET endereco = '"+ address +"' WHERE cpf like '" + cpf + "'";             
                stmt = con.prepareStatement(sql);
  
                stmt.execute();
            }                        
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        Menu.listSecao();
    } 
    
    public static void listaCliente(){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql =  "SELECT * FROM cliente";            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                
                System.out.format("%s | %s | %s | %s | %s\n", id, name, cpf, endereco, telefone);                
            }
  
            stmt.execute();   
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        Menu.listSecao();
    }   
}