import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class User {
    private int attempts;
    private double balance;
    private String pin;

    public User(double balance, String pin){
        this.attempts = 0;
        this.balance = balance;
        this.pin = hashPin(pin);
    }

    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    public String getPin() {
        return pin;
    }
    protected void setPin(String newPin){ pin = hashPin(newPin); }

    //Create hash of entered pin
    public static String hashPin(String pinNum){
        try {
            byte[] bytesOfMessage = pinNum.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            return new String(thedigest, StandardCharsets.UTF_8);
        }catch (Exception e){
            return null;
        }
    }
}
