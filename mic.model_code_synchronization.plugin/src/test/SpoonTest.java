package test;

import org.junit.jupiter.api.Test;

import spoon.Launcher;
import spoon.reflect.CtModel;

class SpoonTest {

	@Test
	void test() {
		Launcher launcher = new Launcher();

		// path can be a folder or a file
		// addInputResource can be called several times
		launcher.addInputResource("C:/Daten/runtime-EclipseApplication/TestProject/src"); 

		launcher.buildModel();

		CtModel model = launcher.getModel();
		
		AnnotatedWithProcessor proc = new AnnotatedWithProcessor();
		model.processWith(proc);
		
	}

}
