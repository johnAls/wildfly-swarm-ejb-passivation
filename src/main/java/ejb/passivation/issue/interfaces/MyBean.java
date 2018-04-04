package ejb.passivation.issue.interfaces;

import javax.ejb.Remote;

@Remote
public interface MyBean {

	public int getValue();

	public long getId();

	public void setValue(int x);

}
