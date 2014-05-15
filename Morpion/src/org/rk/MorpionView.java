
package org.rk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author ronan
 * 
 */
public class MorpionView extends Observable implements Observer
{
	MorpionModel mm;
	JFrame frame;
	JPanel jpNord, jpEst;
	GridBagLayout gblEnTete;
	JTextField jtNom;
	JButton jbCreer, jbRejoindre;

	public MorpionView(MorpionModel mm)
	{
		this.mm = mm;
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				frame = new JFrame("Morpion RK");
				frame.getContentPane().setLayout(new BorderLayout());
				jpNord = new JPanel();
				// jpNord.setPreferredSize(new Dimension(5, 20));
				gblEnTete = new GridBagLayout();
				jpNord.setLayout(gblEnTete);
				GridBagConstraints gbc = new GridBagConstraints();

				JLabel jlNom = new JLabel("Nom : ");
				gbc.gridheight = 2;
				gbc.gridx = 0;
				gbc.gridy = 0;
				jpNord.add(jlNom, gbc);

				jtNom = new JTextField();
				jtNom.setPreferredSize(new Dimension(100, 20));
				gbc.gridx = 1;
				jpNord.add(jtNom, gbc);

				jbCreer = new JButton("Créer");
				jbCreer.setPreferredSize(new Dimension(100, 20));
				gbc.gridheight = 1;
				gbc.gridx = 2;
				gbc.gridy = 0;
				jpNord.add(jbCreer, gbc);

				jbRejoindre = new JButton("Créer");
				jbRejoindre.setPreferredSize(new Dimension(100, 20));
				gbc.gridheight = 1;
				gbc.gridx = 2;
				gbc.gridy = 1;
				jpNord.add(jbRejoindre, gbc);

				// Ajout du panel entête au nord de la frame
				frame.add(jpNord, BorderLayout.NORTH);
				// Affichage de la Frame
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub

	}

}
