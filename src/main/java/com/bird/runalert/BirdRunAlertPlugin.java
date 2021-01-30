package com.bird.runalert;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Bird Run Alert"
)
public class BirdRunAlertPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BirdRunAlertConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Bird Run Alert started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Bird Run Alert stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Bird Run Alert says " + config.greeting(), null);
		}
	}

	@Provides
	BirdRunAlertConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BirdRunAlertConfig.class);
	}
}
