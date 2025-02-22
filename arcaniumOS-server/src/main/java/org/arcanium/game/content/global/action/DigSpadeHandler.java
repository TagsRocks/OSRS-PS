package org.arcanium.game.content.global.action;

import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.system.task.Pulse;
import org.arcanium.game.world.GameWorld;
import org.arcanium.game.world.map.Location;
import org.arcanium.game.world.update.flag.context.Animation;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles digging with a spade.
 * @author Emperor
 */
public final class DigSpadeHandler {

    /**
     * The digging actions.
     */
    private static final Map<Location, DigAction> ACTIONS = new HashMap<>();

    /**
     * The digging animation.
     */
    public static final Animation ANIMATION = Animation.create(830);

    /**
     * Handles a digging action.
     * @param player The player.
     * @return {@code True} if the action got handled.
     */
    public static boolean dig(final Player player) {
	final DigAction action = ACTIONS.get(player.getLocation());
	player.animate(ANIMATION);
	player.lock(1);
	if (action != null) {
	    GameWorld.submit(new Pulse(1, player) {
		@Override
		public boolean pulse() {
		    action.run(player);
		    return true;
		}
	    });
	    return true;
	}
	return false;
    }

    /**
     * Registers a new digging action.
     * @param location The location to dig on.
     * @param action The action.
     * @return {@code True} if the action got registered.
     */
    public static boolean register(Location location, DigAction action) {
	if (ACTIONS.containsKey(location)) {
	    System.err.println("Already contained dig action for location " + location + ".");
	    return false;
	}
	ACTIONS.put(location, action);
	return true;
    }
}