package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class CSolid {
    protected int Mass;
    abstract double momentOfInertia();
    abstract void getData(JTable table);
    abstract void showData(JTable table, DefaultTableModel model);
}
