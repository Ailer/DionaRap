package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Listener.ThemeListener;

public class ThemePopupMenu extends JPopupMenu
{	
	public ThemePopupMenu(MainWindow mainWindow) 
	{
		super();
		
		ThemeListener themeListener = new ThemeListener(mainWindow);
		
	
		JRadioButtonMenuItem draculaTheme = new JRadioButtonMenuItem("Dracula");	
		draculaTheme.addActionListener(themeListener);
		draculaTheme.setActionCommand("Dracula");
		this.add(draculaTheme);
		
		JRadioButtonMenuItem spaceTheme = new JRadioButtonMenuItem("Space Wars");	
		spaceTheme.addActionListener(themeListener);
		spaceTheme.setActionCommand("SpaceWars");
		this.add(spaceTheme);
		
		JRadioButtonMenuItem squareHeadTheme = new JRadioButtonMenuItem("Square Head");	
		squareHeadTheme.addActionListener(themeListener);
		squareHeadTheme.setActionCommand("SquareHead");
		this.add(squareHeadTheme);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(draculaTheme);
		buttonGroup.add(spaceTheme);
		buttonGroup.add(squareHeadTheme);
		
		switch (mainWindow.getTheme())
		{
		case "Dracula": draculaTheme.setSelected(true);
			break;
		case "SpaceWars": spaceTheme.setSelected(true);
			break;
		case "SquareHead": squareHeadTheme.setSelected(true);
			break;
		default: draculaTheme.setSelected(true);
			break;
		}
	}
}
