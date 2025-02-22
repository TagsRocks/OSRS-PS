package org.arcanium.game.content.global.quest.impl.member;

import org.arcanium.game.component.Component;
import org.arcanium.game.content.global.quest.Quest;
import org.arcanium.game.content.global.quest.QuestState;
import org.arcanium.game.content.skill.Skills;
import org.arcanium.game.node.entity.player.Player;
import org.arcanium.game.node.item.GroundItemManager;
import org.arcanium.game.node.item.Item;

/**
 * Represents the <b>Quest</b> priest in peril.
 * @author 'Vexia
 */
public class PriestInPeril extends Quest {

    /**
     * The name of this quest.
     */
    public static final String NAME = "Priest in Peril";

    /**
     * Constructs a new {@code PriestInPeril} {@code Object}.
     * @param player The player to construct the class for.
     */
    public PriestInPeril(final Player player) {
	super(player);
    }

    @Override
    public void update() {
	for (int i = 0; i < 256; i++) {
	    player.getPacketDispatch().sendString("", 275, i);/*
							       * clears the
							       * screen of text
							       * allowing string
							       * drawing.
							       */
	}
	player.getPacketDispatch().sendString("<col=8A0808>Priest in Peril</col>", 275, 2);
	switch (stage) {
	case 0:
	    player.getPacketDispatch().sendString("<col=08088A>I can start this quest by speaking to <col=8A0808>King Roald</col> <col=08088A>in <col=8A0808>Varrock", 275, 4);
	    player.getPacketDispatch().sendString("<col=8A0808>Palace</col>", 275, 5);
	    player.getPacketDispatch().sendString("<col=08088A>I must be able to defeat a <col=8A0808>level 30 enemy</col>", 275, 7);
	    break;
	case 10:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<col=8A0808>Drezel</col> <col=08088A>lives in a <col=8A0808>temple</col> <col=08088A>to the east of Varrock Palace. I", 275, 7);
	    player.getPacketDispatch().sendString("<col=08088A>should head there and <col=8A0808>investigate</col> <col=08088A>what's happend to him", 275, 8);
	    break;
	case 11:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<col=08088A>He told me that there was an annoying <col=8A0808>dog</col> <col=08088A>below the", 275, 8);
	    player.getPacketDispatch().sendString("<col=08088A>temple, and has asked me to <col=8A0808>kill it</col> <col=08088A>for him.", 275, 9);
	    break;
	case 12:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<col=08088A>I should tell <col=8A0808>King Roald <col=08088A>everything's fine with <col=8A0808>Drezel <col=08088A>now I", 275, 11);
	    player.getPacketDispatch().sendString("<col=08088A>have killed that <col=8A0808>dog <col=08088A>for him, and claim my <col=8A0808>reward.", 275, 12);
	    break;
	case 13:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<col=08088A>I must return to the <col=8A0808>temple <col=08088A>and find out what happend to", 275, 13);
	    player.getPacketDispatch().sendString("<col=08088A>the real <col=8A0808>Drezel<col=08088A>, or the King will have me executed!", 275, 14);
	    break;
	case 14:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<col=08088A>I need to find the <col=8A0808>key</col> <col=08088A>to his cell and free him!", 275, 15);
	    break;
	case 15:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<str>I used a key from the monument to open the cell door", 275, 14);
	    player.getPacketDispatch().sendString("<col=08088A>but I still have to do something about that <col=8A0808>vampire", 275, 15);
	    break;
	case 16:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<str>I used a key from the monument to open the cell door and", 275, 14);
	    player.getPacketDispatch().sendString("<str>used Holy Water to trap the vampire in his coffin.", 275, 15);
	    player.getPacketDispatch().sendString("<col=08088A>I should speak to <col=8A0808>Drezel <col=08088A>again.", 275, 16);
	    break;
	case 17:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<str>I used a key from the monument to open the cell door and", 275, 14);
	    player.getPacketDispatch().sendString("<str>used Holy Water to trap the vampire in his coffin.", 275, 15);
	    player.getPacketDispatch().sendString("<col=08088A>I should head downstairs to the <col=8A0808>monument <col=08088A>like <col=8A0808>Drezel", 275, 16);
	    player.getPacketDispatch().sendString("<col=08088A>asked me to, and asses what <col=08088A>damage <col=08088A>has been done.", 275, 17);
	    break;
	case 18:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<str>I used a key from the monument to open the cell door and", 275, 14);
	    player.getPacketDispatch().sendString("<str>used Holy Water to trap the vampire in his coffin.", 275, 15);
	    player.getPacketDispatch().sendString("<str>I followed Drezel downstairs only to find that the Salve", 275, 16);
	    player.getPacketDispatch().sendString("<str>had been contaminated and now needed purifying", 275, 17);
	    int amt = player.getGameAttributes().getAttribute("priest-in-peril:rune", 50);
	    player.getPacketDispatch().sendString("<col=08088A>I need to bring <col=8A0808>" + amt + " <col=08088A>rune essence to undo the damage", 275, 19);
	    player.getPacketDispatch().sendString("<col=08088A>done by the Zamorakians and <col=8A0808>purify the salve", 275, 20);
	    break;
	case 100:
	    player.getPacketDispatch().sendString("<str>I spoke to King Roald who asked me to investigate why his", 275, 4);
	    player.getPacketDispatch().sendString("<str>friend Priest Drezel has stopped communicating with him.", 275, 5);
	    player.getPacketDispatch().sendString("<str>I headed to the temple where Drezel lives, but it was all", 275, 6);
	    player.getPacketDispatch().sendString("<str>locked shut. I spoke through the locked door to Drezel.", 275, 7);
	    player.getPacketDispatch().sendString("<str>He told me that there was an annoying dog below the", 275, 8);
	    player.getPacketDispatch().sendString("<str>temple, and asked me to kill it, which I did easily.", 275, 9);
	    player.getPacketDispatch().sendString("<str>When I told Roald what I had done, he was furious. The", 275, 10);
	    player.getPacketDispatch().sendString("<str>person who told me to kill the dog wasn't Drezel at all!", 275, 11);
	    player.getPacketDispatch().sendString("<str>I returned to the temple and found the real Drezel locked", 275, 12);
	    player.getPacketDispatch().sendString("<str>in a makeshift cell upstairs, guarded by a vampire.", 275, 13);
	    player.getPacketDispatch().sendString("<str>I used a key from the monument to open the cell door and", 275, 14);
	    player.getPacketDispatch().sendString("<str>used Holy Water to trap the vampire in his coffin.", 275, 15);
	    player.getPacketDispatch().sendString("<str>I followed Drezel downstairs only to find that the Salve", 275, 16);
	    player.getPacketDispatch().sendString("<str>had been contaminated and now needed purifying", 275, 17);
	    player.getPacketDispatch().sendString("<str>I brought Drezel fifty rune essences and the", 275, 18);
	    player.getPacketDispatch().sendString("<str>contaminants were dissolved from the Salve, and Drezel", 275, 19);
	    player.getPacketDispatch().sendString("<str>Rewarded me for all of my help with an ancient holy weapon", 275, 20);
	    player.getPacketDispatch().sendString("<str>to fight with.", 275, 21);
	    player.getPacketDispatch().sendString("<col=FF0000>QUEST COMPLETE!", 275, 23);
	    break;
	}
    }

