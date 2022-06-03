/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author ACER
 */
public class ViewMainMenu extends JFrame{
    JLabel judul = new JLabel("Main Menu");
    public JButton btnTambah = new JButton("Tambah Data");
    public JButton btnLihat = new JButton("Lihat Data");

    public ViewMainMenu() {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
        setSize(200,200);
        setLocationRelativeTo(null);
        
        add(judul);
        judul.setBounds(65, 5, 100, 30);
        
        add(btnTambah);
        btnTambah.setBounds(25, 40, 140, 30);
        
        add(btnLihat);
        btnLihat.setBounds(25, 90, 140,30);
    }
    
}
