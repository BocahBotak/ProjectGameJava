package cobaKonsepOOP;

public class Character {

	protected int hp;
	protected int damage;
	protected int x;
	protected int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Character(int hp, int damage, int x, int y) {
		super();
		this.hp = hp;
		this.damage = damage;
		this.x = x;
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
