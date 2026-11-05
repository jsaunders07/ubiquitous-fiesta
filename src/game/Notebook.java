package game;

public class Notebook extends Item{
	private String notebookText;

	public Notebook(String name, String text) {
		super(name, false);
		notebookText = text;
	}

	@Override
	public void read() {
		Game.print(notebookText);
	}
}
