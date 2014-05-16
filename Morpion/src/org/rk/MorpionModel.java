
package org.rk;

import java.util.Observable;

public class MorpionModel extends Observable
{
	private int nbLigne;
	private int nbColonne;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurEnCours;
	private Case[][] grille;
	private int nbCoupPossible;

	public MorpionModel()
	{
		initJeuStandard();
		initGrille();
	}

	public void initJeuStandard()
	{
		nbLigne = 3;
		nbColonne = 3;
		nbCoupPossible = nbLigne * nbColonne;

		joueur1 = new Joueur("Joueur 1");
		joueur2 = new Joueur("Joueur 2");
	}

	public void start()
	{
		joueurEnCours = joueur1;
	}

	// Preparation grille de jeu
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

	// Action de jeu d'un joueur
	public void jouerCoup(int ligne, int colonne, Joueur joueur)
	{
		// if (joueur.estAutoriseAJouer())
		// {
		if (coordValide(ligne, colonne))
		{
			if (grille[ligne - 1][colonne - 1].getJoueur() == null)
			{
				grille[ligne - 1][colonne - 1].setJoueur(joueur);
				decrementeCoupPossible();
				joueur.setAutoriseAJouer(false);

				// setChanged();
				// notifyObservers();
			}
		}
	}

	// }

	public boolean coordValide(int ligne, int colonne)
	{
		return ligne > 0 && ligne <= nbLigne && colonne > 0
				&& colonne <= nbColonne;
	}

	public boolean estDernierCoup()
	{
		return nbCoupPossible <= 0;
	}

	public void decrementeCoupPossible()
	{
		nbCoupPossible--;
	}

	public boolean estCoupGagnant(int ligne, int colonne, Joueur joueur)
	{
		int ligneMin = ligne - 2;
		if (ligneMin < 1)
			ligneMin = 1;

		int ligneMax = ligne + 2;
		if (ligneMax > nbLigne)
			ligneMax = nbLigne;

		int colonneMin = ligne - 2;
		if (colonneMin < 1)
			colonneMin = 1;

		int colonneMax = ligne + 2;
		if (colonneMax > nbColonne)
			colonneMax = nbColonne;

		int cpt;

		// Verification des lignes potentiellement gagnantes
		for (int i = ligneMin; i < ligneMax; i++)
		{
			cpt = 0;
			for (int j = colonneMin; j < colonneMax; j++)
			{
				if (joueur.equals(grille[ligne - 1][colonne - 1].getJoueur()))
				{
					cpt++;
				}
				else
				{
					cpt = 0;
				}
			}
			if (cpt == 3)
			{
				return true;
			}
		}

		// Verification des colonnes potentiellement gagnantes
		for (int i = colonneMin; i < colonneMax; i++)
		{
			cpt = 0;
			for (int j = ligneMin; j < ligneMax; j++)
			{
				if (joueur.equals(grille[ligne - 1][colonne - 1].getJoueur()))
				{
					cpt++;
				}
				else
				{
					cpt = 0;
				}
			}
			if (cpt == 3)
			{
				return true;
			}
		}

		// Verification premiere diagonale
		int indexLigne = ligneMin;
		int indexColonne = colonneMin;
		cpt = 0;

		while (indexLigne <= ligneMax && indexColonne <= colonneMax)
		{
			if (joueur.equals(grille[indexLigne - 1][indexColonne - 1]
					.getJoueur()))
			{
				cpt++;
			}
			else
			{
				cpt = 0;
			}

			indexLigne++;
			indexColonne++;

			if (cpt == 3)
			{
				return true;
			}
		}

		// Verification seconde diagonale
		indexLigne = ligneMax;
		indexColonne = colonneMin;
		cpt = 0;

		while (indexLigne >= ligneMin && indexColonne <= colonneMax)
		{

			if (joueur.equals(grille[indexLigne - 1][indexColonne - 1]
					.getJoueur()))
			{
				cpt++;
			}
			else
			{
				cpt = 0;
			}

			indexLigne--;
			indexColonne++;

			if (cpt == 3)
			{
				return true;
			}
		}

		return false;
	}

	// getters et setters

	public int getNbLigne()
	{
		return nbLigne;
	}

	public void setNbLigne(int nbLigne)
	{
		this.nbLigne = nbLigne;
	}

	public int getNbColonne()
	{
		return nbColonne;
	}

	public void setNbColonne(int nbColonne)
	{
		this.nbColonne = nbColonne;
	}

	public Case[][] getGrille()
	{
		return grille;
	}

	public void setGrille(Case[][] grille)
	{
		this.grille = grille;
	}

	public int getNbCoupPossible()
	{
		return nbCoupPossible;
	}

	public void setNbCoupPossible(int nbCoupPossible)
	{
		this.nbCoupPossible = nbCoupPossible;
	}

	public Joueur getJoueur1()
	{
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1)
	{
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2()
	{
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2)
	{
		this.joueur2 = joueur2;
	}

	public Joueur getJoueurEnCours()
	{
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours)
	{
		this.joueurEnCours = joueurEnCours;
	}

}
