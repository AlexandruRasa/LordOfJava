package LordOfJava;

public class Human extends Creature {

    private int courage;
    private int honor;

    public Human(double stamina, double speed, int agility, String nickName, int courage, int honor) {
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
        super.powerUp(stamina + (this.courage * this.honor), speed, agility);
    }

    @Override
    public String toString() {
        return "Human:\n" +
                super.toString() +
                "\nCourage: " + this.courage +
                "\nHonor: " + this.honor;
    }
}
