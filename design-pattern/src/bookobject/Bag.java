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

    public boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket(){
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
