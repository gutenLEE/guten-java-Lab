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
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = this.ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = this.ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            this.ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
