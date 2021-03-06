import org.junit.Assert;
import org.junit.Test;

//J-Unit Tests
public class AggregatedTests {
    @Test
    public void hashingFunctionTest() {
        //Arrange
        String pin = "1234";
        User user = new User(100.0, pin);
        Scene2 scene2 = new Scene2();
        //Act
        String hashedPin = scene2.hashEnteredPin("1234", user);
        //Assert
        Assert.assertEquals("Pin hash incorrect!", user.hashPin("1234"), hashedPin);
        //Assert Not Equals
        Assert.assertNotEquals("Pin hash correct when incorrect!", user.hashPin("0000"), hashedPin);
    }

    @Test
    public void userGettersSetter() {
        //Arrange
        User user = new User(1000.00, "");
        //Act
        Double balance = user.getBalance();
        String pin = user.getPin();
        int attempts = user.getAttempts();
        //Assert (Getter Test)
        Assert.assertEquals("Incorrect Balance!", 1000.0, balance, 0.0);
        Assert.assertEquals("Incorrect Pin!", "��ُ ��	���B~", pin);
        Assert.assertEquals("Incorrect Attempt Count!", 0, attempts);

        //Act
        user.setBalance(5000.0);
        user.setPin("hello");
        user.setAttempts(2);
        //Assert (Setter Test)
        Assert.assertEquals("Incorrect Balance!", 5000.0, user.getBalance(), 0.0);
        Assert.assertEquals("Incorrect Pin!", "]A@*�K*v�q��\u0010\u0017Œ", user.getPin());
        Assert.assertEquals("Incorrect Attempt Count!", 2, user.getAttempts());
    }

    @Test
    public void randomDepositAmountTest() {
        //Arrange
        User user = new User(100.0, "");
        Scene13 scene13 = new Scene13();
        //Act
        Double minBal = user.getBalance() + 10.0;
        Double maxBal = user.getBalance() + 100.0;
        user.setBalance(scene13.createDepositAmount(user));
        //Assert
        Assert.assertTrue("Balance not within range!", minBal <= user.getBalance() || maxBal <= user.getBalance());

    }
}