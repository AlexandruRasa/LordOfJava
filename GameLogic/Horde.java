package LordOfJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Horde <C extends Creature> {

    private HashMap<String, C> army;
    private int power;
    private long resources;
    private long score;
    private boolean scout;

    public Horde() {
        this.army = new HashMap<>();
        this.power = 0;
        this.resources = 30;
    }

    public long getScore() {
        return score;
    }

    public boolean isScout() {
        return scout;
    }

    public void setScout(boolean scout) {
        this.scout = scout;
    }

    public void setResources(long resources) {
        this.resources = resources;
    }

    public long getResources() {
        return resources;
    }

    public int size() {
        return this.army.size();
    }

    public void addNewCitizen(String address, C creature) {
        if (address != null && creature != null) {
            this.army.put(address,creature);
            System.out.println("Soldier added to the army.");
        } else {
            System.out.println("Soldier failed the training.");
        }
    }

    public int estimatePowerOfArmy() {
        ArrayList<C> result = new ArrayList<>(this.army.values());
        for (C x: result) {
            this.power += x.characterPower();
        }
        return this.power;
    }

    public void gatherResources() {
        for (int i = 0; i < this.army.size(); i++) {
            this.resources += 10;
        }
    }

    public void updateScore(long amount) throws NumberFormatException {
        if (amount > 0) {
            this.score += amount;
        } else {
            throw new NumberFormatException("Expecting positive bonus value, got: " + amount);
        }
    }

    public ArrayList<C> getAllCitizensToFight() {
        ArrayList<C> allAligned = new ArrayList<>(army.values());
        Collections.sort(allAligned);
        return allAligned;
    }

    @Override
    public String toString() {
        ArrayList<C> result = new ArrayList<>(this.army.values());
        for (C x: result) {
            System.out.println(x);
            System.out.println("\n");
        }
        return "---";
    }
}
