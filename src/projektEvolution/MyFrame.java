/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektEvolution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Memetic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,200);
        
        class DoIt implements ActionListener {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

          }
        
        JPanel scopePanel = new JPanel();
        scopePanel.setBorder(BorderFactory.createTitledBorder("Dziedzina"));
        add(scopePanel, BorderLayout.NORTH);
        
	        NumberFormat format = DecimalFormat.getInstance();
	        format.setMinimumFractionDigits(10);
	        format.setMaximumFractionDigits(10);
	        format.setRoundingMode(RoundingMode.HALF_UP);
                
	        JLabel scopeBeginningLabelX = new JLabel();
	        scopeBeginningLabelX.setText("Poczatek dziedziny (");
	        JFormattedTextField scopeBeginningFieldX = new JFormattedTextField(format);
	        scopeBeginningFieldX.setColumns(10);
                
                JLabel scopeBeginningLabelY = new JLabel();
	        scopeBeginningLabelY.setText(")");
	        JFormattedTextField scopeBeginningFieldY = new JFormattedTextField(format);
	        scopeBeginningFieldY.setColumns(10);
        
        scopePanel.add(scopeBeginningLabelX);
        scopePanel.add(scopeBeginningFieldX);
        
        scopePanel.add(scopeBeginningFieldY);
        scopePanel.add(scopeBeginningLabelY);
        

	        JLabel scopeEndLabelX = new JLabel();
	        scopeEndLabelX.setText("Koniec dziedziny (");
	        JFormattedTextField scopeEndFieldX = new JFormattedTextField(format);
	        scopeEndFieldX.setColumns(10);
                
                 JLabel scopeEndLabelY = new JLabel();
	        scopeEndLabelY.setText(")");
	        JFormattedTextField scopeEndFieldY = new JFormattedTextField(format);
	        scopeEndFieldY.setColumns(10);
        
        scopePanel.add(scopeEndLabelX);
        scopePanel.add(scopeEndFieldX);
         
        scopePanel.add(scopeEndFieldY);
        scopePanel.add(scopeEndLabelY);
        
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
	        submitButton.addActionListener(new DoIt());
	        buttonPanel.add(submitButton);
	        
	    setLocationRelativeTo(null);
	   
        setVisible(true);
    }
}
