package com.pache.investments.server.springboot.exception;

/**
 * @author lpache
 */
public class EmailError extends Exception {

	private static final long serialVersionUID = 1L;

	public EmailError(String msg) {
		super(msg);
	}
	
}
