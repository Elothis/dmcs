package test;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.filter.TypeFilter;

class SpoonTest {

	@Test
	void test() {
		Launcher launcher = new Launcher();

		// path can be a folder or a file
		// addInputResource can be called several times
		launcher.addInputResource("C:/Daten/runtime-EclipseApplication/TestProject/src"); 
		//launcher.getEnvironment().setSourceOutputDirectory(new File("C:/Daten/spoon-output"));
		System.out.println(launcher.getEnvironment().getSourceOutputDirectory());
		launcher.buildModel();

//		CtModel model = launcher.getModel();
		
//		AnnotatedWithProcessor proc = new AnnotatedWithProcessor();
//		model.processWith(proc);
		
		List<CtClass> classList = launcher.getModel().filterChildren(new TypeFilter<CtClass>(CtClass.class)).
		filterChildren(new Filter<CtClass>() {
			@Override
			public boolean matches(CtClass element) {
				if(element.getSimpleName().contentEquals("Ready")) {
					return true;
				}
				return false;
			}
			
		}).list();
		Set<ModifierKind> modifierSet = new HashSet<>();
		modifierSet.add(ModifierKind.PUBLIC);
		CtMethod<?> newMethod = launcher.getFactory().Method().create(classList.get(0), modifierSet, launcher.getFactory().Type().VOID_PRIMITIVE, "newOne", null, null, launcher.getFactory().createBlock());
		
		
		CtClass<?> newClass = launcher.getFactory().Class().create("NewOne");
		newClass.addMethod(newMethod);
		newClass.setVisibility(ModifierKind.PUBLIC);
		
		launcher.prettyprint();
		
		System.out.println(classList);
		
	}

}
