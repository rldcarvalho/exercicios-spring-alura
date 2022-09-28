package br.com.rldcarvalho.forum.config.security;

import br.com.rldcarvalho.forum.modelo.Usuario;
import br.com.rldcarvalho.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    public UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByEmail(username);
        if (usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dadoso inválodos");
    }
}
