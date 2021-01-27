package test.my.app1GWOAuth;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/")
	public String index(Model model,
			@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
			@AuthenticationPrincipal OAuth2User oauth2User) {

		Iterator<? extends GrantedAuthority> iterator = oauth2User
				.getAuthorities().iterator();
		logger.debug("authorities");
		while (iterator.hasNext()) {
			GrantedAuthority next = iterator.next();
			if (next instanceof OidcUserAuthority) {
				OidcIdToken idToken = ((OidcUserAuthority) next).getIdToken();
				return idToken.getTokenValue();
			}
		}
		return oauth2User.getAuthorities().toString();
	}

}
