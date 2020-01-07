
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class noteQuery {
    
//    public boolean insertnote(String title,String note,String date,byte[] pic)
//    {
//       boolean contactIsCreated=true;
//        
//         com.mysql.jdbc.Connection con=null;
//            
//        try {
//            Class.forName("com.mysql.Driver");
//            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/diarybook","root","");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        PreparedStatement ps;
//        
//        try {
//            ps=con.prepareStatement("INSERT INTO `data`(`title`, `note`, `date`, `image`) VALUES (?,?,?,?)");
//            ps.setString(1, title);
//            ps.setString(2, note);
//            ps.setString(3, date);
//           
//            ps.setBytes(4, pic);
//            
//            if(ps.executeUpdate()!=0){
//            
//                JOptionPane.showMessageDialog(null, "note ADDED !");
//               contactIsCreated=true;
//            }else{
//            
//                JOptionPane.showMessageDialog(null, "Not ADDED !");
//                contactIsCreated=false;
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(noteQuery.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    return contactIsCreated;
//    
//    }
    
    public ArrayList<note>notelist(){

        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/diarybook","root","");
        } catch (Exception ex) {
            Logger.getLogger(noteQuery.class.getName()).log(Level.SEVERE, null, ex);
       
        
        }
         ArrayList<note>nlist = new ArrayList<>();
         
         Statement st;
        ResultSet rs;
        
        try {
            st=con.createStatement();
            rs=st.executeQuery("SELECT `title`, `note`, `date`, `image` FROM `data` ");
            
            note nt;
            
            while(rs.next()){
                                                                 System.out.println("note returned");
                nt=new note(rs.getString("title"),
                        rs.getString("note"),
                        rs.getString("date"),
                        rs.getBytes("image")
                );
            
            nlist.add(nt);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(noteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return nlist;
    
    }

    
}
