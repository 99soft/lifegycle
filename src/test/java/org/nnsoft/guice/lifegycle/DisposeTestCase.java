package org.nnsoft.guice.lifegycle;

import static com.google.inject.Guice.createInjector;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.nnsoft.guice.lifegycle.Dispose;
import org.nnsoft.guice.lifegycle.DisposeModule;
import org.nnsoft.guice.lifegycle.Disposer;

import com.google.inject.Inject;

public final class DisposeTestCase
{

    @Inject
    private Disposer disposer;

    private boolean disposeInvoked = false;

    public void setDisposer( Disposer disposer )
    {
        this.disposer = disposer;
    }

    @Dispose
    public void close()
    {
        disposeInvoked = true;
    }

    @Before
    public void setUp()
    {
        createInjector( new DisposeModule() )
        .getMembersInjector( DisposeTestCase.class )
        .injectMembers( this );
    }

    @Test
    public void disposeMethodInvoked()
    {
        disposer.dispose();
        assertTrue( disposeInvoked );
    }

}
