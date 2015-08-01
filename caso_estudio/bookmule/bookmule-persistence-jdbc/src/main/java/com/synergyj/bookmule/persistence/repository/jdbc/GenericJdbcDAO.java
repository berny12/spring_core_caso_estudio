package com.synergyj.bookmule.persistence.repository.jdbc;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GenericJdbcDAO extends JdbcDaoSupport {

	/**
	 * @param ds Inicializa el dataSource de la clase padre vía anotaciones. Con esto se obliga a
	 *            que todos los datos al agregarse al contenedor de Spring ya tienen inicializado el
	 *            DS.
	 */
	@Resource
	public void setJdbcDataSource(DataSource ds) {
		super.setDataSource(ds);
	}
}