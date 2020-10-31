package org.rodrigo.cursos.spring.core.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.rodrigo.cursos.spring.core.repository.mapping.OrdenCompraMappingQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJavaConfig {
	
	@Resource
	private DataSource dataSource;
	
	@Bean
	public OrdenCompraMappingQuery ordenCompraMappingQueryById() {
		return new OrdenCompraMappingQuery(dataSource, 1);
	}
	
	@Bean
	public OrdenCompraMappingQuery ordenCompraMappingByRangoFechas() {
		return new OrdenCompraMappingQuery(dataSource, 2);
	}

}
