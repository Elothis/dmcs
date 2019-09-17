/**
 */
package jack3_metamodel.util;

import jack3_metamodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see jack3_metamodel.Jack3_metamodelPackage
 * @generated
 */
public class Jack3_metamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Jack3_metamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jack3_metamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Jack3_metamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Jack3_metamodelSwitch<Adapter> modelSwitch = new Jack3_metamodelSwitch<Adapter>() {
		@Override
		public Adapter caseRequestScoped(RequestScoped object) {
			return createRequestScopedAdapter();
		}

		@Override
		public Adapter caseSessionScoped(SessionScoped object) {
			return createSessionScopedAdapter();
		}

		@Override
		public Adapter caseApplicationScoped(ApplicationScoped object) {
			return createApplicationScopedAdapter();
		}

		@Override
		public Adapter caseConversationScoped(ConversationScoped object) {
			return createConversationScopedAdapter();
		}

		@Override
		public Adapter caseStateless(Stateless object) {
			return createStatelessAdapter();
		}

		@Override
		public Adapter caseStateful(Stateful object) {
			return createStatefulAdapter();
		}

		@Override
		public Adapter caseSingleton(Singleton object) {
			return createSingletonAdapter();
		}

		@Override
		public Adapter caseViewScoped(ViewScoped object) {
			return createViewScopedAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.RequestScoped <em>Request Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.RequestScoped
	 * @generated
	 */
	public Adapter createRequestScopedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.SessionScoped <em>Session Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.SessionScoped
	 * @generated
	 */
	public Adapter createSessionScopedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.ApplicationScoped <em>Application Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.ApplicationScoped
	 * @generated
	 */
	public Adapter createApplicationScopedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.ConversationScoped <em>Conversation Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.ConversationScoped
	 * @generated
	 */
	public Adapter createConversationScopedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.Stateless <em>Stateless</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.Stateless
	 * @generated
	 */
	public Adapter createStatelessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.Stateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.Stateful
	 * @generated
	 */
	public Adapter createStatefulAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.Singleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.Singleton
	 * @generated
	 */
	public Adapter createSingletonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jack3_metamodel.ViewScoped <em>View Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jack3_metamodel.ViewScoped
	 * @generated
	 */
	public Adapter createViewScopedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Jack3_metamodelAdapterFactory
