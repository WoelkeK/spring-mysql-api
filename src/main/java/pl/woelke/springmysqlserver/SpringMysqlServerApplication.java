package pl.woelke.springmysqlserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.woelke.springmysqlserver.util.Server;

import java.io.IOException;

@SpringBootApplication
public class SpringMysqlServerApplication {

	public static void main(String[] args) throws IOException {

		Server server = new Server();
		SpringApplication.run(SpringMysqlServerApplication.class, args);
		server.connect();
	}

}
