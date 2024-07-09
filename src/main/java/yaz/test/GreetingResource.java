package yaz.test;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    MyBean myBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Hello from Quarkus REST");
        myBean.openAndSendMessage();
        return "Hello from Quarkus REST";
    }
}
