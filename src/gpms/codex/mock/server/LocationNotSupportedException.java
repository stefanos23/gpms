/*
 * LocationNotSupportedException.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.mock.server;

/**
 * 
 * LocationNotSupportedException class is an Exception class.
 * LocationNotSupportedException is used when the user is trying to login from a
 * non registered location.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see Exception
 * 
 */

public class LocationNotSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public LocationNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}
}
