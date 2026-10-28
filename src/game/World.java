package game;

import java.util.HashMap;

public class World {
	private static HashMap<String, Room> roomMap = new HashMap<>();

	public static Room buildWorld() {
		
		Room livingRoom = new Room("Living Room");
		
		Room kitchen = new Room("Kitchen");
		
		Room bedroom = new Room("Bedroom");
		
		Room office = new Room("Office");
		
		Room attic = new Room("Attic");

		Room garage = new Room("Garage");
		
		livingRoom.addExit(1, office);
		livingRoom.addExit(4, bedroom);
		livingRoom.addExit(2, kitchen);
		livingRoom.addRoomItem(new Item("tool", false));
		livingRoom.addRoomItem(new Item("musicbox", false));
		livingRoom.addRoomItem(new Item("couch", true));
		
		office.addExit(0, livingRoom);
		
		kitchen.addExit(3, livingRoom);
		kitchen.addExit(1, garage);
		kitchen.addRoomItem(new Item("flashlight", false));
		kitchen.addRoomItem(new Item("knife", false));
		kitchen.addRoomItem(new Item("mysteriousorb", false));
		
		garage.addExit(0, kitchen);
		
		bedroom.addExit(5, livingRoom);
		bedroom.addExit(4, attic);
		bedroom.addRoomItem(new Item("officekey", false));
		bedroom.addRoomItem(new Item("bed", true));
		
		attic.addExit(5, bedroom);
		
		return livingRoom;
	}
	
	public static void addToRoomMap(String a, Room b) {
		roomMap.put(a, b);
	}
	
	public static void loadRoomMap(HashMap<String, Room> a) {
		roomMap = a;
	}
	
	public static HashMap<String, Room> getRoomStati() {
		return roomMap;
	}
	
	public static void main(String args[]) {
		Room currentRoom = buildWorld();
		System.out.println(currentRoom);
		currentRoom.setDesc("A modern living room with large sofas and a flat screen TV.");
		System.out.println(currentRoom);
		System.out.println(currentRoom.getExit(1));
	}
	
}
