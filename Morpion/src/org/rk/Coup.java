/**
 * 
 */

package org.rk;

/**
 * @author ronan
 * 
 */
public class Coup
{
	private int ligne, colonne;
	private Joueur joueur;

	/**
	 * @return the ligne
	 */
	public int getLigne()
	{
		return ligne;
	}

	/**
	 * @param ligne
	 *            the ligne to set
	 */
	public void setLigne(int ligne)
	{
		this.ligne = ligne;
	}

	/**
	 * @return the colonne
	 */
	public int getColonne()
	{
		return colonne;
	}

	/**
	 * @param colonne
	 *            the colonne to set
	 */
	public void setColonne(int colonne)
	{
		this.colonne = colonne;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur()
	{
		return joueur;
	}

	/**
	 * @param joueur
	 *            the joueur to set
	 */
	public void setJoueur(Joueur joueur)
	{
		this.joueur = joueur;
	}

	public Coup(int l, int c, Joueur j)
	{
		joueur = j;
		ligne = l;
		colonne = c;
	}
}
