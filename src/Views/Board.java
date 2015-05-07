package Views;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.controller.logic.ActiveOpponentLogic;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.data.MTConfiguration;
import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Ammo;
import de.fhwgt.dionarap.model.objects.Destruction;
import de.fhwgt.dionarap.model.objects.Obstacle;
import de.fhwgt.dionarap.model.objects.Opponent;
import de.fhwgt.dionarap.model.objects.Player;
import de.fhwgt.dionarap.model.objects.Vortex;
import Listener.*;

/**
 * @author nkunkel
 * Gameboard for DionaRap
 */
public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel[][] _board;
	private DionaRapModel _dionaRapModel;
	private DionaRapGameLogic _gameLogic;
	private Player _player;
	private DionaRapController _dionaRapController; 
	final private int fieldXSize = 70;
	final private int fieldYSize = 70;
	
	/**
	 * ctor for Board
	 */
	public Board()
	{		
		this.createBoard();
	}
	
	public void initaliseGame()
	{
		this._dionaRapModel = new DionaRapModel(10,10,3,3);
		this._dionaRapController = new DionaRapController(this._dionaRapModel);
		this._gameLogic = new DionaRapGameLogic(this._dionaRapModel);
		this._dionaRapModel.addModelChangedEventListener(new DionaRapModelListener(this));

		this._dionaRapModel.setAmmoValue(3);
		this.updateBoard();
	}
	
	public void updateBoard()
	{
		System.out.print("updateBoard");
		this.clearBoard();
		this.drawGameObjects();
	}
	
	public DionaRapController getDionaRapController()
	{
		return this._dionaRapController;
	}
	
	private void clearBoard()
	{
		for(int y=0; y< 10; y++)
		{
			for(int x =0; x < 10; x++)
			{
				this._board[x][y].setText("");
			}
		}
	}
		
	private void createBoard()
	{
		this._board = new JLabel[10][10];
		this.setLayout(new GridLayout(10,10));
		
		for(int y=0; y< 10; y++)
		{
			for(int x =0; x < 10; x++)
			{
				this._board[x][y] = new JLabel();		
				this._board[x][y].setVisible(true);
				this._board[x][y].setPreferredSize(new Dimension(fieldXSize,fieldYSize));
				this._board[x][y].setOpaque(true);
				
				if((x + y) % 2 == 0)
				{
					this._board[x][y].setBackground(Color.BLACK);
				}
				else 
				{
					this._board[x][y].setBackground(Color.WHITE);
				}
				
				this.add(this._board[x][y]);
			}
		}
	}

	
	private void drawGameObjects()
	{		
		JLabel label;
		System.out.println(this._dionaRapModel.getAllPawns().length);
		System.out.println(this._dionaRapModel.getOpponentCount());
		
		for (AbstractPawn pawn: this._dionaRapModel.getAllPawns())
		{
			label = this._board[pawn.getX()][pawn.getY()];
			label.setForeground(this.getInvertColor(label.getBackground()));
			label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 35));
			
			if(pawn instanceof Opponent) 
			{
				label.setText("G");
			}
			else if(pawn instanceof Obstacle) 
			{
				label.setText("H");
			}
			else if(pawn instanceof Vortex) 
			{
				label.setBackground(Color.RED);
			}
			else if(pawn instanceof Destruction)
			{
				label.setText("*");
			}			
			else if(pawn instanceof Player)
			{
				label.setText("P");
			}
			else if(pawn instanceof Ammo)
			{
				label.setText("A");
			}
		}
	}
	
	private Color getInvertColor(Color backgroundColor)
	{
		Color foreground = new Color(255 - backgroundColor.getRed(),
									 255 - backgroundColor.getBlue(),
									 255 - backgroundColor.getGreen());	
		return foreground;
	}
}