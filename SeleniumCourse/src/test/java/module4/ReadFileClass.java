package module4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFileClass {
	// Properties class variable created
	Properties pc;
	// file path
	String pathOfFile = "C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\src\\test\\resources\\DataFile.properties";

	// constructor created
	public ReadFileClass() throws IOException {
		// Properties object created
		pc = new Properties();
		// FileInputStream object created and file path passes to its constructor
		FileInputStream file = new FileInputStream(pathOfFile);
		// load function called
		pc.load(file);
	}

	// url get method
	public String getUrl() {
		String url = pc.getProperty("url");

		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("URL not Found");
		}
	}

	// username get method
	public String getUsername() {
		String username = pc.getProperty("username");

		if (username != null) {
			return username;
		} else {
			throw new RuntimeException("Username not Found");
		}
	}

	// password get method
	public String getPassword() {
		String password = pc.getProperty("password");

		if (password != null) {
			return password;
		} else {
			throw new RuntimeException("Password not Found");
		}
	}
}
