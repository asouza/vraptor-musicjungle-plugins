package br.com.caelum.vraptor.musicjungle.vaas;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.vraptor.vaas.ProviderConfiguration;
import br.com.caelum.vraptor.vaas.authentication.AuthProviders;

@ApplicationScoped
public class MusicJungleProviders implements ProviderConfiguration{

	@SuppressWarnings("unchecked")
	@Override
	public AuthProviders providers() {		
		return new AuthProviders(DBAuthProvider.class);
	}

}
