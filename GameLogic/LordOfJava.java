package LordOfJava;

import java.util.ArrayList;

public class LordOfJava {

    private Parameters parameters;
    private Horde<Elf> elves;
    private Horde<Human> humans;
    private Horde<Orc> orcs;

    public LordOfJava(String OS, String gamePATH, String credentials) {
        this.parameters = new Parameters(OS, gamePATH, credentials);
        this.elves = new Horde<Elf>();
        this.humans = new Horde<Human>();
        this.orcs = new Horde<Orc>();
    }

    public void addCreature(Creature creature, String address) throws IllegalArgumentException {
        if (creature instanceof Elf &&
                this.elves.getResources() >= 30) {
            this.elves.updateScore(30);
            this.elves.setResources(this.elves.getResources() - 30);
            this.elves.addNewCitizen(address, (Elf) creature);
        } else if (creature instanceof Human &&
                this.humans.getResources() >= 15) {
            this.humans.updateScore(15);
            this.humans.setResources(this.humans.getResources() - 15);
            this.humans.addNewCitizen(address, (Human) creature);
        } else if (creature instanceof Orc &&
                this.orcs.getResources() >= 10) {
            this.orcs.updateScore(10);
            this.orcs.setResources(this.orcs.getResources() - 10);
            this.orcs.addNewCitizen(address, (Orc) creature);
        } else {
            throw new IllegalArgumentException("Creature type unknown: " + creature.getClass().getName());
        }
    }

    public int battle(int round, int option) {
        switch (round) {
            case 1:
                if (option == 1 && battleElvesHumans()) {
                    System.out.println("Elves are victorious.");
                    this.elves.setResources(this.elves.getResources() + 300);
                } else if (!battleElvesHumans()) {
                    System.out.println("Elves are defeated.");
                    this.elves.setResources(50);
                }
                if (option == 2 && this.battleElvesOrcs()) {
                    System.out.println("Elves are victorious.");
                    this.elves.setResources(this.elves.getResources() + 300);
                } else if (!battleElvesOrcs()) {
                    System.out.println("Elves are defeated.");
                    this.elves.setResources(50);
                }
                break;
            case 2:
                if (option == 1 && !battleElvesHumans()) {
                    System.out.println("Humans are victorious.");
                    this.humans.setResources(this.humans.getResources() + 300);
                } else if (battleElvesHumans()) {
                    System.out.println("Humans are defeated.");
                    this.humans.setResources(50);
                }
                if (option == 2 && battleHumansOrcs()) {
                    System.out.println("Humans are victorious.");
                    this.humans.setResources(this.humans.getResources() + 300);
                } else if (!battleHumansOrcs()) {
                    System.out.println("Humans are defeated.");
                    this.humans.setResources(50);
                }
                break;
            case 3:
                if (option == 1 && !battleElvesOrcs()) {
                    System.out.println("Orcs are victorious.");
                    this.orcs.setResources(this.orcs.getResources() + 300);
                } else if (battleElvesOrcs()) {
                    System.out.println("Orcs are defeated.");
                    this.orcs.setResources(50);
                }
                if (option == 2 && !battleHumansOrcs()) {
                    System.out.println("Orcs are victorious.");
                    this.orcs.setResources(this.orcs.getResources() + 300);
                } else if (battleHumansOrcs()) {
                    System.out.println("Orcs are defeated.");
                    this.orcs.setResources(50);
                }
                break;
            default:
                System.out.println("---");
        }
        return 0;
    }

    private boolean battleElvesHumans() {
        if (this.elves.size() < this.humans.size()) {
            return false;
        }
        if (this.elves.size() > this.humans.size()) {
            return true;
        }
        ArrayList<Elf> armyElves = this.elves.getAllCitizensToFight();
        ArrayList<Human> armyHumans = this.humans.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.elves.size(); i++) {
            int duelResult = armyElves.get(i).compareTo(armyHumans.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    private boolean battleElvesOrcs() {
        if (this.elves.size() < this.orcs.size()) {
            return false;
        }
        if (this.elves.size() > this.orcs.size()) {
            return true;
        }
        ArrayList<Elf> armyElves = this.elves.getAllCitizensToFight();
        ArrayList<Orc> armyOrcs = this.orcs.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.elves.size(); i++) {
            int duelResult = armyElves.get(i).compareTo(armyOrcs.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    private boolean battleHumansOrcs() {
        if (this.humans.size() < this.orcs.size()) {
            return false;
        }
        if (this.humans.size() > this.orcs.size()) {
            return true;
        }
        ArrayList<Human> armyHumans = this.humans.getAllCitizensToFight();
        ArrayList<Orc> armyOrcs = this.orcs.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.humans.size(); i++) {
            int duelResult = armyHumans.get(i).compareTo(armyOrcs.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    public void buyScout(int round) {
        if (round == 1 && this.elves.getResources() >= 50) {
            this.elves.setScout(true);
            this.elves.setResources(this.elves.getResources() - 50);
        } else if (round == 2 && this.humans.getResources() >= 50) {
            this.humans.setScout(true);
            this.humans.setResources(this.humans.getResources() - 50);
        } else if (round == 3 && this.orcs.getResources() >= 50) {
            this.orcs.setScout(true);
            this.orcs.setResources(this.orcs.getResources() - 50);
        }
    }

    public void scoutEnemyArmy(int round) {
        switch (round) {
            case 1:
                if (this.elves.isScout() && (this.elves.estimatePowerOfArmy() >= this.humans.estimatePowerOfArmy()
                        || this.elves.estimatePowerOfArmy() > this.orcs.estimatePowerOfArmy())) {
                    System.out.println("Elves army might be stronger than one of the enemy armies.");
                } else if (this.elves.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.elves.setScout(false);
                break;
            case 2:
                if (this.humans.isScout() && (this.humans.estimatePowerOfArmy() >= this.elves.estimatePowerOfArmy()
                        || this.humans.estimatePowerOfArmy() > this.orcs.estimatePowerOfArmy())) {
                    System.out.println("Humans army might be stronger than one of the enemy armies.");
                } else if (this.elves.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.humans.setScout(false);
                break;
            case 3:
                if (this.orcs.isScout() && (this.orcs.estimatePowerOfArmy() >= this.humans.estimatePowerOfArmy()
                        || this.orcs.estimatePowerOfArmy() > this.orcs.estimatePowerOfArmy())) {
                    System.out.println("Orcs army might be stronger than one of the enemy armies.");
                } else if (this.elves.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.orcs.setScout(false);
                break;
            default:
                System.out.println("---");
        }
    }

    public void gatherResources(int round) {
        if (round == 1) {
            this.elves.gatherResources();
        } else if (round == 2) {
            this.humans.gatherResources();
        } else if (round == 3) {
            this.orcs.gatherResources();
        }
    }

    public void showScore(int round) {
        if (round == 1) {
            System.out.println(this.elves.getScore());
        } else if (round == 2) {
            System.out.println(this.humans.getScore());
        } else if (round == 3) {
            System.out.println(this.orcs.getScore());
        } else{
            System.out.println("---");
        }
    }

}
