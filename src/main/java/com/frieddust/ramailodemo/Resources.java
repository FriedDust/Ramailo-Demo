package com.frieddust.ramailodemo;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ramailo.util.ClassFinder;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
public class Resources {

	@Produces
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Produces
	public ClassFinder classFinder() {
		return new ClassFinder("com.frieddust.ramailodemo.entity");
	}
}
