package LordOfJava;

public class Main {
    public static void main(String[] args) {

        LordOfJava x = new LordOfJava("Windows 10","/Users/Devmind/Applications/The Lord of Java.app",
                "df56df76sdf689889dfs79sfd8fsd98.md5sum");
        x.buyScout(2);
        x.buyScout(3);
        x.addCreature(new Paladin(1,3,4,"A",5,1),"camp");
        x.addCreature(new Elf(10,30,4,"A",5,1),"camp");
        x.addCreature(new Troll(2,30,4,"A",5,1),"camp");
        x.addCreature(new Troll(2,30,4,"A",5,1),"city");
        x.addCreature(new Troll(2,30,4,"A",5,1),"battlefield");
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(2);
        x.gatherResources(1);
        x.gatherResources(1);
        x.gatherResources(1);
        x.gatherResources(1);
        x.gatherResources(1);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.gatherResources(3);
        x.buyScout(2);
        x.buyScout(3);
        x.scoutEnemyArmy(2);
        x.scoutEnemyArmy(3);
        x.battle(2,1);
        x.battle(3,1);
        x.showScore(1);
        x.showScore(2);
        x.showScore(3);

    }


}