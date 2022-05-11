package gov.ifms.edp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * The Class EDPPropertiesUtils.
 */
@Configuration
public class EDPPropertiesUtils {
	
	/** The Constant SPRING_PROFILES_ACTIVE. */
  	public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";
	  
  	/** The Constant LOGGER. */
  	private static final Logger LOGGER=LoggerFactory.getLogger(EDPPropertiesUtils.class);
  	
	/**
  	 * Inits the properties.
  	 */
  	public void initProperties() {
		String activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE);
		LOGGER.info("activeProfile ::::::::::::::::::: {}",activeProfile);
		if (activeProfile == null) {
			activeProfile = "dev";
		}
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[]
                 {new ClassPathResource("application.properties"),
                              new ClassPathResource(activeProfile+EDPConstant.SLASH+"application-" + activeProfile + ".properties")};
         propertySourcesPlaceholderConfigurer.setLocations(resources);
         LOGGER.info("Active Profile is ::::::::::::::::::::: {} ",activeProfile);
	}
}