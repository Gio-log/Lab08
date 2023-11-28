package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CCuboid extends CSolid{
    protected int a;
    protected int b;

    public CCuboid(int a, int b, int m) {
        this.a = a;
        this.b = b;
        this.Mass = m;
    }
    double momentOfInertia(){
        double m = Mass;
        return m/12*(a*a+b*b);
    };
    void getData(JTable table){
        if(Mass<0 || a<0 || b<0){
            throw new IllegalArgumentException("Podane złe wartości");
        }
        else {
            Mass = Integer.parseInt(table.getValueAt(0, 1).toString());
            a = Integer.parseInt(table.getValueAt(1, 1).toString());
            b = Integer.parseInt(table.getValueAt(2, 1).toString());
        }
    };
    void showData(JTable table, DefaultTableModel model){
        model.setRowCount(3);
        table.setValueAt("Masa",0,0);
        table.setValueAt(Mass,0,1);
        table.setValueAt("Promień zewnętrzny",1,0);
        table.setValueAt(a,1,1);
        table.setValueAt("Promień wewnętrzny",2,0);
        table.setValueAt(b,2,1);
    };
}
