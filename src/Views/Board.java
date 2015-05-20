package Views;

import java.awt.*;
import java.io.File;
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
	private Player _player;
	final private int fieldXSize = 70;
	final private int fieldYSize = 70;
	private ImageIcon _background;
	
	/**
	 * ctor for Board
	 */
	public Board()
	{		
		String imagePath = String.format("Images%sGameObjects%sbackground_stars.png",
				  File.separator,
				  File.separator);
		this._background = new ImageIcon(imagePath);	
		this.createBoard();
	}
	
	public void updateBoard(AbstractPawn pawns[])
	{
		this.clearBoard();
		this.drawGameObjects(pawns);
	}
	
	public void updateBackgroundImage()
	{
		this.repaint();
	}
	
	public void repaint()
	{
	
		if (this._background != null)
		{
			this._background.setImage(this._background.getImage().getScaledInstance(this.getWidth(),
																				this.getHeight(), 
																				Image.SCALE_DEFAULT));
		}
		
		super.repaint();
	}
	
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        if (this._background != null) 
        {        	
            g.drawImage(this._background.getImage(), 0, 0, this);
        }
    }
	
	private void clearBoard()
	{
		for(int y=0; y< 10; y++)
		{
			for(int x =0; x < 10; x++)
			{
				this._board[x][y].setIcon(null);
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
				//this._board[x][y].setOpaque(true);
				
				/*if((x + y) % 2 == 0)
				{
					this._board[x][y].setBackground(Color.BLACK);
				}
				else 
				{
					this._board[x][y].setBackground(Color.WHITE);
				}*/
				
				this.add(this._board[x][y]);
			}
		}
	}
	
	private void drawGameObjects(AbstractPawn pawns [])
	{		
		JLabel label;
		
		for (AbstractPawn pawn: pawns)
		{
			label = this._board[pawn.getX()][pawn.getY()];
			
			if(pawn instanceof Opponent) 
			{
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%sopponent.gif",File.separator,File.separator)));
			}
			else if(pawn instanceof Obstacle) 
			{
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%sobstacle.gif",File.separator,File.separator)));
			}
			else if(pawn instanceof Vortex) 
			{
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%svortex.gif",File.separator,File.separator)));
			}
			else if(pawn instanceof Destruction)
			{
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%sdestruction.gif", File.separator,File.separator)));
			}			
			else if(pawn instanceof Player)
			{
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%splayer%d.gif",
														  File.separator,
														  File.separator,
														  ((Player)pawn).getViewDirection())));
			}
			else if(pawn instanceof Ammo)
			{
				
				label.setIcon(new ImageIcon(String.format("Images%sGameObjects%sammo.png",File.separator, File.separator)));
			}
		}
	}
}