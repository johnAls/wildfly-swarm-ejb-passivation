package ejb.passivation.issue.jaxrs;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ejb.passivation.issue.interfaces.MyBean;

@RequestScoped
@Path("/service")
public class MyService {

	@EJB(lookup = "java:module/MyBeanImpl!ejb.passivation.issue.interfaces.MyBean")
	MyBean ejb;

	@GET
	@Produces("text/plain")
	public Response getCurrentValue() throws InterruptedException {

		String myName = Thread.currentThread().getName();
		long ejbId = ejb.getId();
		System.out.println(myName + " has received ejb of id: " + ejbId);

		return Response.ok("Requested completed.").build();
	}
}