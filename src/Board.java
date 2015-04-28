
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import de.fhwgt.dionarap.controller.logic.ActiveOpponentLogic;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.objects.Opponent;
import de.fhwgt.dionarap.model.objects.Player;


/**
 * @author nkunkel
 * Gameboard for DionaRap
 */
public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel[][] _board;
	private DionaRapModel _dionaRapModel;
	private Player _player;
	private ArrayList<Opponent> _opponents;
	private ArrayList<ActiveOpponentLogic> _activeOpponents;
	
	/**
	 * ctor for Board
	 */
	Board()
	{		
		this._board = new JLabel[10][10];
		this.setLayout(new GridLayout(10,10));
		
		for(int y=0; y< 10; y++)
		{
			for(int x =0; x < 10; x++)
			{
				this._board[y][x] = new JLabel();		
				this._board[y][x].setVisible(true);
				this._board[y][x].setSize(50,50);
				this._board[y][x].setOpaque(true);
				
				if((x + y) % 2 == 0)
				{
					this._board[y][x].setBackground(Color.BLACK);
				}
				else 
				{
					this._board[y][x].setBackground(Color.WHITE);
				}
				
				this.add(this._board[y][x]);
			}
		}
				
		DionaRapModel test = new DionaRapModel();
		test.setGrid(new Grid(10, 10));
		this._player = new Player();
		test.setPlayer(this._player);
		this._player.setX(5);
		this._player.setY(5);
		
		
		//this._dionaRapModel = new DionaRapModel(10, 10);
		/*this._opponents = new ArrayList<Opponent>();
		this._activeOpponents = new ArrayList<ActiveOpponentLogic>();
		this._opponents.add(new Opponent());
		this._dionaRapModel.setOpponents(this._opponents);
		this._activeOpponents.add(new ActiveOpponentLogic(new DionaRapGameLogic(this._dionaRapModel), this._opponents.get(0)));
		this._dionaRapModel.setActiveOpponents(this._activeOpponents);
		this._dionaRapModel.addOpponent(new Opponent());*/

		//this._dionaRapModel.setPlayer(this._player);	
	}
}
