import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NavigationListener implements ActionListener {

	private int _movementX;
	private int _movementY;
	
	public NavigationListener(int movementX, int movementY)
	{
		this._movementX = movementX;
		this._movementY = movementY;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("X: " + this._movementX);
		System.out.println("Y: " + this._movementY);
	}

}
