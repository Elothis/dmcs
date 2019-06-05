package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Utility {
	
	public static List<File> getAllJavaFilesInDir(String directoryPath) throws IOException {
		File directory = new File(directoryPath);
		String[] extensions = new String[] { "java" };
		List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);
		return files;
    }
	
	public static void writeToFile(String fileName, String output) {
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
