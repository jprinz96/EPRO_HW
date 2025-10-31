package org.lecture;

public enum TicketStatus {
    /*
    Ticket Status Enumeration (TicketStatus):
      Represent the possible states of a parking ticket.
      The statuses should include:
        ISSUED: The ticket has been created but not yet paid.
        PAID: The ticket has been paid, but not validated at the gate.
        VALIDATED: The ticket has been validated at the exit gate.
        CLOSED: The ticket has been closed after exit.
        CANCELLED: The ticket has been cancelled (only possible if still ISSUED).
     */
    ISSUED,
    PAID,
    VALIDATED,
    CLOSED,
    CANCELLED
}
