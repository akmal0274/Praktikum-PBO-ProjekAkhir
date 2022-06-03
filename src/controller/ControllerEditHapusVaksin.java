/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.*;
import model.*;

/**
 *
 * @author ACER
 */
public class ControllerEditHapusVaksin {
    ViewEditHapusVaksin vehv;
    String nik;
    ModelVaksin mv;

    public ControllerEditHapusVaksin(ViewEditHapusVaksin vehv, String nik, ModelVaksin mv) {
        this.vehv = vehv;
        this.nik = nik;
        this.mv = mv;
        String detailVaksin[]=mv.detailVaksin(nik);
                vehv.l2NIK.setText(nik);
                vehv.l2Nama.setText(detailVaksin[1]);
                vehv.l2Vaksinke.setText(detailVaksin[2]);
                vehv.l2Jenisvak.setText(detailVaksin[3]);
                vehv.l2Tanggal.setText(detailVaksin[4]);
                
        vehv.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewLihatVaksin vlv=new ViewLihatVaksin();
                vehv.setVisible(false);
                ControllerLihatVaksin Start=new ControllerLihatVaksin(vlv, mv);
            }
        });
        vehv.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data Vaksin dengan NIK " + nik + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    mv.deleteData(nik);    
                    ViewLihatVaksin vlv=new ViewLihatVaksin();
                    vehv.setVisible(false);
                    ControllerLihatVaksin lbc=new ControllerLihatVaksin(vlv, mv);
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        vehv.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewInputVaksin vib=new ViewInputVaksin();
                
                vehv.setVisible(false);
                ControllerEdit editController=new ControllerEdit(vib,mv,nik);
            }
        });
    }

  
    
    
}
