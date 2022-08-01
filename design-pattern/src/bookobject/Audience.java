package bookobject;

/**
 * @author gutenlee
 * @since 2022/08/01
 */
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket){
        if (this.bag.hasInvitation()) {
            this.bag.setTicket(ticket);
            return 0L;
        } else {
            this.bag.minusAmount(ticket.getFee());
            this.bag.setTicket(ticket);
            return ticket.getFee();
        }
    }
}
