
import javax.swing.*;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.objects.Player;

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
	private DionaRapController _dionaRapController; 
	private DionaRapModel _dionaRapModel;
	private Player _player;

	/**
	 * ctor for MainWindow
	 */
	public MainWindow()
	{		
		this._board = new Board();	
		this.setContentPane(this._board);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Diona Rap");
		this.setSize(1000, 1000);		
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this._controlWindow = new ControlWindow(this);	
		this.addComponentListener(new MainWindowListener(this._controlWindow));
		this.addKeyListener(new ControlKeyListener(this));
		this._controlWindow.setLocation(this.getX() + this.getWidth() + 20, this.getY());
		this.initsialiseGame();
	}
	
	public void initsialiseGame()
	{
		this._dionaRapModel = new DionaRapModel(10,10,3,3);
		this._dionaRapModel.setGrid(new Grid(10, 10));
		this._dionaRapModel.addModelChangedEventListener(new DionaRapModelListener(this));
		this._dionaRapController = new DionaRapController(this._dionaRapModel);
		this._player = new Player();
		this._dionaRapModel.setPlayer(this._player);
		this._player.setX(5);
		this._player.setY(5);
		this._board.initaliseGame(this._player, 
								  this._dionaRapModel.getOpponents(),
								  this._dionaRapModel.getObstacles(),
								  this._dionaRapModel.getVortexes());
	}
	
	public DionaRapController getDionaRapController()
	{
		return this._dionaRapController;
	}
	
	public void updateGame()
	{
		this._board.upadteBoard(this._player, 
				  				this._dionaRapModel.getOpponents(),
				  				this._dionaRapModel.getObstacles());
	}
}
