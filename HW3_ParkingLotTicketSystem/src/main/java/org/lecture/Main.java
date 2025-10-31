package org.lecture;

import java.util.Scanner;

public class Main {
    static void main() {
        /*
Steps in main:
    1.Ask the user for a ticket number and create a new Ticket instance.
    2.Progress the ticket through its lifecycle:
        Pay the ticket (payTicket)
        Validate the ticket (validateTicket)
        Close the ticket (closeTicket)
    3.After closing, call printStatus() to show the final state.
    4.Attempt to cancel the ticket after it has been closed to demonstrate invalid transitions.
    5.Observe printed messages to ensure logic is enforced.
         */

        Scanner scan = new Scanner(System.in);

        //Benutzer willkommen heißen und TicketNr. abfragen
        System.out.print("""
                Welcome to the Parking Lot Ticket System!
                Please enter your ticket number:
                """);
        //Ticketnummer speichern
        String ticketNumber = scan.nextLine();

        //Benutzereingabe dem erzeugten Ticket übergeben
        Ticket ticket = new Ticket(ticketNumber);

        System.out.println("""
                Would you like to cancel the ticket or continue with the order process? 
                
                1 - Continue
                2 - Cancel""");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice == 2) {
            ticket.cancelTicket();
            //printStatus()
            ticket.getTicketStatus();
        } else {
            ticket.payTicket();
            ticket.validateTicket();
            ticket.closeTicket();
            ticket.cancelTicket();
            ticket.getTicketStatus();

            /*TESTEN

            //Methode payTicket() testen
            //ticket.setTicketStatus(TicketStatus.VALIDATED);

            //Ticket bezahlen
            ticket.payTicket();
            //Status prüfen
            System.out.println(ticket.getTicketStatus());

            //Ticket validieren
            ticket.validateTicket();
            //Status prüfen
            System.out.println(ticket.getTicketStatus());

            //Ticket schließen
            ticket.closeTicket();
            //Status prüfen
            System.out.println(ticket.getTicketStatus());

            ticket.cancelTicket();
            System.out.println(ticket.getTicketStatus());
            */

        }

    }
}
