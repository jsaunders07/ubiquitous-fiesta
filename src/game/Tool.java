package game;

public class Tool extends Item {
	private boolean usedTool;
	Room roomToBeUsedOn = null;

	public Tool(String name, Room usableRoom) {
		super(name, false);
		usedTool = false;
		roomToBeUsedOn = usableRoom;
	}

	@Override
	public void use() {
		int i = 0;
		for (Room a : Game.getCurrentRoom().getAllExits()) {
			if (!(a == null) && a.getName().equals(roomToBeUsedOn.getName())) {
				if (usedTool) {
					Game.print("You already unlocked the "+roomToBeUsedOn.getName());
					return;
				} else {
					Game.getCurrentRoom().getExit(i).setLocked(false);
					usedTool = true;
					Game.print("Successfully unlocked the "+roomToBeUsedOn.getName()+"!");
					return;
				}
			}
			i++;
		}
		Game.print("You don't see any way to use the tool…");
	}
}
