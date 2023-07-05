package LordOfJava.Characters;

public interface ICreature {
    String getNickName();
    void setNickName(String nickname);
    void powerUp(double stamina, double speed, int agility);
}