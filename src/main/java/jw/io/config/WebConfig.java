package jw.io.config;

import jw.io.web.Rest;
import jw.io.web.RestDbClient;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Rest rest() {
        return new RestDbClient();
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
        return (tomcat) -> tomcat.addConnectorCustomizers((connector) ->
                ((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setRelaxedQueryChars("{}"));
    }
}
