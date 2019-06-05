package designmodel.generation;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

/**
 * 
 * @author Fabian Glittenberg
 *
 */
public class ClassIdentificationProcessor extends AbstractProcessor<CtClass> {
	
	private String simpleName;
	
	public ClassIdentificationProcessor(String simpleName) {
		this.simpleName = simpleName;
	}

	@Override
	public boolean isToBeProcessed(CtClass candidate) {
		return candidate.isClass() && candidate.getSimpleName().contentEquals(this.simpleName);
	}

	@Override
	public void process(CtClass element) {
		// TODO Auto-generated method stub
		
	}

}
