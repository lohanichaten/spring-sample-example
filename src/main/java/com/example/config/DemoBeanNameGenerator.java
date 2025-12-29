package com.example.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class DemoBeanNameGenerator extends AnnotationBeanNameGenerator{

	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String packageName=ClassUtils.getPackageName(definition.getClass());
		String defaultName=super.generateBeanName(definition, registry);
		return packageName+"_"+defaultName;
		
	}

	
	
	
}
