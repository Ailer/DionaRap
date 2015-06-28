package Listener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Popup;

import Views.MainWindow;

public class ThemeListener implements ActionListener 
{	
	MainWindow _mainWindow;
	
	public ThemeListener(MainWindow mainWindow) 
	{
		this._mainWindow = mainWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this._mainWindow.setTheme(arg0.getActionCommand());
		
		JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem)arg0.getSource();
		Container popup = menuItem.getTopLevelAncestor();
		popup.setVisible(false);
	}
}
