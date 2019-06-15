import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

/**
 * @author Dovelol
 * @date 2019/6/12 22:58
 */
public class DemoTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

    @Override
    public void customize(Connector connector) {
        connector.setAttribute("acceptorThreadCount", 5);
    }
}
