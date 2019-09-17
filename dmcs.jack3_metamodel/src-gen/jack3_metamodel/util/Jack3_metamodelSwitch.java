/**
 */
package jack3_metamodel.util;

import jack3_metamodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see jack3_metamodel.Jack3_metamodelPackage
 * @generated
 */
public class Jack3_metamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Jack3_metamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jack3_metamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = Jack3_metamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case Jack3_metamodelPackage.REQUEST_SCOPED: {
			RequestScoped requestScoped = (RequestScoped) theEObject;
			T result = caseRequestScoped(requestScoped);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.SESSION_SCOPED: {
			SessionScoped sessionScoped = (SessionScoped) theEObject;
			T result = caseSessionScoped(sessionScoped);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.APPLICATION_SCOPED: {
			ApplicationScoped applicationScoped = (ApplicationScoped) theEObject;
			T result = caseApplicationScoped(applicationScoped);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.CONVERSATION_SCOPED: {
			ConversationScoped conversationScoped = (ConversationScoped) theEObject;
			T result = caseConversationScoped(conversationScoped);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.STATELESS: {
			Stateless stateless = (Stateless) theEObject;
			T result = caseStateless(stateless);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.STATEFUL: {
			Stateful stateful = (Stateful) theEObject;
			T result = caseStateful(stateful);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.SINGLETON: {
			Singleton singleton = (Singleton) theEObject;
			T result = caseSingleton(singleton);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Jack3_metamodelPackage.VIEW_SCOPED: {
			ViewScoped viewScoped = (ViewScoped) theEObject;
			T result = caseViewScoped(viewScoped);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request Scoped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestScoped(RequestScoped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Session Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Session Scoped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSessionScoped(SessionScoped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Scoped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationScoped(ApplicationScoped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conversation Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conversation Scoped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConversationScoped(ConversationScoped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stateless</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stateless</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateless(Stateless object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stateful</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stateful</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateful(Stateful object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Singleton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Singleton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleton(Singleton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Scoped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Scoped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewScoped(ViewScoped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Jack3_metamodelSwitch
