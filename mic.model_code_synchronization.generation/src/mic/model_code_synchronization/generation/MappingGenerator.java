package mic.model_code_synchronization.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class MappingGenerator {
	
	public static final String PATH = "C:/Daten/UNI/Masterarbeit_Tool/TestProject";
	
	public static void main (String[] args) {
		MappingGenerator generator = new MappingGenerator();
		generator.identifyMarkerInterfaceMechanisms(PATH, "State");
	}
	
	
	public void identifyMarkerInterfaceMechanisms(String directory, String interfaceName) {
		try {
			for (File f : getAllJavaFilesInDir(directory)) {
				CompilationUnit cu = StaticJavaParser.parse(f);
				cu.findAll(ClassOrInterfaceDeclaration.class).stream().
				filter(c -> !c.isInterface()
						&& c.getImplementedTypes().stream().anyMatch(t -> t.getNameAsString().contentEquals(interfaceName))
						&&c.getNameAsString().contentEquals("AnotherOne"))
				.forEach(c -> {
					c.setName("ChangedClassName");
				});
				String newBody = cu.toString();
				writeToFile(f.getAbsolutePath(), newBody);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<File> getAllJavaFilesInDir(String directoryPath) throws IOException {
		File directory = new File(directoryPath);
		String[] extensions = new String[] { "java" };
		List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);
		return files;
    }
	
	private void writeToFile(String fileName, String output) {
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
