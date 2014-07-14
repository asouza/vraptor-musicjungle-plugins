package br.com.caelum.vraptor.musicjungle.vaas;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletException;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.musicjungle.controller.HomeController;
import br.com.caelum.vraptor.musicjungle.controller.UsersController;
import br.com.caelum.vraptor.musicjungle.dao.UserDao;
import br.com.caelum.vraptor.musicjungle.interceptor.UserInfo;
import br.com.caelum.vraptor.musicjungle.model.User;
import br.com.caelum.vraptor.paginator.view.Page;
import br.com.caelum.vraptor.vaas.authentication.BasicPrincipal;
import br.com.caelum.vraptor.vaas.event.AuthenticatedEvent;
import br.com.caelum.vraptor.vaas.event.AuthenticationFailedEvent;
import br.com.caelum.vraptor.vaas.event.AuthorizationFailedEvent;
import br.com.caelum.vraptor.vaas.event.LogoutEvent;
import br.com.caelum.vraptor.vaas.event.RefreshUserEvent;

@RequestScoped
public class AuthListener {

	@Inject
    private Result result;
	@Inject
	private UserDao userDao;
	@Inject
	private UserInfo userInfo;

    public void login(@Observes AuthenticatedEvent event){
    	BasicPrincipal<User> principal =  (BasicPrincipal<User>) event.getUserPrincipal();
    	userInfo.login(principal.getLogged());
        result.redirectTo(UsersController.class).home(new Page());
    }

    public void loginFailed(@Observes AuthenticationFailedEvent event){
        result.redirectTo(HomeController.class).index();
    }

    public void logout(@Observes LogoutEvent event) throws ServletException{
    	userInfo.logout();
        result.redirectTo(HomeController.class).index();
    }

    public void unauthorized(@Observes AuthorizationFailedEvent ev){
        result.redirectTo(HomeController.class).index();
    }    
    
    public void refreshUser(@Observes RefreshUserEvent refreshUserEvent){
    	userInfo.login(userDao.refresh(userInfo.getUser()));
    }
}
