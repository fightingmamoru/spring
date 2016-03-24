package com.mamoru.common.ldap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class LDAPConnector
{
	private static Logger LOGGER = LogManager.getLogger(LDAPConnector.class);

	private static LDAPConnector ldapConnector = new LDAPConnector();

	public LDAPConnector()
	{

	}

	public static LDAPConnector getInstance()
	{
		return ldapConnector;
	}

	@PostConstruct
	public void init()
	{

	}

	public boolean connectionCheck( String url, String user, String password, String basicDN, String filter )
	{
		boolean result = false;
		Hashtable environment = new Hashtable();

		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, url);
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, user);
		environment.put(Context.SECURITY_CREDENTIALS, password);

		DirContext ctx = null;

		try
		{
			ctx = new InitialDirContext(environment);

			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			NamingEnumeration<SearchResult> namingEnumeration = ctx.search(basicDN, filter, searchControls);

			if ( namingEnumeration != null )
			{
				result = true;
			}
		}
		catch (NamingException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if ( ctx != null )
				{
					ctx.close();
				}
			}
			catch (NamingException e)
			{
				throw new RuntimeException(e);
			}
		}

		return result;
	}
}
