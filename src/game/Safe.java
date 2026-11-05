package game;

public class Safe extends Item{
	private boolean openNess;
	private boolean spawnedNotebook;

	public Safe(String name) {
		super(name, true);
		openNess = false;
		spawnedNotebook = false;
	}

	@Override
	public void open() {
		if (!openNess) {
			if (!spawnedNotebook) {
				Game.addItemToCurrentRoom(new Notebook("notebook", "\"hello this is my journal\""));
			}
			spawnedNotebook = true;
			openNess = true;
			Game.print("Opened the safe.");
		} else {
			Game.print("The safe is already open!");
		}
	}
	
	@Override
	public void close() {
		if (openNess) {
			openNess = false;
			Game.print("Closed the safe.");
		} else {
			Game.print("The safe is already closed!");
		}
	}
}
