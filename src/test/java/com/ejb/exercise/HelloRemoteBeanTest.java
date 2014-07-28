package com.ejb.exercise;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HelloRemoteBeanTest {

	private HelloRemote helloRemote;
	
	@Before
	public void lookupHelloRemote() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        helloRemote = (HelloRemote) context.lookup("ejb:/new-project-ejb-maven-1.0-SNAPSHOT/HelloRemoteBean!"
                + HelloRemote.class.getName());
	}
	
	@Test
	public void test() {
		String greetings = helloRemote.greet("Adrian");
		Assert.assertEquals("Hello Adrian", greetings);		
	}
	
}
