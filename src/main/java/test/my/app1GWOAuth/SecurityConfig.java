package test.my.app1GWOAuth;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http) {
		http.csrf().disable().authorizeExchange()
				.matchers(PathRequest.toStaticResources().atCommonLocations())
				.permitAll()
				//
				.pathMatchers("/actuator/**").permitAll()
				//
				.anyExchange().authenticated()
				//
				.and().oauth2Login()
				//
				.and().oauth2ResourceServer().jwt();
		http.cors();
		http.csrf().disable();
		return http.build();
	}

}
