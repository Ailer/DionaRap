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
		
		for(int i = 8; i >= 0; i--)
		{
			this._controlButtons[i] = new JButton(Integer.toString(i +1));
		}
				
		this.add(this._controlButtons[6],0);
		this.add(this._controlButtons[7],1);
		this.add(this._controlButtons[8],2);
		this.add(this._controlButtons[3],3);
		this.add(this._controlButtons[4],4);
		this.add(this._controlButtons[5],5);
		this.add(this._controlButtons[0],6);
		this.add(this._controlButtons[1],7);
		this.add(this._controlButtons[2],8);
	}
}
