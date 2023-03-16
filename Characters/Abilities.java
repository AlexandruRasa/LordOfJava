package LordOfJava;
public class Abilities implements Comparable<Abilities> {

    private double stamina;
    private double speed;
    private int agility;

    public Abilities(double stamina, double speed, int agility) {
        this.stamina = stamina;
        this.speed = speed;
        this.agility = agility;
    }

    public double getStamina() {
        return stamina;
    }

    public double getSpeed() {
        return speed;
    }

    public int getAgility() {
        return agility;
    }

    public void update(double stamina, double speed, int agility) {
        this.stamina += stamina;
        this.speed += speed;
        this.agility += agility;
    }

    @Override
    public int compareTo(Abilities o) {
        if (this.stamina < o.stamina) {
            return -1;
        } else if (this.stamina > o.stamina) {
            return 1;
        }
        if (this.agility < o.agility) {
            return -1;
        } else  if (this.agility > o.agility) {
            return 1;
        }
        if (this.speed < o.speed) {
            return -1;
        } else  if (this.speed > o.speed) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Abilities:" +
                "\nStamina: " + stamina +
                "\nSpeed: " + speed +
                "\nAgility:" + agility;
    }
}
