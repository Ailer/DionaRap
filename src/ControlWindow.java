
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author nkunkel
 * ControlWindow with Controlboard for DionaRap
 */
public class ControlWindow extends JWindow
{
	private static final long serialVersionUID = 1L;
	private Controlboard _controalBoard;
	private MainWindow _mainWindow;

	/**
	 * ctor for ControlWindow
	 */
	public ControlWindow(MainWindow mainWindow)
	{		
		super(mainWindow);
		this._mainWindow = mainWindow;
		this._controalBoard = new Controlboard();
		this._controalBoard.setBorder(new LineBorder(Color.RED,5));
		this.setContentPane(this._controalBoard);
		
		this.pack();
		this.setVisible(true);
	}
	
	public MainWindow getMainWindow()
	{
		return this._mainWindow;
	}
}
