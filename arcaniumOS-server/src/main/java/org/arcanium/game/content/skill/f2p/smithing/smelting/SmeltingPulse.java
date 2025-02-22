package org.arcanium.game.content.skill.f2p.smithing.smelting;

import org.arcanium.game.content.skill.SkillPulse;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.entity.player.info.portal.Perks;
import org.arcanium.game.node.entity.player.link.diary.DiaryType;
import org.arcanium.game.node.item.Item;
import org.arcanium.game.world.update.flag.context.Animation;
import org.arcanium.game.world.update.flag.context.Graphics;
import org.arcanium.tools.RandomFunction;
import org.arcanium.tools.StringUtils;

/**
 * Represents the pulse used to smelt.
 * @author 'Vexia
 */
public class SmeltingPulse extends SkillPulse<Item> {

    /**
     * The ring of forging item.
     */
    private static final Item RING_OF_FORGING = new Item(2568);

    /**
     * Represents the bar to make.
     */
    private final Bar bar;

    /**
     * Represents if using the super heat spell.
     */
    private final boolean superHeat;

    /**
     * The ticks passed.
     */
    private int ticks;

    /**
     * Represents the amount to produce.
     */
    private int amount;

    /**
     * Constructs a new {@code SmeltingPulse} {@code Object}.
     * @param player the player.
     * @param node the node.
     * @param bar the bar.
     * @param amount the amount.
     */
    public SmeltingPulse(Player player, Item node, Bar bar, int amount) {
	super(player, node);
	this.bar = bar;
	this.amount = amount;
	this.superHeat = false;
    }

    /**
     * Constructs a new {@code SmeltingPulse} {@code Object}.
     * @param player the player.
     * @param node the node.
     * @param bar the bar.
     * @param amount the amount.
     * @param heat the heat.
     */
    public SmeltingPulse(Player player, Item node, Bar bar, int amount, boolean heat) {
	super(player, node);
	this.bar = bar;
	this.amount = amount;
	this.superHeat = heat;
	this.resetAnimation = false;
    }

    @Override
    public boolean checkRequirements() {
	player.getInterfaceManager().closeChatbox();
	if (bar == null || player == null) {
	    return false;
	}
	if (bar == Bar.BLURITE && !player.getQuestRepository().isComplete("The Knight's Sword")) {
	    return false;
	}
	if (player.getSkills().getLevel(Skills.SMITHING) < bar.getLevel()) {
	    player.getPacketDispatch().sendMessage("You need a Smithing level of at least " + bar.getLevel() + " in order to smelt " + bar.getProduct().getName().toLowerCase().replace("bar", "") + ".");
	    player.getInterfaceManager().closeChatbox();
	    return false;
	}
	for (Item item : bar.getOres()) {
	    if (!player.getInventory().contains(item.getId(), item.getAmount())) {
		player.getPacketDispatch().sendMessage("You do not have the required ores to make this bar.");
		return false;
	    }
	}
	return true;
    }

    @Override
    public void animate() {
	if (ticks == 0 || ticks % 5 == 0) {
	    if (superHeat) {
		player.visualize(Animation.create(723), new Graphics(148, 96));
	    } else {
		player.animate(Animation.create(899));
	    }
	}
    }

    @Override
    public boolean reward() {
	if (!superHeat && ++ticks % 5 != 0) {
	    return false;
	}
	if (!superHeat) {
	    player.getPacketDispatch().sendMessage("You place the required ores and attempt to create a bar of " + StringUtils.formatDisplayName(bar.toString().toLowerCase()) + ".");
	}
	for (Item i : bar.getOres()) {
	    if (!player.getInventory().remove(i)) {
		return true;
	    }
	}
	if (success(player)) {
	    int amt = player.getInventory().freeSlots() != 0 && player.getAchievementDiaryManager().getDiary(DiaryType.VARROCK).getLevel() != -1 /*&& player.getAchievementDiaryManager().checkSmithReward(bar)*/ && RandomFunction.random(100) <= 10 ? 2 : 1;
	    if (amt != 1) {
		player.sendMessage("Throught the powers of your varrock armour you recieve double the reward.");
	    }
	    player.getInventory().add(new Item(bar.getProduct().getId(), amt));
	    player.getSkills().addExperience(Skills.SMITHING, bar.getExperience(), true);
	    if (!superHeat) {
		player.getPacketDispatch().sendMessage("You retrieve a bar of " + bar.getProduct().getName().toLowerCase().replace(" bar", "") + ".");
	    }
	} else {
	    player.getPacketDispatch().sendMessage("The ore is too impure and you fail to refine it.");
	}
	amount--;
	return amount < 1;
    }

    /**
     * Checks if the player has a ring of forging.
     * @param player the player.
     * @return {@code True} if so.
     */
    public boolean hasForgingRing(Player player) {
	return player.getEquipment().containsItem(RING_OF_FORGING);
    }

    /**
     * Checks if the forging is a succes.
     * @param player the player.
     * @return {@code True} if success.
     */
    public boolean success(Player player) {
	if (bar == Bar.IRON && !superHeat) {
	    if (hasForgingRing(player) && bar == Bar.IRON) {
		if (!player.getDetails().getShop().hasPerk(Perks.UNBREAKABLE_FORGE)) {
		    int uses = player.getSavedData().getGlobalData().getForgingUses();
		    player.getSavedData().getGlobalData().setForgingUses(uses + 1);
		    if (uses > 139) {
			if (!player.getDetails().getShop().hasPerk(Perks.UNBREAKABLE_FORGE)) {
			    player.getEquipment().remove(RING_OF_FORGING);
			}
			player.getSavedData().getGlobalData().setForgingUses(0);

		    }
		}
		return true;
	    } else {
		return RandomFunction.getRandom(100) <= (player.getSkills().getLevel(Skills.SMITHING) >= 45 ? 80 : 50);
	    }
	}
	return true;
    }

}
