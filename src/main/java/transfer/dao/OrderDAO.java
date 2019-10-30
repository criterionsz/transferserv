package transfer.dao;

import org.springframework.stereotype.Component;
import transfer.model.Transfer;

import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderDAO {
   static ConcurrentHashMap <Long, Transfer> transferMap=new ConcurrentHashMap<>();
    Transfer transfer;
    static long id=1;

    public OrderDAO(){

    }



    public void setTransfer(String fromAccount, String toAccount, double amount){
        transferMap.put(id, new Transfer(id, fromAccount, toAccount, amount, Calendar.getInstance()));
        id++;
    }

    public ConcurrentHashMap<Long, Transfer> getTransferMap() {
        return transferMap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
