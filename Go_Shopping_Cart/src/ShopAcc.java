
// Abstract class representing Online Shopping account
abstract class ShopAcc {
    private int accNo;
    private String accNm;
    private float charges;

    public ShopAcc(int accNo, String accNm, float charges) {
        this.accNo = accNo;
        this.accNm = accNm;
        this.charges = charges;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getAccNm() {
        return accNm;
    }

    public float getCharges() {
        return charges;
    }

    public abstract void bookProduct(float amount);

    @Override
    public String toString() {
        return "Account No: " + accNo + ", Account Name: " + accNm + ", Charges: " + charges;
    }
}

// Abstract class representing Prime Account
abstract class PrimeAcc extends ShopAcc {
    public PrimeAcc(int accNo, String accNm) {
        super(accNo, accNm, 0); // Prime accounts have no additional charges
    }

    @Override
    public void bookProduct(float amount) {
        // Additional logic for Prime account (if any)
        System.out.println("Booking product for Prime account");
    }
}

// Abstract class representing Normal Account
abstract class NormalAcc extends ShopAcc {
    public NormalAcc(int accNo, String accNm, float charges) {
        super(accNo, accNm, charges);
    }

    @Override
    public void bookProduct(float amount) {
        // Additional logic for Normal account (if any)
        System.out.println("Booking product for Normal account");
    }
}

// Factory class for creating Prime and Normal accounts
abstract class ShopFactory {
    public abstract PrimeAcc getNewPrimeAccount(int accNo, String accNm);
    public abstract NormalAcc getNewNormalAccount(int accNo, String accNm, float charges);
}

// Concrete implementation of Prime Account
class GSPrimeAcc extends PrimeAcc {
    public GSPrimeAcc(int accNo, String accNm) {
        super(accNo, accNm);
    }
}

// Concrete implementation of Normal Account
class GSNormalAcc extends NormalAcc {
    public GSNormalAcc(int accNo, String accNm, float charges) {
        super(accNo, accNm, charges);
    }
}

// Concrete implementation of ShopFactory
class GSShopFactory extends ShopFactory {
    @Override
    public PrimeAcc getNewPrimeAccount(int accNo, String accNm) {
        return new GSPrimeAcc(accNo, accNm);
    }

    @Override
    public NormalAcc getNewNormalAccount(int accNo, String accNm, float charges) {
        return new GSNormalAcc(accNo, accNm, charges);
    }
}

public class OnlineShoppingApp {
    public static void main(String[] args) {
        // Create an instance of GSShopFactory
        ShopFactory shopFactory = new GSShopFactory();

        // Instantiate GSPrimeAcc and GSNormalAcc
        PrimeAcc primeAccount = shopFactory.getNewPrimeAccount(1, "PrimeUser");
        NormalAcc normalAccount = shopFactory.getNewNormalAccount(2, "NormalUser", 5.0f);

        // Invoke bookProduct() method
        primeAccount.bookProduct(100.0f);
        normalAccount.bookProduct(50.0f);

        // Invoke toString() method
        System.out.println(primeAccount.toString());
        System.out.println(normalAccount.toString());
    }
}
