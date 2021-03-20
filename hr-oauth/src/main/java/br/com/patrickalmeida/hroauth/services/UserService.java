package br.com.patrickalmeida.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.patrickalmeida.hroauth.clients.UserClient;
import br.com.patrickalmeida.hroauth.entities.User;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserClient userClient;

	public User findById(String email) {
		User user = userClient.getByEmail(email).getBody();

		if (user == null) {
			logger.error("Email not found " + email);
			throw new IllegalArgumentException("Email not found");
		}

		logger.info("Email found " + email);

		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userClient.getByEmail(username).getBody();

		if (user == null) {
			logger.error("Email not found " + username);
			throw new UsernameNotFoundException("Email not found");
		}

		logger.info("Email found " + username);

		return user;
	}
}
