package assignment.exchange.global.config;

import assignment.exchange.domain.externalapi.runtime.RestTemplateExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Configuration
public class CustomServletContextListener implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplateExecutor restTemplateExecutor;

    public CustomServletContextListener() {}

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.warn("context Initialized");
        restTemplateExecutor = new RestTemplateExecutor();
        restTemplateExecutor.startExecutor();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.warn("context Destroyed");
        restTemplateExecutor.stopExecutor();
    }


}
