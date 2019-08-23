/**
 */
package jack3_metamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see jack3_metamodel.Jack3_metamodelFactory
 * @model kind="package"
 * @generated
 */
public interface Jack3_metamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jack3_metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/jack3_metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jack3_metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Jack3_metamodelPackage eINSTANCE = jack3_metamodel.impl.Jack3_metamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.RequestScopedImpl <em>Request Scoped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.RequestScopedImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getRequestScoped()
	 * @generated
	 */
	int REQUEST_SCOPED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SCOPED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Request Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SCOPED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Request Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SCOPED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.SessionScopedImpl <em>Session Scoped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.SessionScopedImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getSessionScoped()
	 * @generated
	 */
	int SESSION_SCOPED = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SCOPED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Session Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SCOPED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Session Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SCOPED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.ApplicationScopedImpl <em>Application Scoped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.ApplicationScopedImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getApplicationScoped()
	 * @generated
	 */
	int APPLICATION_SCOPED = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCOPED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Application Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCOPED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Application Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCOPED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.ConversationScopedImpl <em>Conversation Scoped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.ConversationScopedImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getConversationScoped()
	 * @generated
	 */
	int CONVERSATION_SCOPED = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_SCOPED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Conversation Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_SCOPED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Conversation Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_SCOPED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.StatelessImpl <em>Stateless</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.StatelessImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getStateless()
	 * @generated
	 */
	int STATELESS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS__NAME = 0;

	/**
	 * The number of structural features of the '<em>Stateless</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stateless</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.StatefulImpl <em>Stateful</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.StatefulImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getStateful()
	 * @generated
	 */
	int STATEFUL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Stateful</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stateful</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.SingletonImpl <em>Singleton</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.SingletonImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getSingleton()
	 * @generated
	 */
	int SINGLETON = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON__NAME = 0;

	/**
	 * The number of structural features of the '<em>Singleton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Singleton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jack3_metamodel.impl.ViewScopedImpl <em>View Scoped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jack3_metamodel.impl.ViewScopedImpl
	 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getViewScoped()
	 * @generated
	 */
	int VIEW_SCOPED = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SCOPED__NAME = 0;

	/**
	 * The number of structural features of the '<em>View Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SCOPED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>View Scoped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SCOPED_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.RequestScoped <em>Request Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Scoped</em>'.
	 * @see jack3_metamodel.RequestScoped
	 * @generated
	 */
	EClass getRequestScoped();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.RequestScoped#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.RequestScoped#getName()
	 * @see #getRequestScoped()
	 * @generated
	 */
	EAttribute getRequestScoped_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.SessionScoped <em>Session Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session Scoped</em>'.
	 * @see jack3_metamodel.SessionScoped
	 * @generated
	 */
	EClass getSessionScoped();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.SessionScoped#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.SessionScoped#getName()
	 * @see #getSessionScoped()
	 * @generated
	 */
	EAttribute getSessionScoped_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.ApplicationScoped <em>Application Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Scoped</em>'.
	 * @see jack3_metamodel.ApplicationScoped
	 * @generated
	 */
	EClass getApplicationScoped();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.ApplicationScoped#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.ApplicationScoped#getName()
	 * @see #getApplicationScoped()
	 * @generated
	 */
	EAttribute getApplicationScoped_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.ConversationScoped <em>Conversation Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversation Scoped</em>'.
	 * @see jack3_metamodel.ConversationScoped
	 * @generated
	 */
	EClass getConversationScoped();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.ConversationScoped#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.ConversationScoped#getName()
	 * @see #getConversationScoped()
	 * @generated
	 */
	EAttribute getConversationScoped_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.Stateless <em>Stateless</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateless</em>'.
	 * @see jack3_metamodel.Stateless
	 * @generated
	 */
	EClass getStateless();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.Stateless#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.Stateless#getName()
	 * @see #getStateless()
	 * @generated
	 */
	EAttribute getStateless_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.Stateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful</em>'.
	 * @see jack3_metamodel.Stateful
	 * @generated
	 */
	EClass getStateful();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.Stateful#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.Stateful#getName()
	 * @see #getStateful()
	 * @generated
	 */
	EAttribute getStateful_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.Singleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Singleton</em>'.
	 * @see jack3_metamodel.Singleton
	 * @generated
	 */
	EClass getSingleton();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.Singleton#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.Singleton#getName()
	 * @see #getSingleton()
	 * @generated
	 */
	EAttribute getSingleton_Name();

	/**
	 * Returns the meta object for class '{@link jack3_metamodel.ViewScoped <em>View Scoped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Scoped</em>'.
	 * @see jack3_metamodel.ViewScoped
	 * @generated
	 */
	EClass getViewScoped();

	/**
	 * Returns the meta object for the attribute '{@link jack3_metamodel.ViewScoped#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jack3_metamodel.ViewScoped#getName()
	 * @see #getViewScoped()
	 * @generated
	 */
	EAttribute getViewScoped_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Jack3_metamodelFactory getJack3_metamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.RequestScopedImpl <em>Request Scoped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.RequestScopedImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getRequestScoped()
		 * @generated
		 */
		EClass REQUEST_SCOPED = eINSTANCE.getRequestScoped();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SCOPED__NAME = eINSTANCE.getRequestScoped_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.SessionScopedImpl <em>Session Scoped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.SessionScopedImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getSessionScoped()
		 * @generated
		 */
		EClass SESSION_SCOPED = eINSTANCE.getSessionScoped();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION_SCOPED__NAME = eINSTANCE.getSessionScoped_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.ApplicationScopedImpl <em>Application Scoped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.ApplicationScopedImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getApplicationScoped()
		 * @generated
		 */
		EClass APPLICATION_SCOPED = eINSTANCE.getApplicationScoped();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_SCOPED__NAME = eINSTANCE.getApplicationScoped_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.ConversationScopedImpl <em>Conversation Scoped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.ConversationScopedImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getConversationScoped()
		 * @generated
		 */
		EClass CONVERSATION_SCOPED = eINSTANCE.getConversationScoped();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONVERSATION_SCOPED__NAME = eINSTANCE.getConversationScoped_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.StatelessImpl <em>Stateless</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.StatelessImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getStateless()
		 * @generated
		 */
		EClass STATELESS = eINSTANCE.getStateless();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATELESS__NAME = eINSTANCE.getStateless_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.StatefulImpl <em>Stateful</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.StatefulImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getStateful()
		 * @generated
		 */
		EClass STATEFUL = eINSTANCE.getStateful();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL__NAME = eINSTANCE.getStateful_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.SingletonImpl <em>Singleton</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.SingletonImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getSingleton()
		 * @generated
		 */
		EClass SINGLETON = eINSTANCE.getSingleton();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLETON__NAME = eINSTANCE.getSingleton_Name();

		/**
		 * The meta object literal for the '{@link jack3_metamodel.impl.ViewScopedImpl <em>View Scoped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jack3_metamodel.impl.ViewScopedImpl
		 * @see jack3_metamodel.impl.Jack3_metamodelPackageImpl#getViewScoped()
		 * @generated
		 */
		EClass VIEW_SCOPED = eINSTANCE.getViewScoped();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_SCOPED__NAME = eINSTANCE.getViewScoped_Name();

	}

} //Jack3_metamodelPackage
