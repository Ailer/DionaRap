
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
		
		for(int i = 8; i >= 0; i--)
		{
			this._controlButtons[i] = new JButton(Integer.toString(i +1));
			this._controlButtons[i].setPreferredSize(new Dimension(50,50));
			this.add(this._controlButtons[i]);			
			
			if(i + 1 != 5)
			{
				this._controlButtons[i].addActionListener(new NavigationListener(i +1));
			}
			else
			{
				this._controlButtons[i].addActionListener(new ShootingListener());
			}
		}
	}
}
