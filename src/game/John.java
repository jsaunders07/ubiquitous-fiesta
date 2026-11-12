package game;

public class John extends NPC {
	
	public John() {
		super("john"); // NOTE: name must be lower-case
	}

	@Override
	public void talk() {
		say("Yo what is up dude");
		String[] responses = { 
				"Who the hell are you", 
				"How do I get out of here?", 
				"Help me" 
				};
		int option = Integer.parseInt(getResponse(responses));
		switch (option) {
		case 1:
			say("I'm John, I'm lowkey chilling");
			break;
		case 2:
			say("I don't know, I've been stuck here for like 800 years");
			break;
		case 3:
			say("No, I'm lazy");
			break;
		default:
			say("What are you talking about dude");
		}
	}
}