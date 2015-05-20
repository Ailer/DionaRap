package Views;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import Listener.*;

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
		this.setLayout(new GridLayout(3, 3, 0, 0));
		this._controlButtons = new JButton[9];
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		NavigationListener navigationListener = new NavigationListener();
		
		for(int i = 8; i >= 0; i--)
		{
			this._controlButtons[i] = new JButton(new ImageIcon(String.format("Images%sNavigation%staste%d.gif",
																			  File.separator,
																			  File.separator,
																			  i+1)));
			this._controlButtons[i].setPreferredSize(new Dimension(50,50));
			this._controlButtons[i].setMargin(new Insets(0,0, 0, 0));
			this.add(this._controlButtons[i]);			
			
			if(i + 1 != 5)
			{
				this._controlButtons[i].addActionListener(navigationListener);
				this._controlButtons[i].setActionCommand(Integer.toString(i+1));
			}
			else
			{
				this._controlButtons[i].addActionListener(new ShootingListener());
			}
		}
	}
}
