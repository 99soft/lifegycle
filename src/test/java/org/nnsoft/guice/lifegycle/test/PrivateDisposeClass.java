package org.nnsoft.guice.lifegycle.test;

import org.nnsoft.guice.lifegycle.Dispose;

class PrivateDisposeClass implements IPrivateDisposeInterface {

	private boolean disposeCalled = false;
	
	public boolean getDisposedCalled()
	{
		return this.disposeCalled;
	}
	
	@Dispose
	public void close()
	{
		this.disposeCalled = true;
	}
}
