package mcsv.izzi.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class McsvIzziEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvIzziEmpleadosApplication.class, args);
	}

}
