import java.awt.*;

import javax.swing.*;


/**
 * @author nkunkel
 * Gameboard for DionaRap
 */
public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel[][] _board;
	
	/**
	 * ctor for Board
	 */
	Board()
	{		
		this._board = new JLabel[10][10];
		this.setLayout(new GridLayout(10,10));
		
		for(int i=0; i< 10; i++)
		{
			for(int n =0; n < 10; n++)
			{
				this._board[i][n] = new JLabel();		
				this._board[i][n].setVisible(true);
				this._board[i][n].setSize(50,50);
				this._board[i][n].setOpaque(true);
				
				if((n + i) % 2 == 0)
				{
					this._board[i][n].setBackground(Color.BLACK);
				}
				else 
				{
					this._board[i][n].setBackground(Color.WHITE);
				}
				
				this.add(this._board[i][n]);
			}
		}
	}
}
