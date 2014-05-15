
package org.rk;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MorpionModel extends Observable
{
	private int nbLigne;
	private int nbColonne;
	List<Joueur> listeJoueur;
	Case[][] grille;

	public MorpionModel()
	{
		initStandard();
		initGrille();
	}

	public void initStandard()
	{
		this.nbLigne = 3;
		this.nbColonne = 3;
		this.listeJoueur = new ArrayList<Joueur>();
		listeJoueur.add(new Joueur("Joueur 1"));
		listeJoueur.add(new Joueur("Joueur 2"));
	}

	public void initGrille()
	{
		grille = new Case[nbLigne][nbColonne];

		for (int ligne = 0; ligne < nbLigne; ligne++)
		{
			for (int colonne = 0; colonne < nbLigne; colonne++)
			{
				grille[ligne][colonne] = new Case();
			}
		}
	}

	public boolean jouerCoup(int ligne, int colonne)
	{
		if (coordValide(ligne, colonne))
		{
			return grille[ligne - 1][colonne - 1] != null;
		}
		else
		{
			return false;
		}

	}

	public boolean coordValide(int ligne, int colonne)
	{
		return ligne > 0 && ligne <= nbLigne && colonne > 0
				&& colonne <= nbColonne;
	}
}
