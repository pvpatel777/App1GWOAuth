package test.my.app1GWOAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http) {
		http.authorizeExchange(exchanges -> exchanges.pathMatchers("/auth/**")
				.permitAll().pathMatchers("/*/auth/**").permitAll()
				.pathMatchers("/css/**", "/js/**", "/images/**", "/static/**",
						"/favicon.ico")
				.permitAll().pathMatchers("/oauth2/**").permitAll()
				.pathMatchers("/authorized").permitAll()
				.pathMatchers("/actuator/**").permitAll().anyExchange()
				.authenticated()).oauth2Login();
		http.headers().frameOptions()
				.mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
		http.cors();
		http.csrf().disable();
		return http.build();
	}

}

// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//
// }
// }