package Listener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;


/**
 * @author nkunkel
 *
 */
public class MainWindowListener implements ComponentListener {

	private JWindow _controlWindow;
	
	public MainWindowListener(JWindow controlWindow) 
	{
		this._controlWindow = controlWindow;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentHidden(ComponentEvent arg0) {	}

	/* (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentMoved(ComponentEvent arg0)
	{
		this.setControlWindowLocation(arg0);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentResized(ComponentEvent arg0) 
	{
		this.setControlWindowLocation(arg0);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentShown(ComponentEvent arg0) 
	{
		this.setControlWindowLocation(arg0);
	}
	
	private void setControlWindowLocation(ComponentEvent arg0)
	{
		this._controlWindow.setLocation(arg0.getComponent().getX() + arg0.getComponent().getWidth() + 20, arg0.getComponent().getY());
	}

}
