package com.shankar.sm.config;

import java.util.logging.Logger;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.info("Inside StudentAppInitializer->getRootConfigClasses()");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.info("Inside StudentAppInitializer->getServletConfigClasses()");
		Class<?>[] arr= {StudentAppConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		logger.info("Inside StudentAppInitializer->getServletMappings()");
		String[] arr = {"/"};
		return arr;
	}

}
