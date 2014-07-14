package br.com.caelum.vraptor.musicjungle.vaas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.vaas.HttpMethod;
import br.com.caelum.vraptor.vaas.RulesByURL;
import br.com.caelum.vraptor.vaas.configurations.LoggedRule;
import br.com.caelum.vraptor.vaas.configurations.RulesConfiguration;

@ApplicationScoped
public class MusicJungleRules implements RulesConfiguration{
	
	@Inject
	private LoggedRule loggedRule;

	@Override
	public RulesByURL rulesByURL() {
		RulesByURL rulesByURL = new RulesByURL();
		rulesByURL.defaultRule(loggedRule);
		rulesByURL.add("/");
		rulesByURL.add("/users",HttpMethod.GET);
		//FIX support same pattern as controllers
		rulesByURL.add("\\/users\\/\\w+");	
		return rulesByURL;
	}

}
