/**
 */
package jack3_metamodel.impl;

import jack3_metamodel.ApplicationScoped;
import jack3_metamodel.ConversationScoped;
import jack3_metamodel.Jack3_metamodelFactory;
import jack3_metamodel.Jack3_metamodelPackage;
import jack3_metamodel.RequestScoped;
import jack3_metamodel.SessionScoped;

import jack3_metamodel.Singleton;
import jack3_metamodel.Stateful;
import jack3_metamodel.Stateless;
import jack3_metamodel.ViewScoped;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Jack3_metamodelPackageImpl extends EPackageImpl implements Jack3_metamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestScopedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sessionScopedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationScopedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationScopedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statelessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statefulEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewScopedEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see jack3_metamodel.Jack3_metamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Jack3_metamodelPackageImpl() {
		super(eNS_URI, Jack3_metamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Jack3_metamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Jack3_metamodelPackage init() {
		if (isInited)
			return (Jack3_metamodelPackage) EPackage.Registry.INSTANCE.getEPackage(Jack3_metamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredJack3_metamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Jack3_metamodelPackageImpl theJack3_metamodelPackage = registeredJack3_metamodelPackage instanceof Jack3_metamodelPackageImpl
				? (Jack3_metamodelPackageImpl) registeredJack3_metamodelPackage
				: new Jack3_metamodelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theJack3_metamodelPackage.createPackageContents();

		// Initialize created meta-data
		theJack3_metamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJack3_metamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Jack3_metamodelPackage.eNS_URI, theJack3_metamodelPackage);
		return theJack3_metamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequestScoped() {
		return requestScopedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequestScoped_Name() {
		return (EAttribute) requestScopedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSessionScoped() {
		return sessionScopedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSessionScoped_Name() {
		return (EAttribute) sessionScopedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApplicationScoped() {
		return applicationScopedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApplicationScoped_Name() {
		return (EAttribute) applicationScopedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConversationScoped() {
		return conversationScopedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConversationScoped_Name() {
		return (EAttribute) conversationScopedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateless() {
		return statelessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStateless_Name() {
		return (EAttribute) statelessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateful() {
		return statefulEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStateful_Name() {
		return (EAttribute) statefulEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSingleton() {
		return singletonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSingleton_Name() {
		return (EAttribute) singletonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getViewScoped() {
		return viewScopedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewScoped_Name() {
		return (EAttribute) viewScopedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Jack3_metamodelFactory getJack3_metamodelFactory() {
		return (Jack3_metamodelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		requestScopedEClass = createEClass(REQUEST_SCOPED);
		createEAttribute(requestScopedEClass, REQUEST_SCOPED__NAME);

		sessionScopedEClass = createEClass(SESSION_SCOPED);
		createEAttribute(sessionScopedEClass, SESSION_SCOPED__NAME);

		applicationScopedEClass = createEClass(APPLICATION_SCOPED);
		createEAttribute(applicationScopedEClass, APPLICATION_SCOPED__NAME);

		conversationScopedEClass = createEClass(CONVERSATION_SCOPED);
		createEAttribute(conversationScopedEClass, CONVERSATION_SCOPED__NAME);

		statelessEClass = createEClass(STATELESS);
		createEAttribute(statelessEClass, STATELESS__NAME);

		statefulEClass = createEClass(STATEFUL);
		createEAttribute(statefulEClass, STATEFUL__NAME);

		singletonEClass = createEClass(SINGLETON);
		createEAttribute(singletonEClass, SINGLETON__NAME);

		viewScopedEClass = createEClass(VIEW_SCOPED);
		createEAttribute(viewScopedEClass, VIEW_SCOPED__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(requestScopedEClass, RequestScoped.class, "RequestScoped", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestScoped_Name(), ecorePackage.getEString(), "name", null, 0, 1, RequestScoped.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sessionScopedEClass, SessionScoped.class, "SessionScoped", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSessionScoped_Name(), ecorePackage.getEString(), "name", null, 0, 1, SessionScoped.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicationScopedEClass, ApplicationScoped.class, "ApplicationScoped", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplicationScoped_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				ApplicationScoped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(conversationScopedEClass, ConversationScoped.class, "ConversationScoped", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConversationScoped_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				ConversationScoped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(statelessEClass, Stateless.class, "Stateless", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateless_Name(), ecorePackage.getEString(), "name", null, 0, 1, Stateless.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statefulEClass, Stateful.class, "Stateful", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateful_Name(), ecorePackage.getEString(), "name", null, 0, 1, Stateful.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singletonEClass, Singleton.class, "Singleton", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleton_Name(), ecorePackage.getEString(), "name", null, 0, 1, Singleton.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewScopedEClass, ViewScoped.class, "ViewScoped", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewScoped_Name(), ecorePackage.getEString(), "name", null, 0, 1, ViewScoped.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Jack3_metamodelPackageImpl
