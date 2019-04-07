package cobaKonsepOOP;

public class Enemy extends Character {

	public Enemy(int hp, int damage, int x, int y) {
		super(hp, damage, x, y);
		this.isLive = true;
	}
	
	private boolean isLive;

	public boolean isLive() {
		return isLive;
	}
}