    @Override
    public String getName() {
	return NAME;
    }

    @Override
    public void finish() {
	player.getGameAttributes().removeAttribute("priest-in-peril:rune");
	player.getQuestRepository().update(player);
	player.getQuestRepository().incrementPoints(getQuestPoints());
	player.getConfigManager().sendVarp(101, player.getQuestRepository().getPoints());
	player.getInterfaceManager().open(new Component(277));
	for (int i = 8; i < 15; i++) {
	    player.getPacketDispatch().sendString("", 277, i);
	}
	player.getPacketDispatch().sendString("1 Quest Point", 277, 8);
	player.getPacketDispatch().sendString("1406 Prayer XP", 277, 9);
	player.getPacketDispatch().sendString("Wolfbane dagger", 277, 10);
	player.getPacketDispatch().sendString("Route to Canifis", 277, 11);
	if (!player.getInventory().add(new Item(2952, 1))) {
	    GroundItemManager.create(new Item(2952, 1), player.getLocation(), player);
	}
	player.removeAttribute("priest_in_peril:key");
	player.removeAttribute("priest-in-peril:rune");
	player.getSkills().addExperience(Skills.PRAYER, 1406);
	player.getPacketDispatch().sendItemZoomOnInterface(2952, 240, 277, 3);
	player.getInterfaceManager().closeChatbox();
	player.getPacketDispatch().sendString("You have completed Priest in Peril!", 277, 2);
	setStage(100);
	setState(QuestState.COMPLETED);
	player.getPacketDispatch().sendMessage("Congratulations! Quest complete!");
    }

    @Override
    public int[] getConfig() {
	if (state == QuestState.COMPLETED) {
	    return new int[] { 302, 100 };
	} else if (state == QuestState.STARTED) {
	    return new int[] { 302, 1 };
	} else {
	    return new int[] { 302, 0 };
	}
    }

    @Override
    public int getIndex() {
	return 99;
    }

    @Override
    public int getQuestPoints() {
	return 1;
    }
}
