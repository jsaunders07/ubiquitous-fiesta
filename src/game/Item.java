package game;

import java.io.Serializable;

public class Item implements Serializable{

	private String name;
	private boolean heaviness;
	
	public Item(String newName, boolean isHeavy) {
		name = newName;
		heaviness = isHeavy;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isHeavy() {
		return heaviness;
	}
	
	public String toString() {
		return name;
	}
	
}
