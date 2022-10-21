package com.bird.runalert;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("birdrunalert")
public interface BirdRunAlertConfig extends Config
{
	@ConfigItem(
		keyName = "volume",
		name = "Volume control",
		description = "Volume control to set the volume of the alert"
	)
	default int volume() {
		return 50;
	}
}
