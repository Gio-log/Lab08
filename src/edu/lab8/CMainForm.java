package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class CMainForm extends javax.swing.JFrame{
    private JPanel mainPanel;
    private JPanel picturePanel;
    private JComboBox comboBox1;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JTable table1;
    private DefaultTableModel model;
    private CSolid[] solids = new CSolid[6];

    private void createUIComponents() {
        // TODO: place custom component creation code here
        picturePanel = new edu.lab8.CPaintPanel();
    }
    private void frameOpened(){
        String n[] = {"Nazwa","Wartość"};
        model = new DefaultTableModel(null,n);
        table1.setModel(model);
        table1.putClientProperty("terminateEditOnFocusLost",Boolean.TRUE);
        comboBox1.setSelectedIndex(0);
        calculateActionPerformed();
    };
    private void comboBoxActionPerformed(){
        int idx = comboBox1.getSelectedIndex();
        String s = String.format("/resource/%d.png",idx+1);
        URL imageURL = CMainForm.class.getResource(s);
        if(imageURL!=null){
            ImageIcon im = new ImageIcon(imageURL);
            ((edu.lab8.CPaintPanel)picturePanel).AssignRys(im.getImage());
        }
        picturePanel.repaint();
        solids[idx].showData(table1,model);
    };
    private void calculateActionPerformed(){
        int idx = comboBox1.getSelectedIndex();
        solids[idx].getData(table1);
        resultLabel.setText(
                String.format("I = %8.3f",solids[idx].momentOfInertia())
        );
    };

    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent we){
                frameOpened();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxActionPerformed();
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateActionPerformed();
            }
        });
        solids[0] = new CSphere(2, 5);
        solids[1] = new CPlate(4, 3);
        solids[2] = new CCone(2, 3);
        solids[3] = new CCylinder(5, 5);
        solids[4] = new CPipe(7, 5,4);
        solids[5] = new CCuboid(8, 8,8);
    }
}
