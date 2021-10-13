package com.sandp.ratings.soa.kongtool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import com.sandp.ratings.soa.kongtool.entity.Role;
import com.sandp.ratings.soa.kongtool.entity.User;
import com.sandp.ratings.soa.kongtool.repository.UserRepository;


public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
	
	User user = userRepository.getUserByUsername(username);
	
	Set<Role> roles = user.getRoles();
	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

	for (Role role : roles) {
	    authorities.add(new SimpleGrantedAuthority(role.getName()));
	}

	return authorities;
      
    }

}
