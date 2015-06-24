package Listener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;
import Views.*;


public class DionaRapModelListener implements DionaRapListener
{
	private MainWindow _mainWindow;
	
	public DionaRapModelListener(MainWindow mainWindow) 
	{
		this._mainWindow = mainWindow;
	}

	@Override
	public void modelChanged(DionaRapChangedEvent arg0) 
	{
		this._mainWindow.updateGame();
	}

	@Override
	public void statusChanged(GameStatusEvent arg0)
	{
		Object options[] = {"Spiel neustarten", "Abbrechen"};
		int result = -1;
		
		if(arg0.isGameWon())
		{
			result = JOptionPane.showOptionDialog(this._mainWindow,
					"Spiel gewonnen", 
					"Gewonnen", 
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					new ImageIcon(String.format("Images%s%s%swin.gif", File.separator, this._mainWindow.getTheme(), File.separator)),
					options, 
					0);
		}
		else if (arg0.isGameOver())
		{
			result = JOptionPane.showOptionDialog(this._mainWindow,
										"Spiel verloren", 
										"Game Over", 
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.QUESTION_MESSAGE, 
										new ImageIcon(String.format("Images%s%s%sloss.gif", File.separator, this._mainWindow.getTheme(), File.separator)),
										options, 
										0);
		}
		
		if (result == 0)
		{
			this._mainWindow.initaliseGame();
		}
		else 
		{
			this._mainWindow.setTbRestartButtonEnabled(true);
		}
	}
}
