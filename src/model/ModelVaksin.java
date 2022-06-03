/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class ModelVaksin {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/program_vaksin";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModelVaksin() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readVaksin(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "SELECT * FROM data_vaksin"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nik"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama");                
                data[jmlData][2] = String.valueOf(resultSet.getInt("vaksinke"));
                data[jmlData][3] = resultSet.getString("jenisvaksin");
                data[jmlData][4] = String.valueOf(resultSet.getDate("tanggal"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String NIK, String Nama, int Vaksinke, String JenisVaksin, Date Tanggal){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM data_vaksin WHERE nik='" + NIK+"'"; 
           System.out.println(NIK + " " + Nama + " " + Vaksinke + " " + JenisVaksin + " " + Tanggal);
           statement = koneksi.createStatement();
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            statement.close();
            if (jmlData==0) {
                query = "INSERT INTO data_vaksin(nik,nama,vaksinke,jenisvaksin,tanggal) VALUES('"+NIK+"','"+Nama+"','"+Vaksinke+"','"+JenisVaksin+"','"+Tanggal+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String NIK, String Nama, int Vaksinke, String JenisVaksin, Date Tanggal){
        int jmlData=0;
         try {
           String query = "SELECT * FROM data_vaksin WHERE nik='" + NIK+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE data_vaksin SET nama='" + Nama + "', vaksinke='" + Vaksinke + "', jenisvaksin='"+ JenisVaksin+"', tanggal='"+ Tanggal+"' WHERE nik='" + NIK+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM data_vaksin";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData (String NIK) {
        try{
            String query = "DELETE FROM data_vaksin WHERE nik = '"+NIK+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    public String[] detailVaksin(String nik) {
        try{
            String data[] = new String[5];
            String query = "SELECT * FROM data_vaksin WHERE nik = '"+nik+"'";            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("nik"); //harus sesuai nama kolom di mysql
                data[1] = resultSet.getString("nama");
                data[2] = String.valueOf(resultSet.getInt("vaksinke"));               
                data[3] = resultSet.getString("jenisvaksin");
                data[4] = String.valueOf(resultSet.getDate("tanggal"));  
            }
            System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
            return data;
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}