
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.controller.logic.ActiveOpponentLogic;
import de.fhwgt.dionarap.controller.logic.DionaRapGameLogic;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.objects.Obstacle;
import de.fhwgt.dionarap.model.objects.Opponent;
import de.fhwgt.dionarap.model.objects.Player;
import de.fhwgt.dionarap.model.objects.Vortex;

/**
 * @author nkunkel
 * Gameboard for DionaRap
 */
public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel[][] _board;
	//private DionaRapModel _dionaRapModel;
	//private Player _player;
	private ArrayList<PawnLabel> _pawnLabels;
	private PlayerLabel _playerLabel;
	//private DionaRapController _dionaRapController; 
	final private int fieldXSize = 50;
	final private int fieldYSize = 50;
	
	/**
	 * ctor for Board
	 */
	public Board()
	{		
		this._pawnLabels = new ArrayList<PawnLabel>();
		this.createBoard();
	}
	
	public void initaliseGame(Player player,
							  ArrayList<Opponent> opponents,
							  ArrayList<Obstacle> obstacles, 
							  ArrayList<Vortex> vortexes)
	{
		this.initialisePlayer(player);
		this.initialiseOpponents(opponents);
		this.initaliseObstacles(obstacles);
		this.initialiseVortexes(vortexes);
	}
	
	public void upadteBoard(Player player,
							ArrayList<Opponent> opponents,
							ArrayList<Obstacle> obstacles)
	{
		System.out.print("updateBoard");
		
		for(PawnLabel pawnLabel: this._pawnLabels)
		{
			Container parent = pawnLabel.getParent();
			parent.remove(pawnLabel);
		}


		this._pawnLabels.removeAll(this._pawnLabels);
		this.initialiseOpponents(opponents);
		this.initaliseObstacles(obstacles);
		Container parent = (JLabel)this._playerLabel.getParent();
		parent.remove(this._playerLabel);
		this.addComponentToBoard(this._playerLabel, player.getX(), player.getY());
		this.updateUI();
	}
	
	private void createBoard()
	{
		this._board = new JLabel[10][10];
		this.setLayout(new GridLayout(10,10));
		
		for(int y=0; y< 10; y++)
		{
			for(int x =0; x < 10; x++)
			{
				this._board[y][x] = new JLabel();		
				this._board[y][x].setVisible(true);
				this._board[y][x].setSize(fieldXSize,fieldYSize);
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
	}
		
	private void initialisePlayer(Player player)
	{
		this._playerLabel = new PlayerLabel();
		this.addComponentToBoard(this._playerLabel, player.getX(), player.getY());
	}
	
	private void initialiseOpponents(ArrayList<Opponent> opponents)
	{		
		for(Opponent opponent: opponents)
		{
			EnemyLabel eml = new EnemyLabel();
			this.addComponentToBoard(eml, opponent.getX(), opponent.getY());
			this._pawnLabels.add(eml);
		}
	}
	
	private void initaliseObstacles(ArrayList<Obstacle> obstacles)
	{		
		for (Obstacle obstacle: obstacles)
		{	
			ObstacleLable obl = new ObstacleLable();
			this.addComponentToBoard(obl, obstacle.getX(),obstacle.getY());
			this._pawnLabels.add(obl);
		}		
	}
	
	private void initialiseVortexes(ArrayList<Vortex> vortexes)
	{		
		for( Vortex vortex: vortexes)
		{
			JLabel vol = new JLabel();
			vol.setBackground(Color.RED);
			vol.setOpaque(true);
			vol.setSize(100,100);
			this.addComponentToBoard(vol,vortex.getX(), vortex.getY());
		}
	}
	
	private void addComponentToBoard(JLabel label, int posX, int posY)
	{
		JLabel field = this._board[posY][posX];
		field.add(label);
		
		if (label instanceof PawnLabel)
		{			
			((PawnLabel)label).InvertColor(field.getBackground());
		}
	}
	
	private void removeComponentFromBoard(JLabel label, int posX, int posY)
	{
		this._board[posX][posY].remove(label);
	}
	
	private void moveComponentOnBoard(JLabel label, int posX, int posY)
	{		
		/*this.removeComponentFromBoard(label, posX, posY);
		this.addComponentToBoard(label, posX, posY);*/
	}
}