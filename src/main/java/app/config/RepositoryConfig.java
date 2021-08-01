package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import app.model.MyCustomer;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	
	@Override
	 public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		 config.exposeIdsFor(MyCustomer.class);
	 }
}
