package com.frieddust.ramailodemo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frieddust.ramailodemo.entity.User;
import com.ramailo.annotation.Logged;
import com.ramailo.auth.Identity;
import com.ramailo.auth.dto.ChangePasswordDTO;
import com.ramailo.auth.dto.ForgotPasswordDTO;
import com.ramailo.auth.dto.ResetPasswordDTO;
import com.ramailo.auth.dto.TokenDTO;
import com.ramailo.service.IdentityService;

@Stateless
@Logged
public class IdentityServiceImpl implements IdentityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdentityServiceImpl.class);

	@Inject
	private EntityManager em;

	@Override
	public Identity fetchByEmail(String email) {
		TypedQuery<User> query = em.createQuery("Select u from User u where u.email= :email", User.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.warn("No result found for email Id :{}", email);
			LOGGER.warn("Exception {}", e);
			return null;
		}
	}

	@Override
	public Identity fetchById(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public Identity fetchByEmailAndPassword(String email, String password) {
		return null;
	}

	@Override
	public void saveRefreshToken(Identity user, TokenDTO tokenDTO) {

	}

	@Override
	public void changePassword(Long userId, ChangePasswordDTO changePasswordDTO) {
	}

	@Override
	public void sendPasswordResetLink(ForgotPasswordDTO forgotPassword) {
	}

	@Override
	public Identity resetPassword(ResetPasswordDTO resetPassword) {
		return null;
	}

}
