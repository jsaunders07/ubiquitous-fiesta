package game;

public class Fred extends NPC{
	private boolean codeGotten = false;
	
	public Fred() {
		super("fred");
	}
	
	public void talk() {
		say("What do you want, loser?");
		String[] responses = { "Nothing! Sorry to bother you!", "(Cast Necrotic Curse on Fred)", "Hey, buddy, got the safe combination?" };
		int option0 = Integer.parseInt(getResponse(responses));
		switch (option0) {
		case 1:
			say("Yeah scurry away little guy.");
			break;
		case 2:
			say("Heh, idiot, everyone knows necrotic curses only affect you once you're dead.\n Try harder.");
			break;
		case 3:
			if (codeGotten == false) {
				say("Yeah. If you want it, gimmie $20");
			} else {
				say("I already gave you that code, go away.");
			}
			break;
		default:
			say("You don't make any sense, get away from me.");
		}
	}
	
	@Override
	public void give(Item a) {
		if (codeGotten == false) {
			Game.addInventoryItem(new Item("safecode", false));
			say("Thanks, poser, here's the combination.");
			Game.removeInventoryItem(Game.findTool("Money".split(" ")));
			Game.printAdd("You recieve the safe code as a lovely gift from your best pal Fred.");
		} else {
			say("Free money? Sure, I'll take it.");
			Game.removeInventoryItem(Game.findTool("Money".split(" ")));
		}
	}
}
