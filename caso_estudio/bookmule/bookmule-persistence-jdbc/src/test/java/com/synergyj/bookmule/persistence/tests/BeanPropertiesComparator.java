/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.tests;

import org.apache.commons.beanutils.BeanComparator;
import org.junit.Assert;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class BeanPropertiesComparator {

	/**
	 * Metodo de utileria para comparar propiedades de 2 beans.
	 * @param o1
	 * @param o2
	 * @param properties
	 */
	public static void compare(Object o1, Object o2, String... properties) {
		BeanComparator<Object> comparator;
		comparator = new BeanComparator<Object>();
		for (String property : properties) {
			comparator.setProperty(property);
			Assert.assertTrue("valores diferentes para property " + property,
					comparator.compare(o1, o2) == 0);
		}
	}
}
