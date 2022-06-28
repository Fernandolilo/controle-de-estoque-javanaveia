package br.com.javanaveia.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.repositories.ClienteRepository;
import br.com.javanaveia.client.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{


	private final ClienteRepository repository;
	
	@Autowired
	public UserDetailsServiceImpl(ClienteRepository repository) {
		this.repository = repository;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Cliente cli = repository.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getPerfis());
	}

}
