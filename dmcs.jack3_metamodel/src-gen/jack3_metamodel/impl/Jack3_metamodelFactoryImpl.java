/**
 */
package jack3_metamodel.impl;

import jack3_metamodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Jack3_metamodelFactoryImpl extends EFactoryImpl implements Jack3_metamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Jack3_metamodelFactory init() {
		try {
			Jack3_metamodelFactory theJack3_metamodelFactory = (Jack3_metamodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(Jack3_metamodelPackage.eNS_URI);
			if (theJack3_metamodelFactory != null) {
				return theJack3_metamodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Jack3_metamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jack3_metamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Jack3_metamodelPackage.REQUEST_SCOPED:
			return createRequestScoped();
		case Jack3_metamodelPackage.SESSION_SCOPED:
			return createSessionScoped();
		case Jack3_metamodelPackage.APPLICATION_SCOPED:
			return createApplicationScoped();
		case Jack3_metamodelPackage.CONVERSATION_SCOPED:
			return createConversationScoped();
		case Jack3_metamodelPackage.STATELESS:
			return createStateless();
		case Jack3_metamodelPackage.STATEFUL:
			return createStateful();
		case Jack3_metamodelPackage.SINGLETON:
			return createSingleton();
		case Jack3_metamodelPackage.VIEW_SCOPED:
			return createViewScoped();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequestScoped createRequestScoped() {
		RequestScopedImpl requestScoped = new RequestScopedImpl();
		return requestScoped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SessionScoped createSessionScoped() {
		SessionScopedImpl sessionScoped = new SessionScopedImpl();
		return sessionScoped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationScoped createApplicationScoped() {
		ApplicationScopedImpl applicationScoped = new ApplicationScopedImpl();
		return applicationScoped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConversationScoped createConversationScoped() {
		ConversationScopedImpl conversationScoped = new ConversationScopedImpl();
		return conversationScoped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stateless createStateless() {
		StatelessImpl stateless = new StatelessImpl();
		return stateless;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stateful createStateful() {
		StatefulImpl stateful = new StatefulImpl();
		return stateful;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Singleton createSingleton() {
		SingletonImpl singleton = new SingletonImpl();
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ViewScoped createViewScoped() {
		ViewScopedImpl viewScoped = new ViewScopedImpl();
		return viewScoped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Jack3_metamodelPackage getJack3_metamodelPackage() {
		return (Jack3_metamodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Jack3_metamodelPackage getPackage() {
		return Jack3_metamodelPackage.eINSTANCE;
	}

} //Jack3_metamodelFactoryImpl
