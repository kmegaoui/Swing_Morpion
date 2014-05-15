
package org.rk;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author ronan
 * 
 */
public class MorpionView extends Observable implements Observer
{
	MorpionModel mm;
	JFrame frame;
	JPanel jpNorth, jpEast;
	GridBagLayout gblHead;

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
				jpNorth = new JPanel();
				gblHead = new GridBagLayout();
				jpNorth.setLayout(gblHead);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridheight = 2;
				gbc.gridx = 0;
				gbc.gridy = 0;
				JLabel jlNom = new JLabel("Nom : ");
				jpNorth.add(jlNom, gbc);

				frame.add(jpNorth, BorderLayout.NORTH);

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
