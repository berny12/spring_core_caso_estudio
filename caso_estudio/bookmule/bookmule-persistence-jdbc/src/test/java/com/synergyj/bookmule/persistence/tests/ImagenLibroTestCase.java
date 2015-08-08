package com.synergyj.bookmule.persistence.tests;

/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import com.synergyj.bookmule.core.domain.Editorial;
import com.synergyj.bookmule.core.domain.ImagenLibro;
import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.catalog.StatusLibro;
import com.synergyj.bookmule.persistence.dao.ImagenLibroDAO;
import com.synergyj.bookmule.persistence.dao.LibroDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbcAppContext.xml")
public class ImagenLibroTestCase extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Resource
	private ImagenLibroDAO imagenLibroDAO;

	@Resource
	private LibroDAO libroDAO;

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ImagenLibroTestCase.class);

	/**
	 * @throws IOException
	 */
	@Test
	public void creaImagenesLibro() throws IOException {
		ImagenLibro imagen = construyeImagenFicticia();
		Set<ImagenLibro> imagenSet;
		Libro libro = construyeLibroFicticio();
		libroDAO.crea(libro);
		imagenLibroDAO.crea(imagen, libro.getId());

		imagenSet = imagenLibroDAO.busca(libro.getId());
		Assert.assertEquals(1, imagenSet.size());
		Assert.assertNotNull(imagenSet.iterator().next().getId());
		logger.debug("guardando imagenes en bin");
		FileCopyUtils.copy(imagenSet.iterator().next().getImagen(), new File(
				"bin/imagen1.jpeg"));
		logger.debug("Compaando imagenes");
		Assert.assertArrayEquals(imagen.getImagen(), imagenSet.iterator()
				.next().getImagen());
	}

	/**
	 * @return
	 * @throws IOException
	 */
	private ImagenLibro construyeImagenFicticia() throws IOException {
		ImagenLibro imagen;
		byte[] bytes;
		imagen = new ImagenLibro();
		imagen.setNumImagen(1);
		bytes = FileCopyUtils.copyToByteArray(new ClassPathResource(
				"imagenes/spring1.jpeg").getFile());
		imagen.setImagen(bytes);
		return imagen;
	}

	/**
	 * @return
	 */
	private Libro construyeLibroFicticio() {
		Libro libro = new Libro();
		Editorial editorial = null;
		libro.setCodigoClasificacion("B034");
		libro.setCodigoColor("002343");
		libro.setCodigoClasificacion("WL0092");
		libro.setEdicion(1);

		editorial = new Editorial();
		editorial.setId(jdbcTemplate.queryForObject(
				"select min(editorial_id) from editorial", Long.class));
		Assert.assertNotNull(editorial.getId());
		libro.setEditorial(editorial);
		libro.setIsbn("9788481812275");
		libro.setNumeroEjemplares(1);
		libro.setPrecioVenta(new Float(234.56));
		libro.setStatusLibro(StatusLibro.DISPONIBLE);
		libro.setTitulo("100 años de Soledad");
		return libro;
	}
}