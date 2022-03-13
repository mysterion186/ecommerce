/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_1;
import java.sql.*;
import java.util.ArrayList; // import the ArrayList class 
/**
 *
 * @author kowsik
 */
public class ArticleBean {
    private int idArticle;
    private String nomArticle;
    private String photo_url;
    private String description;
    private String categorie;
    private int prix;
    
    private String driver = "org.apache.derby.jdbc.ClientDriver"; 
    
    public ArticleBean(){
        try {
        Class.forName(driver);
        }  catch(ClassNotFoundException e) {}
    }
    public void setIdArticle(int idArticle){
        this.idArticle = idArticle;

    }
    
    public void setNomArticle(String nomArticle){
        this.nomArticle = nomArticle;
    }
    
    public void setPhoto_url(String photo_url){
        this.photo_url = photo_url;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setCategorie(String categorie){
        this.categorie = categorie;
    }
    
    public void setPrix(int prix){
        this.prix = prix;
    }
    
    public int getIdArticle(){
        return this.idArticle;
    }
    
    public String getNomArticle(){
        return this.nomArticle;
    }
    
    public String getPhoto_url(){
        return this.photo_url;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getCategorie(){
        return this.categorie;
    }
    
    public int getPrix(){
        return this.prix;
    }
    
    public ArrayList<ArticleBean> getAllArticles() throws SQLException {
        ArrayList<ArticleBean> articles = new ArrayList<ArticleBean>();
        Connection connection = null;
        String selectCustomerStr = "SELECT * FROM Article ";
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            ResultSet rs = selectStatement.executeQuery();
            
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
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        return articles;
    }
    
    public ArticleBean getProductInfo(int articleId) throws SQLException{
        Connection connection = null;
        ArticleBean temp = new ArticleBean();
        String selectCustomerStr = "SELECT * FROM Article WHERE idarticle="+articleId;
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            ResultSet rs = selectStatement.executeQuery();
            
            if (rs.next()){
                temp.setIdArticle(rs.getInt("IDARTICLE"));
                temp.setNomArticle(rs.getString("nom"));
                temp.setPhoto_url(rs.getString("photo_url"));
                temp.setDescription(rs.getString("description"));
                temp.setCategorie(rs.getString("Categorie"));
                temp.setPrix(rs.getInt("prix"));
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        return temp;
    }
}

