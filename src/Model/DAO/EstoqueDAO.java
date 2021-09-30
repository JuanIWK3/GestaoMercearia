
package Model.DAO;

import Menu.Menu;
import Model.Estoque;
import Tools.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstoqueDAO {
    
    public static boolean chamaProduto(Estoque produto){
        
    ArrayList<Estoque> listaProduto = new ArrayList<>();
        
    listaProduto.add(produto);
    return insereProdutoEstoque(listaProduto);
 
    }
    
    public static boolean insereProdutoEstoque(ArrayList<Estoque> listaProduto){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql = "INSERT INTO estoque(codigo,nome,preco,quantidade) VALUES(?,?,?,?)"; 
            
            for(Estoque p: listaProduto){
             
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setInt(1, p.getCodigo());                        
                stmt.setString(2, p.getNome());                
                stmt.setDouble(3, p.getPreco());            
                stmt.setInt(4, p.getQuantidade());
           
                stmt.execute();  
            }
                System.out.println("Lista de produtos adicionada com sucesso!");
            
            Menu.listSecao();
            
            return true;                    
                  
        }catch (SQLException e) {
            e.printStackTrace();
        }            
        
        return false;        
    }    
    
    public static boolean insereProdutoManual(Estoque novoProduto){        
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql = "INSERT INTO estoque(codigo,nome,preco,quantidade) VALUES(?,?,?,?)"; 
            
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setInt(1, novoProduto.getCodigo());                        
                stmt.setString(2, novoProduto.getNome());                
                stmt.setDouble(3, novoProduto.getPreco());            
                stmt.setInt(4, novoProduto.getQuantidade());
           
                stmt.execute(); 
                System.out.println("Produto adicionado com sucesso");
            
                Menu.listSecao();
                
            
            return true;    
                  
        }catch (SQLException e) {
            e.printStackTrace();
        }            
        return false;        
    }    
    
    
    public static void deletaProduto(int codigo){
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql = "DELETE FROM estoque WHERE codigo =" + codigo; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
  
            stmt.execute();   
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        Menu.listSecao();
    }
    
    public static void atualizaProduto( int opcaoAtt, double preco,int quantidade,int codigo){
        //UPDATE estoque SET preco = 10  WHERE codigo = 1;
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            if(opcaoAtt == 1){               
                String sql = "UPDATE estoque SET preco = "+ preco +" WHERE codigo = "+codigo;             
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute(); 
            
            }else if(opcaoAtt == 2){
                
                String sql = "UPDATE estoque SET quantidade = "+ quantidade +" WHERE codigo = "+codigo;               
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute(); 
            }else if(opcaoAtt == 3){
                
                String sql = "UPDATE estoque SET preco = "+ preco +" WHERE codigo = "+codigo;  
                PreparedStatement stmt = con.prepareStatement(sql);
  
                stmt.execute();                 
                
                sql = "UPDATE estoque SET quantidade = "+ quantidade +" WHERE codigo = "+codigo;             
                stmt = con.prepareStatement(sql);
  
                stmt.execute();
            }                        
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        Menu.listSecao();
    }
    
    public static void listaProduto(){
        
        try(Connection con = Conexao.getConnectionMySQL()){
        
            String sql =  "SELECT * FROM estoque";            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int codigo = rs.getInt("codigo");
                String name = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                
                System.out.format("%s | %s | %s | R$ %s | %s unidades\n", id, codigo, name, preco, quantidade);                
            }
  
            stmt.execute();   
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        Menu.listSecao();
    }
}