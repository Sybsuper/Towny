package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.Warning;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is no longer called.
 * @deprecated since 0.99.6.4 use {@link com.palmergames.bukkit.towny.event.town.TownAddResidentEvent} instead.
 */
@Deprecated
@Warning(reason = "Event is no longer called. Event has been moved to the com.palmergames.bukkit.towny.event.town package.")
public class TownAddResidentEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    
    private final Resident resident;
    private final Town town;

    @Override
    public HandlerList getHandlers() {
    	
        return handlers;
    }
    
    public static HandlerList getHandlerList() {

		return handlers;
	}

    public TownAddResidentEvent(Resident resident, Town town) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.resident = resident;
        this.town = town;
    }

    /**
     *
     * @return the resident who has joined a town.
     */
    public Resident getResident() {
        return resident;
    }

    /**
     *
     * @return the town the resident has just joined.
     */
    public Town getTown() {
        return town;
    }

	/**
	 * If this event has been thrown by a resident starting a new town, the town
	 * will not have set their mayor yet. You should delay your EventHandler by 1
	 * tick if you need the mayor of the town in your EventHandler.
	 * 
	 * @return the Mayor of the town which has added a resident, or null if this
	 *         event has been thrown upon a resident creating a new town.
	 */
	@Nullable
	public Resident getMayor() {
		return town.hasMayor() ? town.getMayor() : null;
	}
}