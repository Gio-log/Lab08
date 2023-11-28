package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CPipe extends CCylinder{
    protected int r;

    public CPipe(int r, int m, int r1) {
        super(r, m);
        this.r = r1;
    }

    @Override
    double momentOfInertia() {
        return 0.5*Mass*((R*R)+(r*r));
    }

    @Override
    void getData(JTable table){
        if(Mass<0 || R<0 || r<0){
            throw new IllegalArgumentException("Podane złe wartości");
        }
        else {
            Mass = Integer.parseInt(table.getValueAt(0,1).toString());
            R = Integer.parseInt(table.getValueAt(1,1).toString());
            r = Integer.parseInt(table.getValueAt(2,1).toString());
        }
    };
    void showData(JTable table, DefaultTableModel model){
        model.setRowCount(3);
        table.setValueAt("Masa",0,0);
        table.setValueAt(Mass,0,1);
        table.setValueAt("Promień zewnętrzny",1,0);
        table.setValueAt(R,1,1);
        table.setValueAt("Promień wewnętrzny",2,0);
        table.setValueAt(r,2,1);
    };
}
