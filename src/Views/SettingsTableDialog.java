package Views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;

import DionaRapSettings.Settings;

public class SettingsTableDialog extends JDialog 
{
	private JTable _settingsTable;
	private Settings _settings;
	
	
	public SettingsTableDialog() 
	{
		this._settings = new Settings();
		this._settings.loadSettings();
		this.setTitle("Einstellungsübersicht");
		
		Object data [][] =
		{
				{ "Anzahl Gegner", this._settings.getOpponentsCount()},
				{ "Blub", true }
		};
		
		String columnNames[] = {"Anzahl Gegner", "Zeile2"};
		this._settingsTable = new JTable(data, columnNames);
		this._settingsTable.setEnabled(false);
		this.add(this._settingsTable, BorderLayout.CENTER);
		
		JButton closeButton = new JButton("Schliessen");
		closeButton.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JDialog jdialog = (JDialog) ((JButton)e.getSource()).getTopLevelAncestor();
				jdialog.setVisible(false);
				jdialog.dispose();
			}
		});
		this.add(closeButton, BorderLayout.PAGE_END);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
