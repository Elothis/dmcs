/*
 * generated by Xtext 2.18.0
 */
package mic.model_code_synchronization.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractMappingDSLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(mic.model_code_synchronization.mappingDSL.MappingDSLPackage.eINSTANCE);
		return result;
	}
}
