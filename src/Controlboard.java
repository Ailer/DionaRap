
import java.awt.*;

import javax.swing.*;

/**
 * @author nkunkel
 * Creates Controlboard for DionaRap
 */
public class Controlboard extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton _controlButtons[];
	
	/**
	 * ctor for ControlBoard
	 */
	Controlboard()
	{
		this.setLayout(new GridLayout(3, 3, 2, 2));
		this._controlButtons = new JButton[9];
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		int movementX = 1;
		int movementY = 1;
		
		for(int i = 8; i >= 0; i--)
		{
			this._controlButtons[i] = new JButton(Integer.toString(i +1));
			this.add(this._controlButtons[i]);			
			
			if(i + 1 != 5)
			{
				this._controlButtons[i].addActionListener(new NavigationListener(movementX,movementY));
			}
			else
			{
				this._controlButtons[i].addActionListener(new ShootingListener());
			}
			
			if(movementX == -1)
			{
				movementX = 1;
			}
			else 
			{
				--movementX;
			}
					
			if(i % 3 == 0)
			{
				--movementY;
			}
		}
				
		/*this.add(this._controlButtons[6],0);
		this.add(this._controlButtons[7],1);
		this.add(this._controlButtons[8],2);
		this.add(this._controlButtons[3],3);
		this.add(this._controlButtons[4],4);
		this.add(this._controlButtons[5],5);
		this.add(this._controlButtons[0],6);
		this.add(this._controlButtons[1],7);
		this.add(this._controlButtons[2],8);*/
	}
}
