/**
 */
package jack3_metamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see jack3_metamodel.Jack3_metamodelPackage
 * @generated
 */
public interface Jack3_metamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Jack3_metamodelFactory eINSTANCE = jack3_metamodel.impl.Jack3_metamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Request Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Scoped</em>'.
	 * @generated
	 */
	RequestScoped createRequestScoped();

	/**
	 * Returns a new object of class '<em>Session Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session Scoped</em>'.
	 * @generated
	 */
	SessionScoped createSessionScoped();

	/**
	 * Returns a new object of class '<em>Application Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Scoped</em>'.
	 * @generated
	 */
	ApplicationScoped createApplicationScoped();

	/**
	 * Returns a new object of class '<em>Conversation Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conversation Scoped</em>'.
	 * @generated
	 */
	ConversationScoped createConversationScoped();

	/**
	 * Returns a new object of class '<em>Stateless</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stateless</em>'.
	 * @generated
	 */
	Stateless createStateless();

	/**
	 * Returns a new object of class '<em>Stateful</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stateful</em>'.
	 * @generated
	 */
	Stateful createStateful();

	/**
	 * Returns a new object of class '<em>Singleton</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Singleton</em>'.
	 * @generated
	 */
	Singleton createSingleton();

	/**
	 * Returns a new object of class '<em>View Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View Scoped</em>'.
	 * @generated
	 */
	ViewScoped createViewScoped();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Jack3_metamodelPackage getJack3_metamodelPackage();

} //Jack3_metamodelFactory
