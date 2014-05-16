/**
 * 
 */

package org.rk;

/**
 * @author ronan
 * 
 */
public class MessageAppli
{
	private ActionAppli actionAppli;
	private Object object;

	/**
	 * @return the actionAppli
	 */
	public ActionAppli getActionAppli()
	{
		return actionAppli;
	}

	/**
	 * @param actionAppli
	 *            the actionAppli to set
	 */
	public void setActionAppli(ActionAppli actionAppli)
	{
		this.actionAppli = actionAppli;
	}

	/**
	 * @return the object
	 */
	public Object getObject()
	{
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object)
	{
		this.object = object;
	}

	public MessageAppli(ActionAppli appli, Object obj)
	{
		actionAppli = appli;
		object = obj;
	}
}
