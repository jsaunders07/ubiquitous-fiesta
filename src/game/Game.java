package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game {

	private static Room currentRoom = World.buildWorld();
	private static ArrayList<Item> itemsHeld = new ArrayList<>();
	public static HashMap<String, String> roomDescs = new HashMap<>();
	public static Gui mainGui = new Gui("Game Window");

	public static void readAllDesc() {
		try {
			Scanner fileScan = new Scanner(new File("roomDesc.txt"));
			String roomName = fileScan.nextLine();
			String roomDescription = "";
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				if (line.equals("#")) {
					roomDescs.put(roomName, roomDescription);
					roomName = fileScan.nextLine();
					roomDescription = "";
				} else {
					roomDescription += (line + "\n");
				}

			}
			roomDescs.put(roomName, roomDescription);
			fileScan.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void move(String command) {
		Room tempRoom = null;

		switch (command) {
		case "east":
			tempRoom = currentRoom.getExit(0);
			break;
		case "west":
			tempRoom = currentRoom.getExit(1);
			break;
		case "north":
			tempRoom = currentRoom.getExit(2);
			break;
		case "south":
			tempRoom = currentRoom.getExit(3);
			break;
		case "up":
			tempRoom = currentRoom.getExit(4);
			break;
		case "down":
			tempRoom = currentRoom.getExit(5);
			break;
		default:
			Game.print("That is not a valid input!");
			break;
		}

		if (tempRoom == null) {
			Game.print("You cannot go in that direction.");
		} else if (tempRoom.getIsLocked()) {
			Game.print("The " + tempRoom.getName() + " is locked!");
		} else {
			currentRoom = tempRoom;
			Game.print("");
		}

	}

	public static void go(String[] direction) {
		for (int i = 0; i < direction.length; i++) {
			switch (direction[i]) {
			case "east":
				Game.move(direction[i]);
				break;
			case "west":
				Game.move(direction[i]);
				break;
			case "north":
				Game.move(direction[i]);
				break;
			case "south":
				Game.move(direction[i]);
				break;
			case "up":
				Game.move(direction[i]);
				break;
			case "down":
				Game.move(direction[i]);
				break;
			}
		}
	}

	public static void takeItem(Room room, String[] itemSaid) {
		if (room.getItemsHash().isEmpty()) {
			mainGui.setActionDesc("No item to take.");
			return;
		}
		for (int i = 0; i < itemSaid.length; i++) {
			if (room.getItemsHash().containsKey(itemSaid[i])) {
				if (room.getItem(itemSaid[i]).isHeavy()) {
					mainGui.setActionDesc("That item is too heavy to carry with you!");
					return;
				}
				mainGui.setActionDesc("You obtained the " + itemSaid[i]);
				itemsHeld.add(room.getItem(itemSaid[i]));
				room.removeRoomItem(itemSaid[i]);
				return;
			}
		}
		Game.print("No valid item name given.");
	}

	public static Room getCurrentRoom() {
		return currentRoom;
	}

	public static void saveGame() {
		try {
			File saveFile = new File("save0.sav"); // name the file yourself
			saveFile.createNewFile(); // creates a new file

			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));

			outStream.writeObject(currentRoom);
			outStream.writeObject(World.getRoomStati());
			outStream.writeObject(itemsHeld);
			outStream.close();
		} catch (IOException e) {
			System.out.println("uh oh it didnt work try again");
		}
	}

	public static void loadGame() {
		try {
			File saveFile = new File("save0.sav");

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile));

			currentRoom = (Room) inputStream.readObject();
			World.loadRoomMap((HashMap<String, Room>) inputStream.readObject());
			itemsHeld = (ArrayList<Item>) inputStream.readObject();
			inputStream.close();
		} catch (IOException e) {
			System.out.println("loading file no work: ioexception");
		} catch (ClassNotFoundException e) {
			System.out.println("loading file no work: class not found");
		}
	}

	public static Item findTool(String[] playerIn) {
		for (String x : playerIn) {
			for (Item a : itemsHeld) {
				if (a.getName().equals(x)) {
					return a;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		runGame();
	}

	public static void print(Object obj) {
		mainGui.setActionDesc(obj.toString());
	}

// the thing that runs the whole thing
	public static void runLogic() {
		boolean commandUsed = false;
		String[] playerInput = mainGui.getInput().toLowerCase().split(" ");

		for (int i = 0; i < playerInput.length; i++) {
			switch (playerInput[i]) {
			case "go":
				commandUsed = true;
				Game.go(playerInput);
				break;
			case "exit":
				Game.print("Bye Bye!");
				System.exit(0);
				break;
			case "take":
				commandUsed = true;
				takeItem(currentRoom, playerInput);
				break;
			case "i":
				commandUsed = true;
				if (itemsHeld.isEmpty()) {
					Game.print("You are not holding anything.");
				} else {
					String displayItems = "";
					for (int x = 0; x < itemsHeld.size(); x++) {
						displayItems += itemsHeld.get(x).toString() + "\n";
					}
					Game.print("Items held: \n" + displayItems);
				}
			case "save":
				saveGame();
				break;
			case "load":
				loadGame();
				break;
			case "use":
				Item actionTool = findTool(playerInput);
				actionTool.use();
			}
		}

		mainGui.setInput("");
	}

// end of big thing
	public static void runGame() {
		readAllDesc();

		while (true) {
			mainGui.setRoomName(currentRoom.getName());
			mainGui.setRoomDesc(currentRoom.getDesc());
			mainGui.runOnEnter(mainGui.textInput);
		}
	}
}
