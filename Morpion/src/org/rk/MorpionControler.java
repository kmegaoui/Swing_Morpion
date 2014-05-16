
package org.rk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ronan
 * 
 */
public class MorpionControler implements Observer
{

	MorpionModel mm;

	public MorpionControler(MorpionModel mm, MorpionView mv)
	{
		this.mm = mm;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		MessageAppli ma = (MessageAppli) arg1;
		switch (ma.getActionAppli())
		{
		case JOUER:
			Coup coup = (Coup) ma.getObject();
			mm.jouerCoup(coup.getLigne(), coup.getColonne(), coup.getJoueur());
			break;

		default:
			break;
		}
	}

}
