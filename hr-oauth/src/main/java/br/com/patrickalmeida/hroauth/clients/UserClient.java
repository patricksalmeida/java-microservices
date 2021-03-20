package br.com.patrickalmeida.hroauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.patrickalmeida.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

	@GetMapping("/search")
	ResponseEntity<User> getByEmail(@RequestParam String email);
	
}
