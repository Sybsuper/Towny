package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.inviteobjects.PlayerJoinTownInvite;
import org.bukkit.Bukkit;
import org.bukkit.Warning;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is no longer called.
 * @deprecated since 0.99.6.4 use {@link com.palmergames.bukkit.towny.event.town.TownInvitePlayerEvent} instead.
 */
@Deprecated
@Warning(reason = "Event is no longer called. Event has been moved to the com.palmergames.bukkit.towny.event.town package.")
public class TownInvitePlayerEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private final PlayerJoinTownInvite invite;

	@Override
	public HandlerList getHandlers() {

		return handlers;
	}

	public static HandlerList getHandlerList() {

		return handlers;
	}

	public TownInvitePlayerEvent(PlayerJoinTownInvite invite) {
		super(!Bukkit.getServer().isPrimaryThread());
		this.invite = invite;
	}

	/**
	 * @return - Object containing the directsender(Mayor), indirectsender(Town) and receiver of an invite.
	 */
	public PlayerJoinTownInvite getInvite() {
		return invite;
	}

}