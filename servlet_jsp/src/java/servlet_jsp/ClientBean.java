/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_jsp;
import java.sql.*;


/**
 *
 * @author kowsik
 */
public class ClientBean {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean registered; 
    
    private String driver = "org.apache.derby.jdbc.ClientDriver"; 
    public ClientBean(){
        try {
        Class.forName(driver);
        } catch(ClassNotFoundException e) {}
    }
    
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRegistered(boolean registered){
        this.registered = registered;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public boolean getRegistered(){
        return this.registered;
    }
    
    public void registerCustomer() throws SQLException{
        Connection connection = null ;
        if (! isRegistered()){
            String insterStatementStr = "INSERT INTO UTILISATEUR (nom,prenom,email,password) VALUES ('"+this.lastName+"','"+this.firstName+"','"+this.email+"','"+this.password+"')";
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            Statement insertStatement = connection.createStatement();
            insertStatement.executeUpdate(insterStatementStr);
        }finally{
            if (connection != null){
                try{
                    connection.close();
                }catch(SQLException sqle){}
            }
        }
        registered = true;
        }
    }
    
    public boolean isRegistered() throws SQLException{
        Connection connection = null;
        String selectCustomerStr = "SELECT  nom,prenom,email,password FROM UTILISATEUR WHERE email = ?";
        boolean clientExists = false;
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();
            
            if (rs.next()){
                setFirstName(rs.getString("prenom"));
                setLastName(rs.getString("nom"));
                setEmail(rs.getString("email"));
                setPassword(rs.getString("password"));
                
                clientExists = true;
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        return clientExists;
    }
    
    
    public int getUserId() throws SQLException{
        Connection connection = null;
        String selectCustomerStr = "SELECT  identifiant FROM UTILISATEUR WHERE email = ?";
        int clientExists = -1;
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mvc_1","useradmin","useradmin");
            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);
            connection.prepareStatement(selectCustomerStr);
            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();
            
            if (rs.next()){       
                clientExists = rs.getInt("identifiant");
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException sqle){}
            }
        }
        return clientExists;
    }
    
    
    public void login(){
        this.registered = true;
    }
    
    public void logout(){
        this.registered = false;
    }
}
