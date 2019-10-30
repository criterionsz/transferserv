package transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import transfer.model.Transfer;
import transfer.requestbody.TransferRequest;
import transfer.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/transfer")
    public String transferToAcc(@Valid @RequestBody TransferRequest transfer) {
        orderService.insertTransfer(transfer);
        System.out.println(transfer.getToAccount());
        return transfer.getToAccount();
    }

    @GetMapping("/history")
    public ConcurrentHashMap<Long,Transfer> getChat() {
        return orderService.getHistory();
    }
}
