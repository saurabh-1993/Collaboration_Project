

package com.niit.collaboration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);
	
	
	
	
	
	@Override
	protected Class[] getRootConfigClasses() {
		logger.debug("Starting of the method getRootConfigClasses");
		// TODO Auto-generated method stub
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class[] getServletConfigClasses() {
		logger.debug("Starting of the method getServletConfigClasses");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		logger.debug("Starting of the method getServletMappings");
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
