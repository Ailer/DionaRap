package Listener;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.fhwgt.dionarap.controller.DionaRapController;

import Views.*;

public class NavigationListener implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if( arg0.getSource() instanceof JButton)
		{
			JButton clickedButton = (JButton)arg0.getSource();
			Container ancestor = clickedButton.getTopLevelAncestor();

			if(ancestor instanceof ControlWindow)
			{
				DionaRapController controller = ((ControlWindow)ancestor).getMainWindow()
																		 .getDionaRapController();
				controller.movePlayer((Integer.parseInt(clickedButton.getActionCommand())));
			}
		}
	}

}
