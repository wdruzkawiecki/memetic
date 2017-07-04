/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektEvolution;

import java.awt.BorderLayout;
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

public class MyFrame extends JFrame {
	JFormattedTextField scopeBeginningFieldX;
	JFormattedTextField scopeBeginningFieldY;
	JFormattedTextField scopeEndFieldX;
	JFormattedTextField scopeEndFieldY;
	JCheckBox evolutionStrategyCheckbox;
	JCheckBox psoCheckbox;
	JCheckBox blxCheckbox;

	public MyFrame() {
		super("Memetic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 200);

		JPanel scopePanel = new JPanel();
		scopePanel.setBorder(BorderFactory.createTitledBorder("Dziedzina"));
		add(scopePanel, BorderLayout.NORTH);

		NumberFormat format = DecimalFormat.getInstance();
		format.setMinimumFractionDigits(10);
		format.setMaximumFractionDigits(10);
		format.setRoundingMode(RoundingMode.HALF_UP);

		JLabel scopeBeginningLabelX = new JLabel();
		scopeBeginningLabelX.setText("Poczatek dziedziny (");
		scopeBeginningFieldX = new JFormattedTextField(format);
		scopeBeginningFieldX.setColumns(10);

		JLabel scopeBeginningLabelY = new JLabel();
		scopeBeginningLabelY.setText(")");
		scopeBeginningFieldY = new JFormattedTextField(format);
		scopeBeginningFieldY.setColumns(10);

		scopePanel.add(scopeBeginningLabelX);
		scopePanel.add(scopeBeginningFieldX);

		scopePanel.add(scopeBeginningFieldY);
		scopePanel.add(scopeBeginningLabelY);

		JLabel scopeEndLabelX = new JLabel();
		scopeEndLabelX.setText("Koniec dziedziny (");
		scopeEndFieldX = new JFormattedTextField(format);
		scopeEndFieldX.setColumns(10);

		JLabel scopeEndLabelY = new JLabel();
		scopeEndLabelY.setText(")");
		scopeEndFieldY = new JFormattedTextField(format);
		scopeEndFieldY.setColumns(10);

		scopePanel.add(scopeEndLabelX);
		scopePanel.add(scopeEndFieldX);

		scopePanel.add(scopeEndFieldY);
		scopePanel.add(scopeEndLabelY);

//		JPanel algorithmsPanel = new JPanel();
//		algorithmsPanel.setBorder(BorderFactory.createTitledBorder("Algorytmy"));
//		add(algorithmsPanel, BorderLayout.CENTER);
//
//		evolutionStrategyCheckbox = new JCheckBox("Evolution Strategy");
//		algorithmsPanel.add(evolutionStrategyCheckbox);
//
//		psoCheckbox = new JCheckBox("PSO");
//		algorithmsPanel.add(psoCheckbox);
//
//		blxCheckbox = new JCheckBox("BLX");
//		algorithmsPanel.add(blxCheckbox);
//
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
		add(buttonPanel, BorderLayout.SOUTH);

		JButton submitButton = new JButton();
		submitButton.setText("Generuj");

		buttonPanel.add(submitButton);

		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				double ax, ay, bx, by;
				String axStr = scopeBeginningFieldX.getText().replace(",", ".");
				ax = axStr.isEmpty() ? -10 : Double.parseDouble(axStr);

				String ayStr = scopeBeginningFieldY.getText().replace(",", ".");
				ay = ayStr.isEmpty() ? 10 : Double.parseDouble(ayStr);

				String bxStr = scopeEndFieldX.getText().replace(",", ".");
				bx = bxStr.isEmpty() ? -10 : Double.parseDouble(bxStr);

				String byStr = scopeEndFieldY.getText().replace(",", ".");
				by = byStr.isEmpty() ? 10 : Double.parseDouble(byStr);

				// boolean evolution = evolutionStrategyCheckbox.isSelected();
				// boolean pso = psoCheckbox.isSelected();
				// boolean blx = blxCheckbox.isSelected();
				////
				// RandomGen RandomGen = new RandomGen();
				// double[][] populacja = RandomGen.randFunctionDouble(ax, ay, bx, by, 1000);
				// System.out.println(Arrays.toString(populacja));
				//
				// if (evolution) {
				// }
				// if (pso) {
				// }
				// if (blx) {
				// }

				Domain domain = new Domain(new Point(new double[] { ax, ay }), new Point(new double[] { bx, by }));

				Population initialPopulation = Population.CreateInitialPopulation(domain, 100);

				Solver solver = new Solver(new EvolutionAlgorithm(initialPopulation, new RastriginFunction(), 50),
						domain, new RastriginFunction(), initialPopulation);

				Population result = solver.getSolution();

				System.out.print(result);
			}

		});

		setLocationRelativeTo(null);

		setVisible(true);
	}
}
