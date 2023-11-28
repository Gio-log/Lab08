package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CSphere extends CSolid{
    protected int R;

    public CSphere(int r, int m) {
        this.R = r;
        this.Mass = m;
    }

    double momentOfInertia(){
        return 0.4*Mass*R*R;
    };
    void getData(JTable table){
        if(Mass<0 || R<0){
            throw new IllegalArgumentException("Podane złe wartości");
        }
        else {
            Mass = Integer.parseInt(table.getValueAt(0,1).toString());
            R = Integer.parseInt(table.getValueAt(1,1).toString());
        }
    };
    void showData(JTable table, DefaultTableModel model){
        model.setRowCount(2);
        table.setValueAt("Masa",0,0);
        table.setValueAt(Mass,0,1);
        table.setValueAt("Promień",1,0);
        table.setValueAt(R,1,1);
    };
}
