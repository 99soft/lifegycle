package org.nnsoft.guice.lifegycle;

import static com.google.inject.Guice.createInjector;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.nnsoft.guice.lifegycle.test.IPrivateDisposeInterface;
import org.nnsoft.guice.lifegycle.test.PrivateDisposeModule;

import com.google.inject.AbstractModule;
import com.google.inject.ConfigurationException;
import com.google.inject.Inject;

public final class PrivateDisposeTestCase
{
    @Inject
    private IPrivateDisposeInterface privateDisposeInterface;    
    
    @Inject
    private Disposer disposer;

    
    @Before
    public void setUp()
    {
        createInjector( new DisposeModule(), new PrivateDisposeModule() )
        .getMembersInjector( PrivateDisposeTestCase.class )
        .injectMembers( this );
    }

    @Test
    public void disposeMethodInvoked()
    {
        disposer.dispose();
        assertTrue( privateDisposeInterface.getDisposedCalled() );
    }    
}
