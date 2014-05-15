
package org.rk;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MorpionModel extends Observable
{
	private int nbLigne;
	private int nbColonne;
	private List<Joueur> listeJoueur;
	private Case[][] grille;
	private int nbCoupPossible;

	public MorpionModel()
	{
		initStandard();
	}

	public void initStandard()
	{
		nbLigne = 3;
		nbColonne = 3;
		nbCoupPossible = nbLigne * nbColonne;

		listeJoueur = new ArrayList<Joueur>();
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

	public boolean jouerCoup(int ligne, int colonne, Joueur joueur)
	{
		if (joueur.estAutoriseAJouer())
		{
			if (coordValide(ligne, colonne))
			{
				if (grille[ligne - 1][colonne - 1].getJoueur() != null)
				{
					grille[ligne - 1][colonne - 1] = new Case(joueur);
					decrementeCoupPossible();
					joueur.setAutoriseAJouer(false);
					return true;
				}
			}
		}

		return false;
	}

	public boolean coordValide(int ligne, int colonne)
	{
		return ligne > 0 && ligne <= nbLigne && colonne > 0
				&& colonne <= nbColonne;
	}

	public boolean estCoupGagnant()
	{
		return false;
	}

	public boolean estDernierCoup()
	{
		return false;
	}

	public void decrementeCoupPossible()
	{
		nbCoupPossible--;
	}

}
