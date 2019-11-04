package transfer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import transfer.controller.OrderController;
import transfer.model.Transfer;
import transfer.requestbody.TransferRequest;
import transfer.service.OrderService;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService service;

    @Autowired
    private OrderController orderCoroller;
    Transfer transfer;
    List<Transfer> alltransf;

    @Before
    public  void beforeClass(){
         transfer=new Transfer(1, "Alice", "Bob", 12000, Calendar.getInstance() );
         alltransf = Arrays.asList(transfer);
    }

    @Test
    public void getHistoryTest()
            throws Exception {

        given(service.getHistory()).willReturn(alltransf);
        this.mockMvc.perform(get("/order/history")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].fromAccount").value(transfer.getFromAccount()))
                .andExpect(jsonPath("$[0].toAccount").value(transfer.getToAccount()))
                .andExpect(jsonPath("$[0].id").value(transfer.getId()));

    }


}
