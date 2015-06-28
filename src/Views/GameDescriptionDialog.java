package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GameDescriptionDialog extends JDialog
{
	private final String helpUrl = "file:Spielbeschreibung/Spielbeschreibung.html";
	
	public GameDescriptionDialog()
	{		
		super();
		
		try
		{			
			this.setTitle("Spielbeschreibung");
			this.setResizable(true);	
			
			JEditorPane jep = new JEditorPane(helpUrl);
			jep.setPreferredSize(new Dimension(900,900));			
			
			JScrollPane scrollPane = new JScrollPane(jep);
			this.getContentPane().add(scrollPane);
			this.pack();
			this.setLocationRelativeTo(null);
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.print("Fehler beim laden der url");
			e.printStackTrace();
		}
		
	}
}
