package bookobject;

/**
 * @author gutenlee
 * @since 2022/08/01
 */
public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketOffice getTicketOffice(){
        return this.ticketOffice;
    }

    public void sellTo(Audience audience) {
        // ticketSeller 가 tickerOffice의 직접적으로 접근하고있음.
        this.ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}
