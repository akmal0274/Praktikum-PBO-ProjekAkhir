/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.*;
import model.*;

/**
 *
 * @author ACER
 */
public class ControllerLihatVaksin {
    ViewLihatVaksin vlv;
    ModelVaksin mv;

    public ControllerLihatVaksin(ViewLihatVaksin vlv, ModelVaksin mv) {
        this.vlv = vlv;
        this.mv = mv;
        if (mv.getBanyakData()!=0) {
            String dataVaksin[][] = mv.readVaksin();
            vlv.tabel.setModel((new JTable(dataVaksin, vlv.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        vlv.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewMainMenu vmm=new ViewMainMenu();
                vlv.setVisible(false);
                ControllerMainMenu mmc=new ControllerMainMenu(vmm);
            }
        });
        
        vlv.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = vlv.tabel.getSelectedRow();                

                String dataterpilih = vlv.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                ViewEditHapusVaksin vbb=new ViewEditHapusVaksin();
                vlv.setVisible(false);
                ControllerEditHapusVaksin bbc=new ControllerEditHapusVaksin(vbb,dataterpilih,mv);
                
                                                                            
            }
        }
        );
    }

 

    
    
}
