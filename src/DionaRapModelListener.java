import javax.swing.JOptionPane;

import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;


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
		if(arg0.isGameWon())
		{
			JOptionPane.showMessageDialog(null, "Spiel gewonnen");
		}
		else if (arg0.isGameOver())
		{
			JOptionPane.showMessageDialog(null, "Game Over");
		}
		
		this._mainWindow.initsialiseGame();
	}
}
