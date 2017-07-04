package projektEvolutionReadWrite;
import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RWmanager implements IWriteRead {

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
		/*File reader = new File("resultJSON.txt");
		Scanner in = new Scanner(reader);
		
		String text = in.nextLine();
		System.out.println(text);
		*/
		//DataOutputStream stream = null;
		Gson gson = new Gson();
		try
		{
			Reader reader = new FileReader("resultJSON.txt");
			//stream = new DataOutputStream(new FileOutputStream("resultJSON.txt"));
			Findings findings = gson.fromJson(reader, Findings.class);
			System.out.println(findings);
			return findings;
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
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
