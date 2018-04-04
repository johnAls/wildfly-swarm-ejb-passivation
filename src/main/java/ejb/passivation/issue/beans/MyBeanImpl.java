package ejb.passivation.issue.beans;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ejb.passivation.issue.interfaces.MyBean;

import javax.ejb.Remote;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;

@Stateful
@Remote(MyBean.class)
@LocalBean
public class MyBeanImpl implements MyBean, SessionBean {

	SessionContext ctx;

	private static final long serialVersionUID = 1L;

	public MyBeanImpl() {
		id = System.currentTimeMillis();
	}

	long id;

	int value = 1;

	public long getId() {
		return id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int x) {
		value = x;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		System.out.println("Activating bean with id: " + id);

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		System.out.println("Passivating bean with id: " + id);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		System.out.println("Removing bean with id: " + id);
	}

	@Override
	public void setSessionContext(SessionContext session) throws EJBException, RemoteException {
		this.ctx = session;
	}

}