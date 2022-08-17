package bookobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/08/01
 */
public class TicketOffice {

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTicketTo(Audience audience) {
        this.plusAmount(audience.buy(this.getTicket()));
    }

    private Ticket getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }
}
