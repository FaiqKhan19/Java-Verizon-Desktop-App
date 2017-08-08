package application;
import java.lang.Throwable;
public class IllegalInput extends Exception {
	
	public IllegalInput()
	{
		super("An error has occuured.");
	}
	
	public IllegalInput(String str)
	{
		super(str);
	}

}
