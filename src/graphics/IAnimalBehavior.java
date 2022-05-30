package graphics;

import javax.swing.*;
/***
 * This class defines the behavior of the animals
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public interface IAnimalBehavior {

	public String getAnimalName();
	public int getSize();
	public void eatInc();
	public int getEatCount();
	public boolean getChanges ();
	public void setChanges (boolean state);
	public void  setSuspended();
	public void setResumed();
}
