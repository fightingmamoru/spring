package com.mamoru.util;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import com.cronutils.validator.CronValidator;
import org.junit.Test;

import java.util.Locale;

public class CronUtilTest
{
	@Test
	public void test()
	{
		String cronStr = "*/45 * * * * *";

		CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
		CronParser cronParser = new CronParser(cronDefinition);
		CronDescriptor cronDescriptor = CronDescriptor.instance(Locale.US);

		String parseCronStr = cronDescriptor.describe(cronParser.parse(cronStr));

		System.out.println("[Result] " + parseCronStr);

		// check validate cron expression
		CronValidator cronValidator = new CronValidator(cronDefinition);

		boolean isValid = cronValidator.isValid("AAADSAD");

		System.out.println("[isValid] " + isValid);

		isValid = cronValidator.isValid(cronStr);

		System.out.println("[isValid] " + isValid);


	}
}