package org.dakhani.spring.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dakhani.spring.bo.AuthorityBO;
import org.dakhani.spring.bo.UserBO;
import org.dakhani.spring.dao.UserDao;
import org.dakhani.spring.model.Authority;
import org.dakhani.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	/**
	 * @see org.dakhani.spring.service.UserService#retrieveUser(java.lang.String)
	 */
	@Override
	@Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public UserBO retrieveUser(final String username) {

		UserBO userBO = null;

		User user = null;

		try {
			user = this.dao.findByUsername(username);
		} catch (DataAccessException e) {
			throw e;
		}

		if (user != null) {
			userBO = new UserBO();
			userBO.setUsername(user.getUsername());
			userBO.setPassword(user.getPassword());

			Set<Authority> authorites = user.getAuthorities();
			Iterator<Authority> iterator = authorites.iterator();
			List<AuthorityBO> authoritesBOs = new ArrayList<>();

			while (iterator.hasNext()) {

				Authority authority = iterator.next();
				AuthorityBO authoritesBO = new AuthorityBO();

				authoritesBO.setAuthorityName(authority.getAuthorityName());
				authoritesBOs.add(authoritesBO);

			}

			userBO.setAuthorities(authoritesBOs);

		}

		return userBO;
	}

	/**
	 * @see org.dakhani.spring.service.UserService#retrieveUsers()
	 */
	@Override
	@Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<UserBO> retrieveUsers() {

		List<UserBO> users = new ArrayList<>();

		UserBO user1 = new UserBO();
		user1.setUsername("sami");
		user1.setPassword("sami");
		user1.setFirstname("Sami");
		user1.setLastname("Dakhani");
		user1.setAge(new Long(22));
		users.add(user1);

		UserBO user2 = new UserBO();
		user2.setUsername("ali");
		user2.setPassword("ali");
		user2.setFirstname("Ali");
		user2.setLastname("Attar");
		user2.setAge(new Long(22));
		users.add(user2);

		return users;
	}

}
