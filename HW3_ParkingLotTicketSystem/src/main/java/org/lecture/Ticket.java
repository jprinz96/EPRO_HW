package org.lecture;

public class Ticket {
    /*
    Constructor(String ticketNumber): Initializes a new ticket with the given number (converted to uppercase) and sets its status to ISSUED. Prints a confirmation message.
    payTicket(): Changes the status from ISSUED → PAID.
    validateTicket(): Changes the status from PAID → VALIDATED.
    closeTicket(): Changes the status from VALIDATED → CLOSED
    cancelTicket(): Changes the status to CANCELLED.
    printStatus(): Displays the current status of the ticket
     */

    private String ticketNumber;
    private TicketStatus ticketStatus;

    //Constructor
    public Ticket(String ticketNumber) {
        this.ticketNumber = ticketNumber.toUpperCase();
        this.ticketStatus = TicketStatus.ISSUED;
        System.out.println("Ticket " + this.ticketNumber + " has been issued.");
    }

    public void payTicket() {
        if (this.ticketStatus == TicketStatus.ISSUED) {
            this.ticketStatus = TicketStatus.PAID;
            System.out.println("Ticket " + this.ticketNumber + " has been paid.");
        } else {
            System.out.println("Ticket " + this.ticketNumber + " payment process failed.");
        }
    }

    public void validateTicket() {
        if (this.ticketStatus == TicketStatus.PAID) {
            this.ticketStatus = TicketStatus.VALIDATED;
            System.out.println("Ticket " + this.ticketNumber + " has been validated at the gate.");
        } else {
            System.out.println("Ticket " + this.ticketNumber + " could not be validated.");
        }

    }

    public void closeTicket() {
        if (this.ticketStatus == TicketStatus.VALIDATED) {
            this.ticketStatus = TicketStatus.CLOSED;
            System.out.println("Ticket " + this.ticketNumber + " has been closed.");
            getTicketStatus();
        } else {
            System.out.println("Ticket " + this.ticketNumber + " could not be closed.");
        }

    }

    public void cancelTicket() {
        if (this.ticketStatus == TicketStatus.ISSUED) {
            this.ticketStatus = TicketStatus.CANCELLED;
            System.out.println("Ticket " + this.ticketNumber + "has been successful cancelled.");
        } else {
            System.out.println("Ticket " + this.ticketNumber + " cannot be cancelled at this stage.");
        }
    }

    public TicketStatus getTicketStatus() {
        System.out.println("Ticket " + this.ticketNumber + " is currently " + this.ticketStatus);
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
