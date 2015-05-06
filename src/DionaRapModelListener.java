import javax.swing.JOptionPane;

import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;


public class DionaRapModelListener implements DionaRapListener
{
	private Board _board;
	
	public DionaRapModelListener(Board board) 
	{
		this._board = board;
	}

	@Override
	public void modelChanged(DionaRapChangedEvent arg0) 
	{
		this._board.updateBoard();
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
			JOptionPane.showMessageDialog(null, "Game Over. Spiel wird neugestartet.");	
			this._board.initaliseGame();
		}
	}
}
