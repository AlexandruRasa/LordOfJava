package LordOfJava;

import java.util.ArrayList;

public class LordOfJava {

    private Parameters parameters;
    private Horde<Elf> elves;
    private Horde<Paladin> paladins;
    private Horde<Troll> trolls;

    public LordOfJava(String OS, String gamePATH, String credentials) {
        this.parameters = new Parameters(OS, gamePATH, credentials);
        this.elves = new Horde<Elf>();
        this.paladins = new Horde<Paladin>();
        this.trolls = new Horde<Troll>();
    }

    public void addCreature(Creature creature, String address) throws IllegalArgumentException {
        if (creature instanceof Elf &&
                this.elves.getResources() >= 30) {
            this.elves.updateScore(30);
            this.elves.setResources(this.elves.getResources() - 30);
            this.elves.addNewCitizen(address, (Elf) creature);
        } else if (creature instanceof Paladin &&
                this.paladins.getResources() >= 15) {
            this.paladins.updateScore(15);
            this.paladins.setResources(this.paladins.getResources() - 15);
            this.paladins.addNewCitizen(address, (Paladin) creature);
        } else if (creature instanceof Troll &&
                this.trolls.getResources() >= 10) {
            this.trolls.updateScore(10);
            this.trolls.setResources(this.trolls.getResources() - 10);
            this.trolls.addNewCitizen(address, (Troll) creature);
        } else {
            throw new IllegalArgumentException("Creature type unknown: " + creature.getClass().getName());
        }
    }

    public void battle(int round, int option) {
        boolean condition1 = battleElvesPaladins();
        boolean condition2 = battleElvesTrolls();
        boolean condition3 = battlePaladinsTrolls();
        switch (round) {
            case 1:
                if (option == 1 && condition1) {
                    System.out.println("Elves are victorious.");
                    this.elves.setResources(this.elves.getResources() + 300);
                    this.elves.updateScore(300);
                } else if (!condition1) {
                    System.out.println("Elves are defeated.");
                    this.elves.setResources(50);
                    this.paladins.updateScore(300);
                }
                if (option == 2 && condition2) {
                    System.out.println("Elves are victorious.");
                    this.elves.setResources(this.elves.getResources() + 300);
                    this.elves.updateScore(300);
                } else if (!condition2) {
                    System.out.println("Elves are defeated.");
                    this.elves.setResources(50);
                    this.trolls.updateScore(300);
                }
                break;
            case 2:
                if (option == 1 && !condition1) {
                    System.out.println("Paladins are victorious.");
                    this.paladins.setResources(this.paladins.getResources() + 300);
                    this.paladins.updateScore(300);
                } else if (option == 1) {
                    System.out.println("Paladins are defeated.");
                    this.paladins.setResources(50);
                    this.elves.updateScore(300);
                }
                if (option == 2 && condition3) {
                    System.out.println("Paladins are victorious.");
                    this.paladins.setResources(this.paladins.getResources() + 300);
                    this.paladins.updateScore(300);
                } else if (option == 2) {
                    System.out.println("Paladins are defeated.");
                    this.paladins.setResources(50);
                    this.trolls.updateScore(300);
                }
                break;
            case 3:
                if (option == 1 && !condition2) {
                    System.out.println("Trolls are victorious.");
                    this.trolls.setResources(this.trolls.getResources() + 300);
                    this.trolls.updateScore(300);
                } else if (option == 1) {
                    System.out.println("Trolls are defeated.");
                    this.trolls.setResources(50);
                    this.elves.updateScore(300);
                }
                if (option == 2 && !condition3) {
                    System.out.println("Trolls are victorious.");
                    this.trolls.setResources(this.trolls.getResources() + 300);
                    this.trolls.updateScore(300);
                } else if (option == 2) {
                    System.out.println("Trolls are defeated.");
                    this.trolls.setResources(50);
                    this.paladins.updateScore(300);
                }
                break;
            default:
                System.out.println("---");
        }
    }

