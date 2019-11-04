package transfer.requestbody;

import com.sun.istack.internal.NotNull;

import java.util.Calendar;
import java.util.Date;

public class TransferRequest {
    @NotNull
    private String fromAccount;
    private String toAccount;
    double amount;

    public TransferRequest(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public TransferRequest(){

    }


    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
