package org.dakhani.spring.security;

import java.util.List;

import org.dakhani.spring.dao.UserDao;
import org.dakhani.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Sami Dakhani Created on Feb 15, 2017
 *
 */
@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserDao dao;

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		User user = this.dao.findByUsername(username);

		List<GrantedAuthority> grantedAuthorities = SecurityUtil
				.convertAuthorities(user.getAuthorities());
		return new org.springframework.security.core.userdetails.User(username,
				user.getPassword(), grantedAuthorities);
	}

}
