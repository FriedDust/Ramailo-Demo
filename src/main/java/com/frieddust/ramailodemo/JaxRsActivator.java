package com.frieddust.ramailodemo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ramailo.CorsFilter;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@ApplicationPath("/api/")
public class JaxRsActivator extends Application {

	private Set<Object> singletons = new HashSet<>();

	public JaxRsActivator() {
		singletons.add(new CorsFilter());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
