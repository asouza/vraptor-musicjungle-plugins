/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.musicjungle.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actioncache.Cached;
import br.com.caelum.vraptor.musicjungle.dao.DefaultUserDao;
import br.com.caelum.vraptor.musicjungle.dao.UserDao;
import br.com.caelum.vraptor.musicjungle.interceptor.Public;
import br.com.caelum.vraptor.musicjungle.interceptor.UserInfo;
import br.com.caelum.vraptor.validator.Validator;

/**
 * This class will be responsible to login/logout users.
 * We will use VRaptor URI conventions for this class.
 *
 * For accessing the method doStuff of the class SomethingController,
 * the URI is: /something/doStuff
 *
 */
@Controller
public class HomeController {

    private Result result;
    private UserInfo userInfo;

	//CDI eyes only
	@Deprecated
	public HomeController() {}

	/**
	 * You can receive any dependency on constructor. If VRaptor knows all dependencies, this
	 * class will be created with no problem. You can use as dependencies:
	 * - all VRaptor components, e.g {@link Result} and {@link Validator}
	 * - all of your CDI classes, e.g {@link DefaultUserDao}
	 */
	@Inject
	public HomeController(UserInfo userInfo, Result result) {
		this.result = result;
        this.userInfo = userInfo;
	}

	/**
	 * Using the convention, the URI for this method is
	 * /home/logout
	 */
	@Path("/logout")
	public void logout() {
	}

	/**
	 * We should not provide direct access to jsps, so we need to have an empty method
	 * for redirecting to jsp. In this case we will use the root URI, which will be
	 * redirected to jsp /WEB-INF/jsp/home/login.jsp
	 *
	 * This method only accepts GET requests
	 */
	@Public
	@Post("/login")	
	public void login() {
	}
	
	@Public
	public void index(){
		System.out.println("Passando por aqui...");
	}

}