    private boolean battleElvesPaladins() {
        if (this.elves.size() < this.paladins.size()) {
            return false;
        }
        if (this.elves.size() > this.paladins.size()) {
            return true;
        }
        ArrayList<Elf> armyElves = this.elves.getAllCitizensToFight();
        ArrayList<Paladin> armyPaladins = this.paladins.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.elves.size(); i++) {
            int duelResult = armyElves.get(i).compareTo(armyPaladins.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    private boolean battleElvesTrolls() {
        if (this.elves.size() < this.trolls.size()) {
            return false;
        }
        if (this.elves.size() > this.trolls.size()) {
            return true;
        }
        ArrayList<Elf> armyElves = this.elves.getAllCitizensToFight();
        ArrayList<Troll> armyTrolls = this.trolls.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.elves.size(); i++) {
            int duelResult = armyElves.get(i).compareTo(armyTrolls.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    private boolean battlePaladinsTrolls() {
        if (this.paladins.size() < this.trolls.size()) {
            return false;
        }
        if (this.paladins.size() > this.trolls.size()) {
            return true;
        }
        ArrayList<Paladin> armyPaladins = this.paladins.getAllCitizensToFight();
        ArrayList<Troll> armyTrolls = this.trolls.getAllCitizensToFight();
        int score = 0;
        for (int i = 0; i < this.paladins.size(); i++) {
            int duelResult = armyPaladins.get(i).compareTo(armyTrolls.get(i));
            score += Integer.compare(duelResult, 0);
        }
        return score >= 0;
    }

    public void buyScout(int round) {
        if (round == 1 && this.elves.getResources() >= 50) {
            this.elves.setScout(true);
            this.elves.setResources(this.elves.getResources() - 50);
            System.out.println("Elves have bought a scout.");
        } else if (round == 2 && this.paladins.getResources() >= 50) {
            this.paladins.setScout(true);
            this.paladins.setResources(this.paladins.getResources() - 50);
            System.out.println("Paladins have bought a scout.");
        } else if (round == 3 && this.trolls.getResources() >= 50) {
            this.trolls.setScout(true);
            this.trolls.setResources(this.trolls.getResources() - 50);
            System.out.println("Trolls have bought a scout.");
        } else {
            System.out.println("Not enough resources");
        }
    }

    public void scoutEnemyArmy(int round) {
        switch (round) {
            case 1:
                if (this.elves.isScout() && (this.elves.estimatePowerOfArmy() >= this.paladins.estimatePowerOfArmy()
                        || this.elves.estimatePowerOfArmy() > this.trolls.estimatePowerOfArmy())) {
                    System.out.println("Elves army might be stronger than one of the enemy armies.");
                } else if (this.elves.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.elves.setScout(false);
                break;
            case 2:
                if (this.paladins.isScout() && (this.paladins.estimatePowerOfArmy() >= this.elves.estimatePowerOfArmy()
                        || this.paladins.estimatePowerOfArmy() > this.trolls.estimatePowerOfArmy())) {
                    System.out.println("Paladins army might be stronger than one of the enemy armies.");
                } else if (this.paladins.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.paladins.setScout(false);
                break;
            case 3:
                if (this.trolls.isScout() && (this.trolls.estimatePowerOfArmy() >= this.paladins.estimatePowerOfArmy()
                        || this.trolls.estimatePowerOfArmy() > this.trolls.estimatePowerOfArmy())) {
                    System.out.println("Trolls army might be stronger than one of the enemy armies.");
                } else if (this.trolls.isScout()) {
                    System.out.println("Your army is weaker than the enemy.");
                } else {
                    System.out.println("You need to buy a scout first.");
                }
                this.trolls.setScout(false);
                break;
            default:
                System.out.println("---");
        }
    }

    public void gatherResources(int round) {
        if (round == 1) {
            this.elves.gatherResources();
        } else if (round == 2) {
            this.paladins.gatherResources();
        } else if (round == 3) {
            this.trolls.gatherResources();
        }
    }

    public void showScore(int round) {
        if (round == 1) {
            System.out.println(this.elves.getScore());
        } else if (round == 2) {
            System.out.println(this.paladins.getScore());
        } else if (round == 3) {
            System.out.println(this.trolls.getScore());
        } else{
            System.out.println("---");
        }
    }

}
