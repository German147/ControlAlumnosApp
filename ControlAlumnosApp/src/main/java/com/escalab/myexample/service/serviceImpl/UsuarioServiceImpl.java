package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Usuario;
import com.escalab.myexample.exceptions.UsuarioNotFoundException;
import com.escalab.myexample.repository.IUsuarioRepository;
import com.escalab.myexample.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepository;


    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario, Integer id) {
        Usuario updatedUsuario = new Usuario();
        if (id != null && id > 0) {
            Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
            if (usuarioOp.isPresent()) {
                usuario.setIdUsuario(id);
                updatedUsuario = usuarioRepository.save(usuario);
            } else {
                throw new UsuarioNotFoundException("El numero de Id del usuario No Existe");
            }
        }
        return updatedUsuario;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsuarioNotFoundException("El usuario no fue existe");
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new UsuarioNotFoundException("El Usuario no fue encontrado");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByNombre(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        UserDetails ud = new User(usuario.getNombre(), usuario.getClave(), roles);

        return ud;
    }
}
