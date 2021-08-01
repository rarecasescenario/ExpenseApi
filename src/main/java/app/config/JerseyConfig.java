package app.config;

/**
 * 4:08
 */
import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import app.controller.TestJerseyController;
import app.providers.ObjectMapperFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@ConfigurationProperties(prefix = "spring.jersey")
public class JerseyConfig extends ResourceConfig {

	private static final Logger log = LoggerFactory.getLogger(JerseyConfig.class);

	private String applicationPath;
	private String applicationVersion;
	private ApplicationContext context;

	@Autowired
	public JerseyConfig(ApplicationContext appCtx) {
		configure();
		this.context = appCtx;
	}

	@Bean
	public ResourceConfigCustomizer registerEndpoints() {
		return config -> {
			log.info("Jersey resource classes found:");
			context.getBeansWithAnnotation(Path.class).forEach((name, resource) -> {
				log.info(" -> {}", resource.getClass().getName());
				config.register(resource);
			});
		};
	}

	private String getVersion() {
		String manifestVersion = getClass().getPackage().getImplementationVersion();
		return manifestVersion == null ? applicationVersion : manifestVersion;
	}

	private void configure() {
		register(JacksonFeature.class);
		register(JacksonJaxbJsonProvider.class);
		register(ObjectMapperContextResolver.class);
		// rbc register(LocalDateParamConverterProvider.class);
		// rbc register(CORSFilter.class);

		/* Swagger */
		// register(ApiListingResource.class);
		// register(SwaggerSerializers.class);
		register(WadlResource.class);

		register(TestJerseyController.class);

	}

	public void setApplicationPath(String applicationPath) {
		this.applicationPath = applicationPath;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	@Provider
	public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

		private final ObjectMapper mapper;

		public ObjectMapperContextResolver() {
			mapper = ObjectMapperFactory.getInstance();
		}

		@Override
		public ObjectMapper getContext(Class<?> type) {
			return mapper;
		}
	}

}
