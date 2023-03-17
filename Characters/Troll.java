package LordOfJava;

public class Troll extends Creature {

    private final int strength;
    private final int summons;

    public Troll(double stamina, double speed, int agility, String nickName, int strength, int summons) {
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
        return super.characterPower() + (getStrength() * getSummons());
    }

    @Override
    public void powerUp(double stamina, double speed, int agility) {
        super.powerUp(5 * stamina + (getStrength() * getSummons()), speed / 2, agility / 2);
    }

    @Override
    public String toString() {
        return "Troll:\n" +
                super.toString() +
                "\nStrength:" + this.strength +
                "\nSummons:" + this.summons;
    }
}
