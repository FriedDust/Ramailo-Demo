package com.frieddust.ramailodemo;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
public class Resources {

	@Produces
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
}
