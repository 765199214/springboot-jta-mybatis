package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootJtaDemoApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringbootJtaDemoApplication.class, args);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
