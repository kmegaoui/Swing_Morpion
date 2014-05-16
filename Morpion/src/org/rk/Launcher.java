
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
		mv = new MorpionView(mm);
		mc = new MorpionControler(mm, mv);
		mm.addObserver(mv);
		mv.addObserver(mc);

		mm.jouerCoup(0, 0, mm.getJoueur1());
		mm.jouerCoup(0, 1, mm.getJoueur1());
		mm.jouerCoup(0, 2, mm.getJoueur1());

		mm.jouerCoup(1, 0, mm.getJoueur2());
		mm.jouerCoup(1, 1, mm.getJoueur2());
		mm.jouerCoup(1, 2, mm.getJoueur2());

	}

}
