package LordOfJava;

public abstract class Creature implements ICreature, Comparable<Creature> {

    private Abilities abilities;
    private String nickName;

    public Creature(double stamina, double speed, int agility,
                    String nickName)  {
        this.abilities = new Abilities(stamina,speed,agility);
        this.nickName = nickName;
    }

    @Override
    public String getNickName() {
        return this.nickName;
    }

    @Override
    public void setNickName(String nickname) {
        this.nickName = nickname;
    }


    @Override
    public void powerUp(double stamina, double speed, int agility) {
        this.abilities.update(stamina,speed,agility);
    }

    public double characterPower() {
        return this.abilities.getAgility() + this.abilities.getStamina() + this.abilities.getSpeed();
    }

    @Override
    public int compareTo(Creature o) {
        if (this.abilities.compareTo(o.abilities) < 0) {
            return -1;
        } else if (this.abilities.compareTo(o.abilities) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Creature:\n" +
                "\nNickName:" + nickName +
                this.abilities.toString();
    }
}
