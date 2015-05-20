package Views;

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
		//this._controalBoard.setBorder(new LineBorder(Color.RED,5));
		this.setContentPane(this._controalBoard);
		this.setShape(this.createWindowBorder());
		this.pack();
		this.setVisible(true);
	}
	
	public MainWindow getMainWindow()
	{
		return this._mainWindow;
	}
	
	private Shape createWindowBorder()
	{
		Polygon plg = new Polygon();		
		plg.addPoint(50,0);
		plg.addPoint(100,0);
		plg.addPoint(150,50);
		plg.addPoint(150,100);
		plg.addPoint(100,150);
		plg.addPoint(50,150);
		plg.addPoint(0,100);
		plg.addPoint(0,50);
		
		return plg;
	}
}
