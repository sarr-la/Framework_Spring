package com.senforage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.senforage.dao.ClientRepository;
import com.senforage.entities.Client;
@SpringBootApplication
public class SpringFrameworkApplication implements CommandLineRunner {
    @Autowired
	private ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clientRepository.save(new Client(null, "Gueye", "Thioce", "Thioceouest", "773058798"));
		clientRepository.save(new Client(null, "Ndour", "Bandia", "Bandiaserere", "775472125"));
		clientRepository.save(new Client(null, "Diallo", "Ndrame", "Ndramescal", "774586521"));
		clientRepository.save(new Client(null, "Sow", "koutal", "koutaldiaoule", "784523224"));
		clientRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
		
	}

}
