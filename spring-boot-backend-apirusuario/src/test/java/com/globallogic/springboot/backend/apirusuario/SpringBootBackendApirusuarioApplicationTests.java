package com.globallogic.springboot.backend.apirusuario;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.springboot.backend.apirusuario.entity.Usuario;
import com.globallogic.springboot.backend.apirusuario.services.UsuarioServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootBackendApirusuarioApplicationTests {
	UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	
	
	@Test
	void saveTest() {
		Usuario usuarioTest = new Usuario();
		usuarioTest.setName("Felipe");
		usuarioTest.setEmail("faliaga@test.cl");
		usuarioTest.setPassword("Fer123sd");
		usuarioTest.setEnabled(true);
		usuarioTest.setCreatAt(new Date());
		Usuario usuarioNew = usuarioServiceImpl.save(usuarioTest);
		
		
		Assert.assertNotNull(usuarioNew);
	}
	

	

}
