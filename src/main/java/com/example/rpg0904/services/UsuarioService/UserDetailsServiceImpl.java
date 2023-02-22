package com.example.rpg0904.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.rpg0904.domain.Usuario;
import com.example.rpg0904.repositories.UsuarioRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(username);
        if (usuario == null)
            throw (new UsernameNotFoundException("Usuario no encontrado!"));
        return User // org.springframework.security.core.userdetails.User
                .withUsername(username)
                .roles(usuario.getRol().toString())
                .password(usuario.getPassword())
                .build();
    }

    public Usuario add (Usuario usuario) {
        if (usuarioRepository.findByNombre(usuario.getNombre()) != null)
        return null; //ya existe ese nombre de usuario
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        
        usuario.setPassword(passCrypted);
        usuarioRepository.save(usuario);
        return usuario;
        }


        public Usuario edit(Usuario usuario) {
            Usuario otroUsuario = usuarioRepository.findByNombre(usuario.getNombre());
            if (otroUsuario != null && otroUsuario.getId() != usuario.getId())
            return null; // ya existe otro usuario con ese nombre
            String passCrypted = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(passCrypted);
            return usuarioRepository.save(usuario);
            }
}