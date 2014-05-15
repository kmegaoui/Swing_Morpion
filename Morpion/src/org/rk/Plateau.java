/**
 * 
 */

package org.rk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author ronan
 * 
 */
public class Plateau extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1771331963597200288L;

	@Override
	public void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponents(g);
		((Graphics2D) g).drawLine(100, 0, 100, 300);
		((Graphics2D) g).drawLine(200, 0, 200, 300);
		((Graphics2D) g).drawLine(0, 100, 300, 100);
		((Graphics2D) g).drawLine(0, 200, 300, 200);

		// ((Graphics2D) g).setStroke(new BasicStroke(20));
		((Graphics2D) g).setColor(Color.BLUE);
		((Graphics2D) g).drawRect(0, 0, this.getWidth() - 1,
				this.getHeight() - 1);
	}

	@Override
	public void paint(Graphics arg0)
	{
		super.paint(arg0);
	}

	public void Cercle(int x, int y)
	{
		Graphics g = getGraphics();
		((Graphics2D) g).drawOval(10, 10, 80, 80);
	}

}
