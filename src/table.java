
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME
 */

public class table {
     //BufferedImage bimage=null;
    Blob blob;
    myConnection myconnection =new myConnection();
    
      public void fillTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `data`";
        
        try {
 
            ps = myconnection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tablemodel= (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[4];//column on table
                row[0]=rs.getString(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getBytes(4);//get Bytes of the pic
                
            //  blob=rs.getBlob();
                
                
                 
              //BufferedImage bimage=  ImageIO.read(new ByteArrayInputStream(blob));
                 
               
                tablemodel.addRow(row);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}
