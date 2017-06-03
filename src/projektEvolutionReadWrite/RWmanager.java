package projektEvolutionReadWrite;
import java.io.File;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RWmanager implements IWriteRead{

	public Boolean Save(Findings param) {
		
		PrintWriter writer = null;
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try
		{
			writer = new PrintWriter(GetCurrentProjectPath()+"resultJSON.txt");
			
			writer.println(gson.toJson(param));
			
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		finally
		{
			if(writer!=null)
				writer.close();
		}
	}

	public Findings Read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String GetCurrentProjectPath()
	{
		try{
		File currentDirFile = new File(".");
		String helper = currentDirFile.getAbsolutePath();
		String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
		
		return currentDir;
		}
		catch(Exception ex)
		{
			return "C:\\";
		}
	}
	

}
