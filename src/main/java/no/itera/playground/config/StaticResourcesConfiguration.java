package no.itera.playground.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by Pavol Rajzak, Itera.
 */
@Configuration
public class StaticResourcesConfiguration extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    private static final String RESOURCE_LOCATION = "classpath:/resources/static";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATION);
        }
    }

}
