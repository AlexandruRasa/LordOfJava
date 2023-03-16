package LordOfJava;

public class Elf extends Creature {

    private int vision;
    private int spell;

    public Elf(double stamina, double speed, int agility, String nickName, int vision, int spell) {
        super(stamina, speed, agility, nickName);
        this.vision = vision;
        this.spell = spell;
    }

    public int getVision() {
        return vision;
    }

    public int getSpell() {
        return spell;
    }

    @Override
    public double characterPower() {
        return super.characterPower() + (this.vision + this.spell);
    }

    @Override
    public void powerUp(double stamina, double speed, int agility) {
        super.powerUp(stamina / 2, speed + (this.vision * this.spell), agility * 2);
    }

    @Override
    public String toString() {
        return "Elf:\n" +
                super.toString() +
                "\nVision:" + this.vision +
                "\nSpell:" + this.spell;
    }
}
