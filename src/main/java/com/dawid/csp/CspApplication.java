package com.dawid.csp;

import com.dawid.csp.app.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;


@SpringBootApplication
public class CspApplication {

	public static void main(String[] args) {

		 ApplicationContext ctx = SpringApplication.run(CspApplication.class, args);
		 App app = (App) ctx.getBean("app");
		 StopWatch stopWatch = new StopWatch();
		 stopWatch.start();
		 app.solve();
		 stopWatch.stop();
		 System.out.println("Timetaken: " + stopWatch.getTotalTimeMillis());
	}

}
