package com.dawid.csp;

import com.dawid.csp.app.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CspApplication {

	public static void main(String[] args) {

		 ApplicationContext ctx = SpringApplication.run(CspApplication.class, args);
		 App app = (App) ctx.getBean("app");
		 app.solve();
	}

}
