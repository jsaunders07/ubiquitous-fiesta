package game;
import java.util.HashMap;

import java.io.Serializable;

public class Room implements Serializable {
	private String name = "";
	private Room[] exitDirs = new Room[6];
	private HashMap<String, Item> roomItems = new HashMap<>();
	
	// init class
	public Room(String roomName) {
		name = roomName;
		World.addToRoomMap(roomName, this);
	}
	// set methods
	public void setName(String newName) {
		name = newName;
	}
	
	public void setDesc(String newDesc) {
		Game.roomDescs.replace(name, newDesc);
	}
	
	public void addExit(int roomIndex, Room newRoom) {
		exitDirs[roomIndex] = newRoom;
	}
	
	public void addRoomItem(Item newItem) {
		roomItems.put(newItem.getName(), newItem);
	}
	
	public void removeRoomItem(String itemName) {
		roomItems.remove(itemName);
	}
	//get methods
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return Game.roomDescs.get(name);
	}
	
	public Room getExit(int roomIndex) {
		return exitDirs[roomIndex];
	}
	
	public Item getItem(String itemName) {
		return roomItems.get(itemName);
	}
	
	public HashMap<String, Item> getItemsHash() {
		return roomItems;
	}
	// toString
	public String toString() {
		return "Name: "+name+"\nDescription: "+Game.roomDescs.get(name);
	}
}
