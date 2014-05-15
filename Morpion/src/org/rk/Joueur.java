
package org.rk;

public class Joueur
{
	private String nom;
	private boolean estAutoriseAJouer;

	public Joueur(String n)
	{
		this.nom = n;
		this.estAutoriseAJouer = false;
	}

	public String toString()
	{
		return nom;
	}
}