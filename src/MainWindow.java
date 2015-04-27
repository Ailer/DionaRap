import javax.swing.*;

/**
 * @author nkunkel
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
	MainWindow()
	{		
		this._board = new Board();	
		this.setContentPane(this._board);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Diona Rap");
		this.setSize(1000, 1000);		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this._controlWindow = new ControlWindow();	
		this._controlWindow.setLocation(this.getX() + this.getWidth() + 20, this.getY());
	}
}
