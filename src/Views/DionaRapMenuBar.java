package Views;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

import Listener.LookAndFeelListener;
import Listener.PositionToolbarListener;

public class DionaRapMenuBar extends JMenuBar
{	
	private JMenu createHelpMenu(final MainWindow parent)
	{
		JMenu helpMenu = new JMenu("Hilfe");
		JMenuItem gameDescription = new JMenuItem("Spielbeschreibung");
		gameDescription.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new GameDescriptionDialog().setVisible(true);
			}
		});
		
		helpMenu.add(gameDescription);	
		return helpMenu;
	}
	
	private JMenu createViewMenu(final MainWindow parent)
	{
		JMenu viewMenu = new JMenu("Ansicht");
		
		// - ShowToolbar
		JMenuItem showToolbar = new JMenuItem("Toolbar anzeigen");
		showToolbar.addActionListener(new ActionListener() 
		{			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				parent.toogleToolBarVisible();
			}
		});
		
		// - PositionToolbar
		JMenu positionToolbar = new JMenu("Position Toolbar");
		ButtonGroup positionGroup = new ButtonGroup();

		// -- RadioButtons
		JRadioButtonMenuItem positionTop = new JRadioButtonMenuItem("Oben");
		JRadioButtonMenuItem positionBottom = new JRadioButtonMenuItem("Unten");
		
		// -- Listener
		PositionToolbarListener positionTbListener = new PositionToolbarListener(parent);
		positionTop.addActionListener(positionTbListener);	
		positionBottom.addActionListener(positionTbListener);
		
		// -- ButtonGroup
		positionGroup.add(positionTop);
		positionGroup.add(positionBottom);
		
		// -- Add 
		positionToolbar.add(positionTop);
		positionToolbar.add(positionBottom);
		
		// - LookAndFeel
		JMenu lookAndFeelMenu = new JMenu("Look and Feel");
		ButtonGroup lookAndFeelGroup = new ButtonGroup();
		
		UIManager.LookAndFeelInfo installedLookAndFeels [] = UIManager.getInstalledLookAndFeels();
		LookAndFeelListener lookAndFeelListener = new LookAndFeelListener(parent);
		
		for (int i = 0; i < installedLookAndFeels.length; i++)
		{
			JRadioButtonMenuItem rbItem = new JRadioButtonMenuItem(installedLookAndFeels[i].getName());
			lookAndFeelGroup.add(rbItem);
			lookAndFeelMenu.add(rbItem);
			rbItem.addActionListener(lookAndFeelListener);
			rbItem.setActionCommand(new String(installedLookAndFeels[i].getClassName()));
		}
		
		
		// - Navigator
		JMenuItem showNavigator = new JMenuItem("Navigator anzeigen");
		showNavigator.addActionListener(new ActionListener()
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				parent.toogleNavigatorVisible();
			}
		});
			
		// - Parent
		viewMenu.add(positionToolbar);
		viewMenu.add(showToolbar);
		viewMenu.add(showNavigator);

		viewMenu.add(lookAndFeelMenu);

		return viewMenu;
	}
	
	private JMenu createConfigurationMenu(final MainWindow parent)
	{
		JMenu configurationMenu = new JMenu("Konfigurierung");
		JMenuItem readLevel = new JMenuItem("Level einlesen");
		configurationMenu.add(readLevel);
		JMenuItem configLevel = new JMenuItem("Spielkonfigurieren");
		
		configLevel.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//TODO: check if game Started in model exists
				if (!parent.isGameStarted())
				{					
					new ConfigurationDialog(parent).setVisible(true);
					parent.loadSettings();
				}
				else 
				{
					JOptionPane.showMessageDialog(parent, "Spiel läuft bereits.");
				}
			}
		});
		
		configurationMenu.add(configLevel);
		return configurationMenu;
	}
	
	public DionaRapMenuBar(final MainWindow parent) 
	{
		this.add(this.createHelpMenu(parent));
		this.add(this.createViewMenu(parent));
		this.add(this.createConfigurationMenu(parent));
	}
}
