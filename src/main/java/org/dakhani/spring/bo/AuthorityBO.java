package org.dakhani.spring.bo;

import java.io.Serializable;

/**
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
public class AuthorityBO implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 3308363286089339471L;

	private String authorityName;

	/**
	 * @return the authorityName
	 */
	public String getAuthorityName() {
		return this.authorityName;
	}

	/**
	 * @param authorityName
	 *            the authorityName to set
	 */
	public void setAuthorityName(final String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.authorityName;
	}

}
