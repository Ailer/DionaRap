package DionaRapSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;


public class Settings 
{
	 private Properties _properties;
	 private final String fileName = "DionaRapSettings.xml";
	 private final String opponentsCountKey = "OpponentsCount";
	 private final String randowWaitTimeKey = "IsRandomWaittime";
	 private final String avoidObstacleCollisionKey = "Avoidbstacle";
	 private final String avoidOpponentCollisionKey = "AvoidOpponent";
	 private final String opponentWaitTimeKey = "OpponentWaitTime";
	 private final String opponentStartWaitTimeKey = "OpponentStartWaitTime";
	 private final String shootDelayKey = "ShootDelay";
	 private final String grideSizeXKey = "GrideSizeX";
	 private final String grideSizeYKey = "GrideSizeY";
	 private final String obstaclesCountKey = "ObstaclesCount";
	 
	 public void setOpponentWaitTime(int waitTime)
	 {
		 this._properties.setProperty(opponentWaitTimeKey, Integer.toString(waitTime));
	 }
	 
	 public void setOpponentStartWaitTime(int waitTime)
	 {
		 this._properties.setProperty(opponentStartWaitTimeKey, Integer.toString(waitTime));
	 }
	  
	 public void setGridSizeX(int sizeX)
	 {
		 this._properties.setProperty(grideSizeXKey, Integer.toString(sizeX));
	 }
	 
	 public void setGridSizeY(int sizeY)
	 {
		 this._properties.setProperty(grideSizeYKey, Integer.toString(sizeY));
	 }
	 
	 public void setObstaclesCount(int obstacles)
	 {
		 this._properties.setProperty(obstaclesCountKey, Integer.toString(obstacles));
	 }
	 
	 public void setShootDelay(int delayTime)
	 {
		 this._properties.setProperty(shootDelayKey, Integer.toString(delayTime));
	 }
	 
	 public void setRandomWaitTimeEnabled(boolean enabled)
	 {
		 this._properties.setProperty(randowWaitTimeKey, Boolean.toString(enabled));
	 }
	 
	 public void setAvoidObstacleCollisionEnabled(boolean enabled)
	 {
		 this._properties.setProperty(avoidObstacleCollisionKey, Boolean.toString(enabled));
	 }
	 
	 public void setAvoidOpponentCollisionEnabled(boolean enabled)
	 {
		 this._properties.setProperty(this.avoidOpponentCollisionKey, Boolean.toString(enabled));
	 }
	 
	 public void setOpponentsCount(int opponentsCount)
	 {
		 this._properties.setProperty(opponentsCountKey, Integer.toString(opponentsCount));
	 }
	 
	 public int getOpponentsWaitTime()
	 {
		int tmp = -1;
		
		try
		{
			tmp = Integer.parseInt(this._properties.getProperty(opponentWaitTimeKey));
		} 
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		 
		return tmp; 
	 }
	 
	 public int getOpponentsStartWaitTime()
	 {
		int tmp = -1;
		
		try
		{
			tmp = Integer.parseInt(this._properties.getProperty(opponentStartWaitTimeKey));
		} 
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		 
		return tmp; 
	 }
	 
	 public int getOpponentsCount()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(opponentsCountKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public int getShootDelay()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(shootDelayKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public int getOpponentWaitTime()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(opponentWaitTimeKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public int getGrideSizeX()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(grideSizeXKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public int getGrideSizeY()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(grideSizeYKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public int getObstaclesCount()
	 {
		 int tmp = -1;
		 
		 try
		 {
			tmp = Integer.parseInt(this._properties.getProperty(obstaclesCountKey));
		 }
		 catch (NumberFormatException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return tmp;
	 }
	 
	 public boolean isRandomWaitTime()
	 {
		 Boolean tmp = false;
		 
		 try 
		 {
			tmp = Boolean.parseBoolean(this._properties.getProperty(randowWaitTimeKey));
		} 
		 catch (Exception e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return tmp;
	 }
	 
	 public boolean isAvoidObstacleCollisionEnabled()
	 {
		 Boolean tmp = false;
		 
 		try 
 	    {
			tmp = Boolean.parseBoolean(this._properties.getProperty(avoidObstacleCollisionKey));
		} 
		 catch (Exception e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return tmp; 
	 }
	 
	 public boolean isAvoidOpponentCollisionEnabled()
	 {
		 Boolean tmp = false;
		 
 		try 
 	    {
			tmp = Boolean.parseBoolean(this._properties.getProperty(avoidOpponentCollisionKey));
		} 
		 catch (Exception e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return tmp; 
	 }
	 
	 public Settings()
	 {	
		this._properties = new Properties(this.getDefaultSettings());
		
		if (new File(fileName).exists())
		{
			this.loadSettings();
		}
	 }
	 
	 public void saveSettigns()
	 {
		FileOutputStream fos;
		
		try 
		{
			fos = new FileOutputStream(fileName);
			this._properties.storeToXML(fos, "");
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 public void loadSettings()
	 {
		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			this._properties.loadFromXML(fis);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		
	 }

	 private Properties getDefaultSettings()
	 {
		 Properties defaultSettings = new Properties();
		 defaultSettings.setProperty(grideSizeXKey, "10");
		 defaultSettings.setProperty(grideSizeYKey, "10");
		 defaultSettings.setProperty(opponentsCountKey, "4");
		 defaultSettings.setProperty(obstaclesCountKey, "4");
		 defaultSettings.setProperty(avoidObstacleCollisionKey, "false");
		 defaultSettings.setProperty(avoidOpponentCollisionKey, "false");
		 defaultSettings.setProperty(randowWaitTimeKey, "false");
		 defaultSettings.setProperty(opponentStartWaitTimeKey, "5000");
		 defaultSettings.setProperty(opponentWaitTimeKey, "2000");
		 defaultSettings.setProperty(shootDelayKey, "1000");
		 
		 return defaultSettings;
	 }
}
