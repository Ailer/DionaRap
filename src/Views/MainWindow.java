package Views;

import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.objects.Player;
import Listener.*;

/**
 * @author nkunkel	public void updateBoard()
	{
		this._playerLabel
	}
 * MainWindow with GameBoard for DionaRap
 */
public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	private ControlWindow _controlWindow;
	private Board _board;
	
	/**
	 * ctor for MainWindow
	 */
	public MainWindow()
	{		
		this._board = new Board();	
		this.setContentPane(this._board);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Diona Rap");	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();

		this._controlWindow = new ControlWindow(this);	
		this.addComponentListener(new MainWindowListener(this._controlWindow));
		this.addKeyListener(new ControlKeyListener(this));
		this._controlWindow.setLocation(this.getX() + this.getWidth() + 20, this.getY());
		this._board.initaliseGame();
		this.requestFocus();
	}
		
	public DionaRapController getDionaRapController()
	{
		return this._board.getDionaRapController();
	}
	
	public void updateGame()
	{
		this._board.updateBoard();
	}
}
