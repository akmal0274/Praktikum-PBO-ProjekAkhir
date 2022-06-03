/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewLihatVaksin extends JFrame{
    public JButton btnKembali = new JButton("Kembali");  
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NIK", "Nama", "Vaksin Ke-", "Jenis Vaksin", "Tanggal"};

    public ViewLihatVaksin() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Vaksin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600,500);
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
              
        add(btnKembali);
        btnKembali.setBounds(20, 420, 90, 20);
    }   
}
