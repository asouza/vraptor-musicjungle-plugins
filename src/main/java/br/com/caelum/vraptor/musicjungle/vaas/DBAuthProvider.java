package br.com.caelum.vraptor.musicjungle.vaas;

import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.musicjungle.dao.UserDao;
import br.com.caelum.vraptor.musicjungle.model.User;
import br.com.caelum.vraptor.vaas.authentication.AuthProvider;
import br.com.caelum.vraptor.vaas.authentication.BasicPrincipal;

@RequestScoped
public class DBAuthProvider implements AuthProvider {

	@Inject
	private UserDao dao;

	@Override
	public Principal authenticate(String login, String password) throws Exception {
		User user = dao.find(login, password);
		if (user != null) {
			return new BasicPrincipal<User>(login, user);
		}
		return null;
	}

}
