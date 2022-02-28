/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Acer
 */import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class Student {
  int jpassword;
  String jFname;
  String jLname;
  String jDateBD;
  String jVillage;
  String jDt;
  String jprovine;
  String jlevel;
  String jparent;

    public Student(int jpassword, String jFname, String jLname, String jDateBD, String jVillage, String jDt, String jprovine, String jlevel, String jparent) {
        this.jpassword = jpassword;
        this.jFname = jFname;
        this.jLname = jLname;
        this.jDateBD = jDateBD;
        this.jVillage = jVillage;
        this.jDt = jDt;
        this.jprovine = jprovine;
        this.jlevel = jlevel;
        this.jparent = jparent;
    }

    public void setJpassword(int jpassword) {
        this.jpassword = jpassword;
    }

    public void setjFname(String jFname) {
        this.jFname = jFname;
    }

    public void setjLname(String jLname) {
        this.jLname = jLname;
    }

    public void setjDateBD(String jDateBD) {
        this.jDateBD = jDateBD;
    }

    public void setjVillage(String jVillage) {
        this.jVillage = jVillage;
    }

    public void setjDt(String jDt) {
        this.jDt = jDt;
    }

    public void setJprovine(String jprovine) {
        this.jprovine = jprovine;
    }

    public void setJlevel(String jlevel) {
        this.jlevel = jlevel;
    }

    public void setJparent(String jparent) {
        this.jparent = jparent;
    }

    public int getJpassword() {
        return jpassword;
    }

    public String getjFname() {
        return jFname;
    }

    public String getjLname() {
        return jLname;
    }

    public String getjDateBD() {
        return jDateBD;
    }

    public String getjVillage() {
        return jVillage;
    }

    public String getjDt() {
        return jDt;
    }

    public String getJprovine() {
        return jprovine;
    }

    public String getJlevel() {
        return jlevel;
    }

    public String getJparent() {
        return jparent;
    }
    
    
   public static void addStudent (int id, String Fname, String Lname, String DateBD, String Village, 
           String District, String Provine, String Level,String Parent){
       String insertQuery = "insert into Student(id, Fname, Lname, BD, district,"
               + " Village, Province,Level, Parent ) values (?,?,?,?,?,?,?,?,?)";
      try {
          PreparedStatement ps = DB_Con.getConnection().prepareStatement(insertQuery);
          ps.setInt(1, id);
          ps.setString(2, Fname);
          ps.setString(3, Lname);
          ps.setString(4, DateBD);
          ps.setString(5,Village);
          ps.setString(6, District);
          ps.setString(7,Provine);
          ps.setString(8, Level);
          ps.setString(9, Parent);
          if (ps.executeUpdate()!=0){
              JOptionPane.showMessageDialog(null, "sam let leo");
      
          }
          else 
          {
              JOptionPane.showMessageDialog(null, "Br sam let");
          }
              
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
   } 
      public static ArrayList<Student> STUDENTList(String searchQuery){
        ArrayList<Student> studentList = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String selectQuery = "select * from Student";
        String query = "";
        
        if(searchQuery != ""){
            query = searchQuery;
        }else{
            query = selectQuery;
        }
        try {
            
            ps = DB_Con.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
           
            while(rs.next()){
                
               Student student = new Student(rs.getInt("id"), rs.getString("Fname"),
                       rs.getString("Lname"),rs.getString("BD"),rs.getString("village"),
                       rs.getString("district"),rs.getString("province"),rs.getString("level"),
                       rs.getString("parent"));
                studentList.add(student);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }
      
    public static void deleteQuery(int id){
        String query = "delete from Student where id ='"+id+"'";
        PreparedStatement ps;
        
        try{
            ps = DB_Con.getConnection().prepareStatement(query);
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "data have been deleted");
            }else{
                JOptionPane.showMessageDialog(null, "deleted have been fail");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void searchQuery(String name){
        String query = "select name from Student where name = '" +name+"'";
        
        PreparedStatement ps;
        try{
            ps = DB_Con.getConnection().prepareStatement(query);
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "search have been found");
            }else{
                JOptionPane.showMessageDialog(null, "search is not found");
            }
        }catch(Exception e){
            
        }
    }
        
}
