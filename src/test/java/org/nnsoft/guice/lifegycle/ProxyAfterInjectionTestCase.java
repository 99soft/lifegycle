package org.nnsoft.guice.lifegycle;

import com.google.inject.AbstractModule;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static com.google.inject.Guice.createInjector;
import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * {@code ProxyAfterInjectionTestCase} demonstrate a NPE with JDK proxies.
 *
 * @author <a href="mailto:binkley@alumni.rice.edu">B. K. Oxley (binkley)</a>
 */
public class ProxyAfterInjectionTestCase
{
    @Test
    public void shouldIgnoreProxiesInChildInjector()
    {
        final Cloneable proxy = (Cloneable) newProxyInstance(
                Cloneable.class.getClassLoader(),
                new Class[]{ Cloneable.class },
                new InvocationHandler()
                {
                    public Object invoke( final Object proxy, final Method method, final Object[] args )
                    {
                        return null;
                    }
                });

        createInjector( new AfterInjectionModule(), new AbstractModule()
        {
            @Override
            protected void configure()
            {
                bind( Cloneable.class ).toInstance( proxy );
            }
        } );
    }
}
