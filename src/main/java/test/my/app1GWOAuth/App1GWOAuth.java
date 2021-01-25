package test.my.app1GWOAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App1GWOAuth {

	public static void main(String[] args) {
		SpringApplication.run(App1GWOAuth.class, args);
	}

	// @Bean
	// public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	// return builder.routes()
	// .route("app1_route1",
	// r -> r.path("").uri("http://localhost:8080"))
	// .route("app1_route",
	// r -> r.path("/authorized")
	// .uri("http://localhost:8080/authorized"))
	// .route("app3_route", r -> r.path("/users/**")
	// .uri("http://localhost:8083/users/**"))
	// .build();
	// }

}
