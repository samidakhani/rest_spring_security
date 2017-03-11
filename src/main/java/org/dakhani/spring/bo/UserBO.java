package org.dakhani.spring.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
public class UserBO implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = -4339064374221981296L;

	private Long age;

	private List<AuthorityBO> authorities;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	/**
	 * @return the age
	 */
	public Long getAge() {
		return this.age;
	}

	/**
	 * @return the authorities
	 */
	public List<AuthorityBO> getAuthorities() {
		return this.authorities;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final Long age) {
		this.age = age;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(final List<AuthorityBO> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBO [age=" + this.age + ", authorities=" + this.authorities
				+ ", firstname=" + this.firstname + ", lastname="
				+ this.lastname + ", password=" + this.password + ", username="
				+ this.username + "]";
	}

}
