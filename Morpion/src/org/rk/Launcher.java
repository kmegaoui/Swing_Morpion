
package org.rk;

public class Launcher
{
	static MorpionModel mm;
	static MorpionView mv;
	static MorpionControler mc;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		mm = new MorpionModel();
		mm.jouerCoup(1, 1, mm.getJoueur1());
		mm.jouerCoup(1, 2, mm.getJoueur1());
		mm.jouerCoup(1, 3, mm.getJoueur1());

		mm.jouerCoup(2, 1, mm.getJoueur2());
		mm.jouerCoup(2, 2, mm.getJoueur2());
		mm.jouerCoup(2, 3, mm.getJoueur2());

		mv = new MorpionView(mm);
		mc = new MorpionControler(mm, mv);
		mm.addObserver(mv);
		mv.addObserver(mc);
	}

}
