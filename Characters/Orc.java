package LordOfJava;

public class Orc extends Creature {

    private int strength;
    private int summons;

    public Orc(double stamina, double speed, int agility, String nickName, int strength, int summons) {
        super(stamina, speed, agility, nickName);
        this.strength = strength;
        this.summons = summons;
    }

    public int getStrength() {
        return strength;
    }

    public int getSummons() {
        return summons;
    }

    @Override
    public double characterPower() {
        return super.characterPower() + (this.strength * this.summons);
    }

    @Override
    public void powerUp(double stamina, double speed, int agility) {
        super.powerUp(5 * stamina + (this.strength * this.summons), speed / 2, agility / 2);
    }

    @Override
    public String toString() {
        return "Orc:\n" +
                super.toString() +
                "\nStrength:" + this.strength +
                "\nSummons:" + this.summons;
    }
}
