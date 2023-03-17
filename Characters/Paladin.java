package LordOfJava;

public class Paladin extends Creature {

    private final int courage;
    private final int honor;

    public Paladin(double stamina, double speed, int agility, String nickName, int courage, int honor) {
        super(stamina, speed, agility, nickName);
        this.courage = courage;
        this.honor = honor;
    }

    public int getCourage() {
        return courage;
    }

    public int getHonor() {
        return honor;
    }

    @Override
    public double characterPower() {
        return super.characterPower() + (this.courage + this.honor);
    }

    @Override
    public void powerUp(double stamina, double speed, int agility) {
        super.powerUp(stamina + (getCourage() * getHonor()), speed, agility);
    }

    @Override
    public String toString() {
        return "Paladin:\n" +
                super.toString() +
                "\nCourage: " + this.courage +
                "\nHonor: " + this.honor;
    }
}
