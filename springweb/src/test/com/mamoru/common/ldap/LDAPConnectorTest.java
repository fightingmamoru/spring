package com.mamoru.common.ldap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml",
		"classpath*:spring/springwebServlet/servlet-context-mapper.xml"})
public class LDAPConnectorTest
{
	private static Logger LOGGER = LogManager.getLogger(LDAPConnectorTest.class);

	@Test
	public void checkLdapConnection()
	{
		String url = "ldap://localhost:10389";
		String baseDN = "ou=system";
		String user = "uid=admin,ou=system";
		String password = "secret";
		String filter = "(&(objectclass=group))";

		boolean result = LDAPConnector.getInstance().connectionCheck(url, user, password, baseDN, filter);

		LOGGER.debug("[LDAP Connect Test] result - " + result);
	}
}