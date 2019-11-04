package transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import transfer.model.Transfer;
import transfer.requestbody.TransferRequest;
import transfer.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/transfer")
    public void transferToAcc(@Valid @RequestBody TransferRequest transfer) {
        orderService.insertTransfer(transfer);

    }

    @GetMapping("/history")
    public List<Transfer> getHistory() {
        return orderService.getHistory();
    }
}
