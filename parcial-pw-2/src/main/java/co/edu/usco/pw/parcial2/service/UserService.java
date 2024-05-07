package co.edu.usco.pw.parcial2.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usco.pw.parcial2.repository.UserRepository;
import co.edu.usco.pw.sparcial2.model.Role;
import co.edu.usco.pw.parcial2.model.User;


@Service("userDetailsService")
public class UserService implements UserDetails {
	
	@Autowired
    private UserRepository userRepository;
	
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = userRepository.findByUsername(username);
        if(usuario==null) {
            throw new UsernameNotFoundException(username);
        }
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for(Role role: usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
