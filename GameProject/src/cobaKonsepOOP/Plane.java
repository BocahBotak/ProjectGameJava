package cobaKonsepOOP;

public class Plane extends Character {

	private int gold;

	public Plane(int hp, int damage, int x, int y) {
		super(hp, damage, x, y);
		this.gold = 0;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

}
