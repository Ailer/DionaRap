package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import DionaRapSettings.Settings;
import Views.ConfigurationDialog;
import Views.MainWindow;

public class SaveConfigurationListener implements ActionListener 
{	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JButton source = (JButton)arg0.getSource();
		Settings settings = new Settings();
		
		if (source.getTopLevelAncestor() instanceof ConfigurationDialog)
		{
			ConfigurationDialog configDialog = (ConfigurationDialog)source.getTopLevelAncestor();
			
			settings.setAvoidObstacleCollisionEnabled(configDialog.isAvoidObstacleCollisionEnabled());
			settings.setAvoidOpponentCollisionEnabled(configDialog.isAvoidOpponentCollisionEnabled());
			settings.setGridSizeX(configDialog.getGrideSizeX());
			settings.setGridSizeY(configDialog.getGrideSizeY());
			settings.setObstaclesCount(configDialog.getObstaclesCount());
			settings.setOpponentsCount(configDialog.getOpponentsCount());
			settings.setOpponentStartWaitTime(configDialog.getOpponentStarWaitTime());
			settings.setOpponentWaitTime(configDialog.getOpponentWaitTime());
			settings.setRandomWaitTimeEnabled(configDialog.isRandomWaitTime());
			settings.setShootDelay(configDialog.getShootDelay());
			
			settings.saveSettigns();
			configDialog.setVisible(false);
		}
	}

}
