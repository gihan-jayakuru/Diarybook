
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME
 */
public class registerquery {
    
     myConnection connection=new myConnection();

        public boolean insertuser(String id, String name, String password){
        
        PreparedStatement st;
        ResultSet rs;
        String addQuery="INSERT INTO `users`(`id`, `user_name`, `password`) VALUES (?,?,?)";
        
        
            
            
            try {
                st=connection.createConnection().prepareStatement(addQuery);
                st.setString(1, id);
                st.setString(2, name);
                st.setString(3, password);
            
                return (st.executeUpdate()>0); 
            }
             catch (SQLException ex) {
                Logger.getLogger(registerquery.class.getName()).log(Level.SEVERE, null, ex);
            }     
            return false;
             
        }
    
}
