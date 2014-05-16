
package org.rk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	Plateau plateau;
	Boolean joueur = true;

	public MorpionView(final MorpionModel mm)
	{
		this.mm = mm;
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				// frame principale avec BorderLayout
				frame = new JFrame("Morpion RK");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout());
				// Panel en-Tête avec GridBagLayout
				jpNord = new JPanel();
				gblEnTete = new GridBagLayout();
				jpNord.setLayout(gblEnTete);
				GridBagConstraints gbc = new GridBagConstraints();

				// Placement des Composants dans le GridBagLayout
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
				jbCreer.setPreferredSize(new Dimension(120, 20));
				gbc.gridheight = 1;
				gbc.gridx = 3;
				gbc.gridy = 0;
				jpNord.add(jbCreer, gbc);

				jbRejoindre = new JButton("Rejoindre");
				jbRejoindre.setPreferredSize(new Dimension(120, 20));
				gbc.gridheight = 1;
				gbc.gridx = 3;
				gbc.gridy = 1;
				jpNord.add(jbRejoindre, gbc);

				// Panel Plateau
				plateau = new Plateau(300, 300, 3, 3);
				plateau.setPreferredSize(new Dimension(300, 300));

				// Panel Historique
				jpEst = new JPanel();
				jpEst.setLayout(new FlowLayout());
				JLabel jlPartie = new JLabel("Parties Historique");
				jlPartie.setFont(new Font("Arial", Font.BOLD, 14));
				jpEst.add(jlPartie);

				// Ajout du panel entête au nord de la frame
				frame.add(jpNord, BorderLayout.NORTH);
				// Ajout du panel Plateau au centre de la frame
				frame.add(plateau, BorderLayout.CENTER);
				// Ajout du panel Historique à l'est de la frame
				frame.add(jpEst, BorderLayout.EAST);
				// Affichage de la Frame
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				plateau.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseReleased(MouseEvent arg0)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent arg0)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent arg0)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						// if (joueur)
						// {
						// plateau.cercle(arg0.getX(), arg0.getY());
						// joueur = false;
						// }
						// else
						// {
						// plateau.croix(arg0.getX(), arg0.getY());
						// joueur = true;
						// }
						// setChanged();
						// notifyObservers();
						dessinerGrille();
					}
				});
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		dessinerGrille();
	}

	public void dessinerGrille()
	{

		Case[][] grille = mm.getGrille();
		for (int i = 0; i < mm.getNbLigne(); i++)
		{
			for (int j = 0; j < mm.getNbColonne(); j++)
			{
				if (grille[i][j].getJoueur() != null)
				{
					if ((grille[i][j].getJoueur().equals(mm.getJoueur1())))
					{
						plateau.croix(i, j);
					}
					else
					{
						plateau.cercle(i, j);
					}
				}
			}
		}
	}

}
