package automationFramework.SeleniumBasics;
import org.apache.log4j.*;

public class SeleniumLog4j 
{
	private static Logger mainLogger = LogManager.getLogger(SeleniumLog4j.class.getName());
	
	public static void main(String args[])
	{
		mainLogger.info("This is a sample info message.");
		mainLogger.error("This is a sample error message");
		mainLogger.debug("This is a sample trace message");
		mainLogger.fatal("This is a sample fatal message");
	}
}
