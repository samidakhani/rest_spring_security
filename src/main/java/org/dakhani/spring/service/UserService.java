package org.dakhani.spring.service;

import java.util.List;

import org.dakhani.spring.bo.UserBO;

/**
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
public interface UserService {

	/**
	 * Retrives a user by username
	 * 
	 * @param username
	 * @return
	 */
	UserBO retrieveUser(final String username);

	/**
	 * Retrieves the list of users.
	 * 
	 * @return
	 */
	List<UserBO> retrieveUsers();
}
