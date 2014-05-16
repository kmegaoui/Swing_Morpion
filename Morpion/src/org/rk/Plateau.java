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

	private Integer nbCaseX, nbCaseY, tailleX, tailleY, CoordCaseX, CoordCaseY;
	private Integer tailleCaseX, tailleCaseY;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1771331963597200288L;

	public Plateau(int tailleX, int tailleY, int nbCaseX, int nbCaseY)
	{
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.nbCaseX = nbCaseX;
		this.nbCaseY = nbCaseY;
		this.tailleCaseX = Math.round((float) tailleX / nbCaseX);
		this.tailleCaseY = Math.round((float) tailleY / nbCaseY);

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
		// ((Graphics2D) g).drawLine(100, 0, 100, 300);
		// ((Graphics2D) g).drawLine(200, 0, 200, 300);
		// ((Graphics2D) g).drawLine(0, 100, 300, 100);
		// ((Graphics2D) g).drawLine(0, 200, 300, 200);

		// ((Graphics2D) g).setStroke(new BasicStroke(20));
		((Graphics2D) g).setColor(Color.BLUE);
		((Graphics2D) g).drawRect(0, 0, this.getWidth() - 1,
				this.getHeight() - 1);
	}

	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
	}

	public void cercle(int x, int y)
	{
		// Récupération du graphique
		Graphics g = getGraphics();

		// Calcul des coordonnées dans la grille
		CoordCaseX = x / tailleCaseX;
		CoordCaseY = y / tailleCaseY;
		int baseX = 10 + (CoordCaseX * tailleCaseX);
		int baseY = 10 + (CoordCaseY * tailleCaseY);
		System.out.println(tailleCaseX + " " + tailleCaseY);
		System.out.println(CoordCaseX + " " + CoordCaseY);
		System.out.println(baseX + " " + baseY);
		((Graphics2D) g).drawOval(baseX, baseY, tailleCaseX - 20,
				tailleCaseY - 20);
	}

	public void croix(int x, int y)
	{
		// Récupération du graphique
		Graphics g = getGraphics();

		// Calcul des coordonnées dans la grille
		// CoordCaseX = x / tailleCaseX;
		// CoordCaseY = y / tailleCaseY;
		CoordCaseX = x;
		CoordCaseY = y;
		int baseX = 10 + (CoordCaseX * tailleCaseX);
		int baseY = 10 + (CoordCaseY * tailleCaseY);
		int finX = (tailleCaseX - 10) + (CoordCaseX * tailleCaseX);
		int finY = (tailleCaseY - 10) + (CoordCaseY * tailleCaseY);
		((Graphics2D) g).drawLine(baseX, baseY, finX, finY);
		((Graphics2D) g).drawLine(baseX, finY, finX, baseY);
	}

}
