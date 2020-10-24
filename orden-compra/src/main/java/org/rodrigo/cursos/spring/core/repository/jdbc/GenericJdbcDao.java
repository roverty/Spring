package org.rodrigo.cursos.spring.core.repository.jdbc;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class GenericJdbcDao extends JdbcDaoSupport {
	
	@Resource
	protected void setJdbcDataSource(DataSource ds) {
		super.setDataSource(ds);
	}
	
}

