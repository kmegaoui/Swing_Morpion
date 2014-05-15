
package org.rk;

public class Joueur
{
	private String nom;
	private boolean autoriseAJouer;

	public Joueur(String n)
	{
		this.nom = n;
		this.autoriseAJouer = false;
	}

	public String toString()
	{
		return nom;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public boolean estAutoriseAJouer()
	{
		return autoriseAJouer;
	}

	public void setAutoriseAJouer(boolean autoriseAJouer)
	{
		this.autoriseAJouer = autoriseAJouer;
	}

}