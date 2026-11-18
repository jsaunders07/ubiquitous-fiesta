package game;

public class John extends NPC {
	private int convoNum;

	public John() {
		super("john"); // NOTE: name must be lower-case
		convoNum = 0;
	}

	@Override
	public void talk() {
		switch (convoNum) {
		case 0:
			say("Yo what is up dude");
			String[] responses = { "Who the hell are you", "How do I get out of here?", "Help me" };
			int option0 = Integer.parseInt(getResponse(responses));
			switch (option0) {
			case 1:
				say("I'm "+this.getName()+", I'm lowkey chilling");
				convoNum = 1;
				break;
			case 2:
				say("I don't know, I've been stuck here for like 800 years");
				convoNum = 2;
				break;
			case 3:
				say("No, I'm lazy");
				convoNum = 3;
				break;
			default:
				say("What are you talking about dude");
			}
			break;
		case 1:
			say("Are you back to chill with me?");
			String[] responses1 = { "Yea", "No", "Help me" };
			int option1 = Integer.parseInt(getResponse(responses1));
			switch (option1) {
			case 1:
				say("You're goated");
				convoNum = 1;
				break;
			case 2:
				say("I don't like you honestly");
				convoNum = 0;
				break;
			case 3:
				say("No, I'm lazy");
				convoNum = 3;
				break;
			default:
				say("What are you talking about dude");
			}
		case 2:
			say("Get anything done?");
			String[] responses2 = { "Yes, a lot actually", "No it's too hard", "Help me" };
			int option2 = Integer.parseInt(getResponse(responses2));
			switch (option2) {
			case 1:
				say("Good for you, I'm just gonna be chilling here");
				convoNum = 1;
				break;
			case 2:
				say("Too bad, get better");
				convoNum = 2;
				break;
			case 3:
				say("No, I'm lazy");
				convoNum = 3;
				break;
			default:
				say("What are you talking about dude");
			}
		case 3:
			say("You still need help?");
			String[] responses3 = { "No", "I've decided I'm changing your name to Geeple", "Help me" };
			int option3 = Integer.parseInt(getResponse(responses3));
			switch (option3) {
			case 1:
				say("Awesome I'm gonna be lowkey chilling in here");
				convoNum = 1;
				break;
			case 2:
				this.setName("geeple");
				say("Oh");
				convoNum = 0;
				break;
			case 3:
				say("Ok fine. Here's a fun little sticker since you want to be helped so badly.");
				Game.itemsHeld.add(new Item(this.getName()+"'s Fun Sticker", false));
				convoNum = 3;
				break;
			default:
				say("What are you talking about dude");
			}
		}
	}
}