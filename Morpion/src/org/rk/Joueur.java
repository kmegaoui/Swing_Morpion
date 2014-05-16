
package org.rk;

import java.util.ArrayList;
import java.util.List;

public class Joueur
{
	private String nom;
	private boolean autoriseAJouer;
	private List<String> resultats;

	public Joueur(String n)
	{
		nom = n;
		autoriseAJouer = false;
		resultats = new ArrayList<String>();
	}

	public void gagne()
	{
		resultats.add("Gagnant");
	}

	public void perd()
	{
		resultats.add("Perdant");
	}

	public void egalise()
	{
		resultats.add("Egalite");
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

	public List<String> getResultats()
	{
		return resultats;
	}

	public void setResultats(List<String> resultats)
	{
		this.resultats = resultats;
	}

}