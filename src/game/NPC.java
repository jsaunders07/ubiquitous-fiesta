package game;

import javax.swing.*;

public class NPC {
	private String name;
	

	public NPC(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void say(String d) {
		Game.print(name.toUpperCase() + "\n" + d);
	}
	
	public void talk() {
		Game.print("You can't talk to " + name.toUpperCase() + ".");
	}
	
	public String getResponse(String[] dialogOptions) {
		int c = 1;
		String dialog = "";
		for (String i : dialogOptions) {
			dialog += c+") "+i+"\n";
			c++;
		}
		dialog += "Choose an option: ";
		return JOptionPane.showInputDialog(dialog, "Choose an option:");
	}
}
