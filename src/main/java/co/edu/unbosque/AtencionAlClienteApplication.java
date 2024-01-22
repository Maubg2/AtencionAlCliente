package co.edu.unbosque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unbosque.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class AtencionAlClienteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AtencionAlClienteApplication.class, args);
	}

/*	@Autowired
	private EstudianteRepositorio repositorio;
*/
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
	/*	Estudiante estudiante1 = new Estudiante("Mauricio", "Beltran", "mau@gmail.com");
		repositorio.save(estudiante1);
		
		Estudiante estudiante2 = new Estudiante("Edison", "Garzon", "edi@gmail.com");
		repositorio.save(estudiante2);
		
		Usuario mau = new Usuario("Beltran", "123456", "Mauricio", "maubg");
		repositorio.save(mau);
		
		Usuario dan = new Usuario("Sanchez", "123456", "Danna", "dannaBanana");
		repositorio.save(dan);
	*/	
	}

}
