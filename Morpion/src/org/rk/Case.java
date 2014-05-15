
package org.rk;

public class Case
{
	private Joueur joueur;

	public Case()
	{

	}

	public Case(Joueur j)
	{
		joueur = j;
	}

	public Joueur getJoueur()
	{
		return joueur;
	}

	public void setJoueur(Joueur joueur)
	{
		this.joueur = joueur;
	}
}
