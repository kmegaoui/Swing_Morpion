
package org.rk;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MorpionModel extends Observable
{
	private long nbLigne;
	private long nbColonne;
	List<Joueur> listeJoueur;
	Case[][] grille;

	public MorpionModel()
	{
		initStandard();
	}

	public void initStandard()
	{
		this.nbLigne = 3;
		this.nbColonne = 3;
		this.listeJoueur = new ArrayList<Joueur>();
		listeJoueur.add(new Joueur("Joueur 1"));
		listeJoueur.add(new Joueur("Joueur 2"));
	}

}
