package MoneyHans;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
//import org.testng.annotations.Test;

public class WebServices
{	
	public String aptTesting(String actURL) throws Exception 
	{
		try 
		{
			URL appURL = new URL("http://www.themoneyhans.com");
			URL url = new URL("http://www.themoneyhans.com/api/articles/url/put-your-eggs-in-one-basket...");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
			}
	
			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
			entireResponse += scan.nextLine();
	
			System.out.println("Response : "+entireResponse);
			scan.close();
			JSONObject obj = new JSONObject(entireResponse );
						
			JSONObject arr = obj.getJSONObject("media");
			String sPath = arr.getString("path");
			System.out.println("Path is: "+sPath);
			
			String actualURL = appURL + "/" + sPath;
			System.out.println(actURL);
			
			actURL = actualURL;
			return actURL;
			//conn.disconnect();
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return actURL;
				
	}	
}