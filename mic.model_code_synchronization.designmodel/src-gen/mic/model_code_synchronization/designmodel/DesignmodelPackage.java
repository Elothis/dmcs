/**
 */
package mic.model_code_synchronization.designmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see mic.model_code_synchronization.designmodel.DesignmodelFactory
 * @model kind="package"
 * @generated
 */
public interface DesignmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "designmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/designmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "designmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DesignmodelPackage eINSTANCE = mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link mic.model_code_synchronization.designmodel.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mic.model_code_synchronization.designmodel.impl.StateImpl
	 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IMMEDIATE = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mic.model_code_synchronization.designmodel.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mic.model_code_synchronization.designmodel.impl.ComponentTypeImpl
	 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mic.model_code_synchronization.designmodel.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mic.model_code_synchronization.designmodel.impl.InterfaceImpl
	 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__INTERFACE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Another Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ANOTHER_FIELD = 1;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mic.model_code_synchronization.designmodel.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mic.model_code_synchronization.designmodel.impl.TransitionImpl
	 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link mic.model_code_synchronization.designmodel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see mic.model_code_synchronization.designmodel.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mic.model_code_synchronization.designmodel.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link mic.model_code_synchronization.designmodel.State#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see mic.model_code_synchronization.designmodel.State#getTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Transitions();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.State#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see mic.model_code_synchronization.designmodel.State#isImmediate()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Immediate();

	/**
	 * Returns the meta object for class '{@link mic.model_code_synchronization.designmodel.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see mic.model_code_synchronization.designmodel.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mic.model_code_synchronization.designmodel.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link mic.model_code_synchronization.designmodel.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see mic.model_code_synchronization.designmodel.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.Interface#getInterfaceName <em>Interface Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface Name</em>'.
	 * @see mic.model_code_synchronization.designmodel.Interface#getInterfaceName()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_InterfaceName();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.Interface#getAnotherField <em>Another Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Another Field</em>'.
	 * @see mic.model_code_synchronization.designmodel.Interface#getAnotherField()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_AnotherField();

	/**
	 * Returns the meta object for class '{@link mic.model_code_synchronization.designmodel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see mic.model_code_synchronization.designmodel.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link mic.model_code_synchronization.designmodel.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mic.model_code_synchronization.designmodel.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DesignmodelFactory getDesignmodelFactory();

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
		 * The meta object literal for the '{@link mic.model_code_synchronization.designmodel.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mic.model_code_synchronization.designmodel.impl.StateImpl
		 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TRANSITIONS = eINSTANCE.getState_Transitions();

		/**
		 * The meta object literal for the '<em><b>Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IMMEDIATE = eINSTANCE.getState_Immediate();

		/**
		 * The meta object literal for the '{@link mic.model_code_synchronization.designmodel.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mic.model_code_synchronization.designmodel.impl.ComponentTypeImpl
		 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__NAME = eINSTANCE.getComponentType_Name();

		/**
		 * The meta object literal for the '{@link mic.model_code_synchronization.designmodel.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mic.model_code_synchronization.designmodel.impl.InterfaceImpl
		 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__INTERFACE_NAME = eINSTANCE.getInterface_InterfaceName();

		/**
		 * The meta object literal for the '<em><b>Another Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__ANOTHER_FIELD = eINSTANCE.getInterface_AnotherField();

		/**
		 * The meta object literal for the '{@link mic.model_code_synchronization.designmodel.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mic.model_code_synchronization.designmodel.impl.TransitionImpl
		 * @see mic.model_code_synchronization.designmodel.impl.DesignmodelPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

	}

} //DesignmodelPackage
