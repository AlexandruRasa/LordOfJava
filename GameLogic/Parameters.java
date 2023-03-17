package LordOfJava;

public class Parameters {

    private String OS;
    private String gamePATH;
    private String credentials;

    public Parameters(String OS, String gamePATH, String credentials) {
        this.OS = OS;
        this.gamePATH = gamePATH;
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Parameters:\n" +
                "OS='" + OS + "\n" +
                "GamePATH='" + gamePATH + "\n" +
                "Credentials='" + credentials + "\n";
    }
}
