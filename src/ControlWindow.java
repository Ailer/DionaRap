
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

	/**
	 * ctor for ControlWindow
	 */
	ControlWindow()
	{		
		this._controalBoard = new Controlboard();
		this._controalBoard.setBorder(new LineBorder(Color.RED,5));
		this.setContentPane(this._controalBoard);
		
		this.setSize(400,400);
		this.setVisible(true);
	}
}
