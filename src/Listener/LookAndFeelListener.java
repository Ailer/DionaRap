package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelListener implements ActionListener 
{
	private final JFrame mainWindow;
	
	public LookAndFeelListener(final JFrame window)
	{
		mainWindow = window;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String lookAndFeel=e.getActionCommand();   

		try 
		{ 
			UIManager.setLookAndFeel(lookAndFeel);                 
			SwingUtilities.updateComponentTreeUI(mainWindow); 
            
		}  
		catch ( Exception ex)
		{
			JOptionPane.showMessageDialog(mainWindow,"Fehler beim ändern des Look and Feel", "MessageBox",JOptionPane.ERROR_MESSAGE);
			System.out.println("Fehler beim ändern des LookAndFeel");
		}
	}

}
