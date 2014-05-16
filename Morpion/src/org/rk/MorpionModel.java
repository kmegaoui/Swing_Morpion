
package org.rk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
	private ServerSocket serveurHote;
	private Socket socket;
	private String s;

	public MorpionModel()
	{
		joueur1 = new Joueur("Joueur 1");
		joueur2 = new Joueur("Joueur 2");

		initJeuStandard();
		initGrille();
		start();
	}

	public void initJeuStandard()
	{
		nbLigne = 3;
		nbColonne = 3;
		nbCoupPossible = nbLigne * nbColonne;

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
	public synchronized void jouerCoup(Coup coup)
	{

		PrintWriter out;
		try
		{
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("J'ai joué");
			out.flush();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (coup.getJoueur().equals(joueurEnCours))
		{
			int ligne = coup.getLigne();
			int colonne = coup.getColonne();
			if (coordValide(ligne, colonne))
			{
				if (grille[ligne - 1][colonne - 1].getJoueur() == null)
				{
					grille[ligne - 1][colonne - 1].setJoueur(coup.getJoueur());
					decrementeCoupPossible();

					if (joueurEnCours.equals(joueur1))
					{
						joueurEnCours = joueur2;
					}
					else if (joueurEnCours.equals(joueur2))
					{
						joueurEnCours = joueur1;
					}

					if (estCoupGagnant(ligne, colonne, coup.getJoueur()))
					{
						System.out.println("Gagnant " + coup.getJoueur());
						initJeuStandard();
						initGrille();
						start();

						if (coup.getJoueur().equals(joueur1))
						{
							joueur1.gagne();
							joueur2.perd();
						}
						else
						{
							joueur2.gagne();
							joueur1.perd();
						}

					}

					else if (estDernierCoup())
					{
						initJeuStandard();
						initGrille();
						start();

						joueur1.egalise();
						joueur2.egalise();
					}

					setChanged();
					notifyObservers();
				}
			}
		}

	}

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
		for (int i = ligneMin; i < ligneMax + 1; i++)
		{
			cpt = 0;
			for (int j = colonneMin; j < colonneMax + 1; j++)
			{
				if (joueur.equals(grille[i - 1][j - 1].getJoueur()))
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
		for (int j = colonneMin; j < colonneMax + 1; j++)
		{
			cpt = 0;
			for (int i = ligneMin; i < ligneMax + 1; i++)
			{
				if (joueur.equals(grille[i - 1][j - 1].getJoueur()))
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

	public void creerServer()
	{
		Thread thread = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				BufferedReader in;
				try
				{
					serveurHote = new ServerSocket(3129);
					socket = serveurHote.accept();

					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					if (in.ready())
					{
						s = in.readLine();
						System.out.println(s);
					}
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		thread.start();
	}

	public void rejoindreServer()
	{
		Thread thread = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				BufferedReader in;
				try
				{
					socket = new Socket("10.0.158.160", 3129);
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					if (in.ready())
					{
						s = in.readLine();
						System.out.println(s);
					}
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.start();

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
