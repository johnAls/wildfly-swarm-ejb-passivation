package ejb.passivation.issue.beans;

import javax.ejb.Stateful;

import ejb.passivation.issue.interfaces.MyBean;

import javax.ejb.Remote;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateful
@Remote(MyBean.class)
@LocalBean
public class MyBeanImpl implements MyBean, SessionBean, Serializable {

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

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		System.out.println("Activating bean with id: " + id);

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		System.out.println("Passivating bean with id: " + id);
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		System.out.println("Removing bean with id: " + id);
	}

	@Override
	public void setSessionContext(SessionContext session) throws EJBException, RemoteException {
		this.ctx = session;
	}

}