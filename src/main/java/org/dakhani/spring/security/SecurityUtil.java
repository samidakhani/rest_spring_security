package org.dakhani.spring.security;

import java.util.List;
import java.util.Set;

import org.dakhani.spring.model.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.google.common.base.Functions;
import com.google.common.collect.Iterables;

/**
 * @author Sami Dakhani Created on Feb 15, 2017
 *
 */
public class SecurityUtil {

	public static final List<GrantedAuthority> convertAuthorities(
			final Set<Authority> authorities) {

		final Iterable<String> authorityNames = Iterables.transform(authorities,
				Functions.toStringFunction());
		final String[] arrayOfAuthorityNames = Iterables.toArray(authorityNames,
				String.class);
		return AuthorityUtils.createAuthorityList(arrayOfAuthorityNames);
	}
}
