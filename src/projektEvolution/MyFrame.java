/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektEvolution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Memetic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,200);
        
        JPanel scopePanel = new JPanel();
        scopePanel.setBorder(BorderFactory.createTitledBorder("Dziedzina"));
        add(scopePanel, BorderLayout.NORTH);
        
        JLabel scopeBeginningLabel = new JLabel();
        scopeBeginningLabel.setText("Poczatek dziedziny:");
        JTextField scopeBeginningField = new JTextField(10);
        
        scopePanel.add(scopeBeginningLabel);
        scopePanel.add(scopeBeginningField);
        
        JLabel scopeEndLabel = new JLabel();
        scopeEndLabel.setText("Koniec dziedziny:");
        JTextField scopeEndField = new JTextField(10);
        
        scopePanel.add(scopeEndLabel);
        scopePanel.add(scopeEndField);
            
        JPanel algorithmsPanel = new JPanel();
        algorithmsPanel.setBorder(BorderFactory.createTitledBorder("Algorytmy"));
        add(algorithmsPanel, BorderLayout.CENTER);
        
        JCheckBox evolutionStrategyCheckbox = new JCheckBox("Evolution Strategy");
        algorithmsPanel.add(evolutionStrategyCheckbox);
        
        JCheckBox psoCheckbox = new JCheckBox("PSO");
        algorithmsPanel.add(psoCheckbox);
        
        JCheckBox blxCheckbox = new JCheckBox("BLX");
        algorithmsPanel.add(blxCheckbox);
         
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
        add(buttonPanel, BorderLayout.SOUTH);
        
        JButton submitButton = new JButton();
        submitButton.setText("Generuj");
        buttonPanel.add(submitButton);
   
        setVisible(true);
    }
}
