package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public static Properties pro=new Properties();
	
	public static String readProperties(String data) throws IOException {
		File f=new File("src\\test\\sources\\Properties\\Configure.properties");
		FileInputStream file=new FileInputStream(f);
		
		pro.load(file);
		
		String dATA=pro.getProperty(data);
		return dATA;
	}
	public static String userName() throws IOException {
		String username=readProperties("Username");
//		System.out.println(username);
		return username;
	}
	public static String passWord() throws IOException {
		String password=readProperties("Password");
		return password;
	}
	public static String Url() throws IOException {
		String url=readProperties("url");
		return url;
	}	
}


