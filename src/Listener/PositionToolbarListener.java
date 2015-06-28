package Listener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.*;

import javax.swing.JRadioButtonMenuItem;

public class PositionToolbarListener implements ActionListener
{
	private final MainWindow mainWindow;
	
	public PositionToolbarListener(final MainWindow parent)
	{
		this.mainWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		JRadioButtonMenuItem rbItem = (JRadioButtonMenuItem)arg0.getSource();
		
		if (rbItem.getText() == "Oben")
		{
			this.mainWindow.setToolbarPosition(BorderLayout.PAGE_START);
		}
		else 
		{
			this.mainWindow.setToolbarPosition(BorderLayout.PAGE_END);
		}
	}

}
