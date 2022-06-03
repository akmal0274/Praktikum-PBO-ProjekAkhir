/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelVaksin;
import view.*;

/**
 *
 * @author ACER
 */
public class ControllerMainMenu {
    ViewMainMenu viewmainmenu;

    public ControllerMainMenu(ViewMainMenu viewmainmenu) {
        this.viewmainmenu = viewmainmenu;
        
        viewmainmenu.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ModelVaksin modelvaksin = new ModelVaksin();
                ViewInputVaksin inputvaksin= new ViewInputVaksin();
                viewmainmenu.setVisible(false);
                ControllerInputVaksin inputvaksinController=new ControllerInputVaksin(inputvaksin,modelvaksin);
            }
        });
        
        viewmainmenu.btnLihat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) { 
                ViewLihatVaksin lihatvaksin= new ViewLihatVaksin();
                ModelVaksin modelvaksin = new ModelVaksin();
                viewmainmenu.setVisible(false);
                ControllerLihatVaksin lihatvaksinController =new ControllerLihatVaksin(lihatvaksin,modelvaksin);
            }
        });
    }

    
    
    
    
}