
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
	}

}
