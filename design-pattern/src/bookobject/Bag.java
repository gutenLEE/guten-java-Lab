package bookobject;

/**
 * @author gutenlee
 * @since 2022/08/01
 */
public class Bag {

    private Invitation invitation;
    private Ticket ticket;
    private long amount;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount ) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.setTicket(ticket);
            return 0L;
        } else {
            this.minusAmount(ticket.getFee());
            this.setTicket(ticket);
            return ticket.getFee();
        }
    }

    private boolean hasInvitation(){
        return invitation != null;
    }

    private boolean hasTicket(){
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
