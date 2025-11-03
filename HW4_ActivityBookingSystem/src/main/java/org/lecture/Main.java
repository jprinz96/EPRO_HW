package org.lecture;

import java.awt.print.Book;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static void main() {
        char choiceMoreBooking;
        // Welcome Menu & 1. Buchung
        Menu.welcomeMenu();
        BookingCart.packageBooking();

        //weitere Buchungen erwünscht?
        do {
            System.out.printf("You have booked %d package/s and could book %d more.%nWould you like to book another package? Type: (Y/N)%n",
                    BookingCart.getCountOfAllPackages(), BookingCart.getMaxPackages() - BookingCart.getCountOfAllPackages());
            choiceMoreBooking = scan.next().charAt(0);
            //Wenn Ja
            if (choiceMoreBooking == 'Y' || choiceMoreBooking == 'y') {
                Menu.packageMenu();
                BookingCart.packageBooking();
            } else if (choiceMoreBooking != 'Y' || choiceMoreBooking != 'y' && choiceMoreBooking != 'N' && choiceMoreBooking != 'n') {
                System.out.println("Invalid choice. Please type Y for Yes or N for No.");

            }

        } while (choiceMoreBooking != 'N' && choiceMoreBooking != 'n' && BookingCart.getCountOfAllPackages() < BookingCart.getMaxPackages());
        System.out.println("Thank you for your booking!");

        //Statistik -Zusammenfassung der Buchungen
        BookingCart.printSummary();

    }


}

