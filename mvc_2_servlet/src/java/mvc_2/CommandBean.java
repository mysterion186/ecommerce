/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_2;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kowsik
 */
public class CommandBean {
    
    private int idArticle;
    private int idCommande;
    private int idUser;
    
    private String driver = "org.apache.derby.jdbc.ClientDriver"; 
    
    public CommandBean(){
        try {
        Class.forName(driver);
        }  catch(ClassNotFoundException e) {}
    }
    
    
    public void setIdArticle(int idArticle){
        this.idArticle = idArticle;
    }
    
    public void setIdCommande(int idCommande){
        this.idCommande = idCommande;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
      
    
    public int getIdArticle(){
        return this.idArticle;
    }
    
    public int getIdCommande(){
        return this.idCommande;
    }
    
    public int getIdUser(){
        return this.idUser;
    }
    
    public int checkForCurrentCommand()throws SQLException {
        Connection connection = null;
        int current_id = -1;
        String selectCustomerStr = "SELECT * FROM Commande WHERE iduser="+this.idUser+" AND status = 'cours' ";
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            ResultSet rs = selectStatement.executeQuery();
            if (rs.next()){
                 current_id = rs.getInt("idcommande");
            }
            else {
                String insertCommandeStr = "INSERT INTO commande(iduser,prix,status) VALUES ("+this.idUser+","+0+",'cours')";
                selectStatement = connection.prepareStatement(insertCommandeStr);
                connection.prepareStatement(insertCommandeStr);
                selectStatement.executeUpdate();
                
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
                selectStatement = connection.prepareStatement(selectCustomerStr);
                connection.prepareStatement(selectCustomerStr);
                rs = selectStatement.executeQuery();
                if (rs.next()){
                     current_id = rs.getInt("idcommande");
                }
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        } 
        this.idCommande = current_id;
        return current_id;
    }
    
    public void addPanier() throws SQLException{
        Connection connection = null; 
        int id_commande = this.checkForCurrentCommand(); 
        boolean exists = false;
        String selectCommandeStr = "SELECT * FROM commande_detail WHERE idcommande="+this.idCommande;
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCommandeStr);
            connection.prepareStatement(selectCommandeStr);
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()){
                if(rs.getInt("idarticle")==this.idArticle){
                    exists = true;
                    break;
                }
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        
        String insertCommandeStr = "INSERT INTO commande_detail (idarticle,idcommande,iduser) VALUES ("+this.idArticle+","+this.idCommande+","+this.idUser+")";
        if (!exists){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(insertCommandeStr);
            connection.prepareStatement(insertCommandeStr);
            selectStatement.executeUpdate();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        } 
    }
        
        
    }
    
     public ArrayList<ArticleBean> getPanier() throws SQLException {
        ArrayList<ArticleBean> articles = new ArrayList<ArticleBean>();
        ArrayList<Integer> identifiant = new ArrayList<Integer>();
        Connection connection = null;
        String selectCustomerStr = "SELECT * FROM Commande_detail WHERE idcommande="+this.idCommande;
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()){
                identifiant.add(rs.getInt("idArticle"));
            }
            
            for (int id : identifiant){
                selectCustomerStr = "SELECT * FROM article WHERE idarticle="+id;
                selectStatement = connection.prepareStatement(selectCustomerStr);
                connection.prepareStatement(selectCustomerStr);
                rs = selectStatement.executeQuery();
                while (rs.next()){
                ArticleBean temp = new ArticleBean();
                temp.setIdArticle(rs.getInt("IDARTICLE"));
                temp.setNomArticle(rs.getString("nom"));
                temp.setPhoto_url(rs.getString("photo_url"));
                temp.setDescription(rs.getString("description"));
                temp.setCategorie(rs.getString("Categorie"));
                temp.setPrix(rs.getInt("prix"));
                articles.add(temp);
                }
            }
            
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        return articles;
     }
     
     public void buy(int prix) throws SQLException{
         Connection connection = null; 
          String selectCustomerStr = "UPDATE commande SET status = 'terminé', prix = "+prix+" WHERE idcommande="+this.idCommande;
          try{
              connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
              PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
              connection.prepareStatement(selectCustomerStr);
              selectStatement.executeUpdate();
          }
          finally{
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
     }
}
