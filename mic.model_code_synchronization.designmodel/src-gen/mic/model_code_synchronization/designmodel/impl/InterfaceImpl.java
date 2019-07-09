/**
 */
package mic.model_code_synchronization.designmodel.impl;

import mic.model_code_synchronization.designmodel.DesignmodelPackage;
import mic.model_code_synchronization.designmodel.Interface;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mic.model_code_synchronization.designmodel.impl.InterfaceImpl#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link mic.model_code_synchronization.designmodel.impl.InterfaceImpl#getAnotherField <em>Another Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceImpl extends MinimalEObjectImpl.Container implements Interface {
	/**
	 * The default value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceName()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceName()
	 * @generated
	 * @ordered
	 */
	protected String interfaceName = INTERFACE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAnotherField() <em>Another Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherField()
	 * @generated
	 * @ordered
	 */
	protected static final String ANOTHER_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnotherField() <em>Another Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherField()
	 * @generated
	 * @ordered
	 */
	protected String anotherField = ANOTHER_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DesignmodelPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInterfaceName() {
		return interfaceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterfaceName(String newInterfaceName) {
		String oldInterfaceName = interfaceName;
		interfaceName = newInterfaceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DesignmodelPackage.INTERFACE__INTERFACE_NAME,
					oldInterfaceName, interfaceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAnotherField() {
		return anotherField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnotherField(String newAnotherField) {
		String oldAnotherField = anotherField;
		anotherField = newAnotherField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DesignmodelPackage.INTERFACE__ANOTHER_FIELD,
					oldAnotherField, anotherField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DesignmodelPackage.INTERFACE__INTERFACE_NAME:
			return getInterfaceName();
		case DesignmodelPackage.INTERFACE__ANOTHER_FIELD:
			return getAnotherField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DesignmodelPackage.INTERFACE__INTERFACE_NAME:
			setInterfaceName((String) newValue);
			return;
		case DesignmodelPackage.INTERFACE__ANOTHER_FIELD:
			setAnotherField((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DesignmodelPackage.INTERFACE__INTERFACE_NAME:
			setInterfaceName(INTERFACE_NAME_EDEFAULT);
			return;
		case DesignmodelPackage.INTERFACE__ANOTHER_FIELD:
			setAnotherField(ANOTHER_FIELD_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DesignmodelPackage.INTERFACE__INTERFACE_NAME:
			return INTERFACE_NAME_EDEFAULT == null ? interfaceName != null
					: !INTERFACE_NAME_EDEFAULT.equals(interfaceName);
		case DesignmodelPackage.INTERFACE__ANOTHER_FIELD:
			return ANOTHER_FIELD_EDEFAULT == null ? anotherField != null : !ANOTHER_FIELD_EDEFAULT.equals(anotherField);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (interfaceName: ");
		result.append(interfaceName);
		result.append(", anotherField: ");
		result.append(anotherField);
		result.append(')');
		return result.toString();
	}

} //InterfaceImpl
