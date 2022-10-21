package com.bird.runalert;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.junit.Assert;
import org.junit.Test;

public class BirdRunAlertPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(BirdRunAlertPlugin.class);
		RuneLite.main(args);
	}

	@Test
	public void getPercentileBetweenTwoNumbers() {
		double min = 50;
		double max = 100;
		double percentage = 50;

		double expected = 75;
		Assert.assertEquals(expected, (percentage/max)*min + min, 0);
	}
}