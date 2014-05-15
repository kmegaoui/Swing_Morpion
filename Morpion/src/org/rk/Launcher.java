
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
<<<<<<< HEAD

=======
		mm = new MorpionModel();
		mv = new MorpionView(mm);
		mc = new MorpionControler(mm, mv);
		// mm.addObserver(mv);
		mv.addObserver(mc);
>>>>>>> 745c6942cd52371d7c76c648eeb26e74e7bbf59c
	}

}
