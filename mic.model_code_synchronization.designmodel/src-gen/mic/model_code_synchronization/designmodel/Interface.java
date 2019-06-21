/**
 */
package mic.model_code_synchronization.designmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mic.model_code_synchronization.designmodel.Interface#getName <em>Name</em>}</li>
 *   <li>{@link mic.model_code_synchronization.designmodel.Interface#getAnotherField <em>Another Field</em>}</li>
 * </ul>
 *
 * @see mic.model_code_synchronization.designmodel.DesignmodelPackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mic.model_code_synchronization.designmodel.DesignmodelPackage#getInterface_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mic.model_code_synchronization.designmodel.Interface#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Another Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Another Field</em>' attribute.
	 * @see #setAnotherField(String)
	 * @see mic.model_code_synchronization.designmodel.DesignmodelPackage#getInterface_AnotherField()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getAnotherField();

	/**
	 * Sets the value of the '{@link mic.model_code_synchronization.designmodel.Interface#getAnotherField <em>Another Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Another Field</em>' attribute.
	 * @see #getAnotherField()
	 * @generated
	 */
	void setAnotherField(String value);

} // Interface
