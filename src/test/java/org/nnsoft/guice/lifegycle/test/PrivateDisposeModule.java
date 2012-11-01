package org.nnsoft.guice.lifegycle.test;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class PrivateDisposeModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IPrivateDisposeInterface.class).to(PrivateDisposeClass.class).in(Singleton.class);		
	}

}
