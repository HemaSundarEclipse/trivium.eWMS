package com.samplePractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ssss {

	public ssss() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));
		String projectUrl = prop.getProperty("Project_URL");
		System.out.println(projectUrl);
	}

}
