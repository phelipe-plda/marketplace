/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phelipe.marketplace.security;

import com.phelipe.marketplace.model.entity.Usuario;
import com.phelipe.marketplace.model.repository.UsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pheli
 */
@Transactional
@Repository
public class UsuarioDetailsConfig implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.usuario(login);
        if(usuario == null)
            throw new UsernameNotFoundException("usuário não escontrado!");
        return new User(usuario.getLogin(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }
    
}
