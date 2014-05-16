/**
 * 
 */

package org.rk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author ronan
 * 
 */
public class Plateau extends JPanel
{
	private MorpionModel mm;
	private Integer nbCaseX, nbCaseY, tailleX, tailleY, CoordCaseX, CoordCaseY;
	private Integer tailleCaseX, tailleCaseY;

	/**
	 * @return the tailleCaseX
	 */
	public Integer getTailleCaseX()
	{
		return tailleCaseX;
	}

	/**
	 * @param tailleCaseX
	 *            the tailleCaseX to set
	 */
	public void setTailleCaseX(Integer tailleCaseX)
	{
		this.tailleCaseX = tailleCaseX;
	}

	/**
	 * @return the tailleCaseY
	 */
	public Integer getTailleCaseY()
	{
		return tailleCaseY;
	}

	/**
	 * @param tailleCaseY
	 *            the tailleCaseY to set
	 */
	public void setTailleCaseY(Integer tailleCaseY)
	{
		this.tailleCaseY = tailleCaseY;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1771331963597200288L;

	public Plateau(int tailleX, int tailleY, int nbCaseX, int nbCaseY,
			MorpionModel mm)
	{
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.nbCaseX = nbCaseX;
		this.nbCaseY = nbCaseY;
		this.tailleCaseX = Math.round((float) tailleX / nbCaseX);
		this.tailleCaseY = Math.round((float) tailleY / nbCaseY);
		this.mm = mm;

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		int i = 1;
		while (i < nbCaseX)
		{
			((Graphics2D) g).drawLine(tailleCaseX * i, 0, tailleCaseX * i,
					tailleY);
			i++;
		}
		i = 1;
		while (i < nbCaseY)
		{
			((Graphics2D) g).drawLine(0, tailleCaseY * i, tailleX, tailleCaseY
					* i);
			i++;
		}
		((Graphics2D) g).setColor(Color.BLUE);
		((Graphics2D) g).drawRect(0, 0, this.getWidth() - 1,
				this.getHeight() - 1);
		dessinerGrille((Graphics2D) g);

	}

	public void cercle(int numLigne, int numColonne, Graphics2D g)
	{

		// Calcul des coordonnées dans la grille
		CoordCaseX = numColonne;
		CoordCaseY = numLigne;
		int baseX = 10 + (CoordCaseX * tailleCaseX);
		int baseY = 10 + (CoordCaseY * tailleCaseY);
		g.drawOval(baseX, baseY, tailleCaseX - 20, tailleCaseY - 20);
	}

	public void croix(int numLigne, int numColonne, Graphics2D g)
	{

		// Calcul des coordonnées dans la grille
		CoordCaseX = numColonne;
		CoordCaseY = numLigne;
		int baseX = 10 + (CoordCaseX * tailleCaseX);
		int baseY = 10 + (CoordCaseY * tailleCaseY);
		int finX = (tailleCaseX - 10) + (CoordCaseX * tailleCaseX);
		int finY = (tailleCaseY - 10) + (CoordCaseY * tailleCaseY);
		g.drawLine(baseX, baseY, finX, finY);
		g.drawLine(baseX, finY, finX, baseY);

	}

	public void dessinerGrille(Graphics2D g)
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
						croix(i, j, g);
					}
					else
					{
						cercle(i, j, g);
					}
				}
			}
		}
	}

	/**
	 * @return the tailleX
	 */
	public Integer getTailleX()
	{
		return tailleX;
	}

	/**
	 * @param tailleX
	 *            the tailleX to set
	 */
	public void setTailleX(Integer tailleX)
	{
		this.tailleX = tailleX;
	}

	/**
	 * @return the tailleY
	 */
	public Integer getTailleY()
	{
		return tailleY;
	}

	/**
	 * @param tailleY
	 *            the tailleY to set
	 */
	public void setTailleY(Integer tailleY)
	{
		this.tailleY = tailleY;
	}

}
