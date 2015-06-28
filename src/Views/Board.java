package Views;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Ammo;
import de.fhwgt.dionarap.model.objects.Destruction;
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
	final private int fieldXSize = 70;
	final private int fieldYSize = 70;
	private int _xFields;
	private int _yFields;
	private ImageIcon _background;
	private String _selectedTheme;
	
	public Dimension getFieldSize()
	{
		return new Dimension(fieldXSize, fieldYSize);
	}
	
	public void setTheme(String theme)
	{
		this._selectedTheme = theme;
		
		if (theme == "SpaceWars" && this._xFields == 10 && this._yFields == 10)
		{
			String imagePath = String.format("Images%sSpaceWars%sbackground_stars.png",
					  File.separator,
					  File.separator);
			this._background = new ImageIcon(imagePath);	
			this.setBoardOpaque(false);
		}
		else 
		{
			this._background = null;
			this.setBoardOpaque(true);
		}
		
		this.repaint();
	}
	
	/**
	 * ctor for Board
	 */
	public Board(String theme, int xFields, int yFields)
	{		
		this._xFields = xFields;
		this._yFields = yFields;
		this.createBoard();
		this.setTheme(theme);
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
		for(int y =0; y < this._yFields; y++)
		{
			for(int x=0; x< this._xFields; x++)
			{

				this._board[y][x].setIcon(null);
			}
		}
	}
	
	private void setBoardOpaque(Boolean opaque)
	{	
		for (int y=0; y < this._yFields; y++)
		{
			for (int x=0; x < this._xFields; x++)
			{
		
				this._board[y][x].setOpaque(opaque);
			}
		}
	}
		
	private void createBoard()
	{
		this._board = new JLabel[this._yFields][this._xFields];
		this.setLayout(new GridLayout(this._yFields,this._xFields));
		
		for(int y =0; y < this._yFields; y++)
		{
			for(int x=0; x< this._xFields; x++)
			{
		
				this._board[y][x] = new JLabel();		
				this._board[y][x].setVisible(true);
				this._board[y][x].setPreferredSize(new Dimension(fieldXSize, fieldYSize));
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
	
	private void drawGameObjects(AbstractPawn pawns [])
	{		
		JLabel label;
		
		for (AbstractPawn pawn: pawns)
		{			
			label = this._board[pawn.getY()][pawn.getX()];
			
			if(pawn instanceof Opponent) 
			{
				label.setIcon(new ImageIcon(String.format("Images%s%s%sopponent.gif",File.separator, this._selectedTheme,File.separator)));
			}
			else if(pawn instanceof Obstacle) 
			{
				label.setIcon(new ImageIcon(String.format("Images%s%s%sobstacle.gif",File.separator, this._selectedTheme,File.separator)));
			}
			else if(pawn instanceof Vortex) 
			{
				label.setIcon(new ImageIcon(String.format("Images%s%s%svortex.gif",File.separator, this._selectedTheme,File.separator)));
			}
			else if(pawn instanceof Destruction)
			{
				label.setIcon(new ImageIcon(String.format("Images%s%s%sdestruction.gif", File.separator, this._selectedTheme,File.separator)));
			}			
			else if(pawn instanceof Player)
			{
				label.setIcon(new ImageIcon(String.format("Images%s%s%splayer%d.gif",
														  File.separator,
														  this._selectedTheme,
														  File.separator,
														  ((Player)pawn).getViewDirection())));
			}
			else if(pawn instanceof Ammo)
			{
				
				label.setIcon(new ImageIcon(String.format("Images%s%s%sammo.png",File.separator, this._selectedTheme, File.separator)));
			}
		}
	}
}