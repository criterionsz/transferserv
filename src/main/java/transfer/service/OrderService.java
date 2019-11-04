package transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transfer.dao.OrderDAO;
import transfer.model.Transfer;
import transfer.requestbody.TransferRequest;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;
    public OrderService(){

    }
    public void insertTransfer(TransferRequest transferRequest){
        orderDAO.setTransfer(transferRequest.getFromAccount(),   transferRequest.getToAccount(),  transferRequest.getAmount());
    }

    public List<Transfer> getHistory(){
                   return orderDAO.getTransferMap().values().stream().collect(Collectors.toList());
    }
}
