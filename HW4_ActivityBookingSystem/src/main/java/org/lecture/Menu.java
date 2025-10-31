package org.lecture;

import static org.lecture.Main.scan;

public class Menu {
    private static int packageChoice;

    public static void welcomeMenu() {
        System.out.printf("Welcome to our booking system for leisure activities.%n" +
                        "We offer the following packages:%n" +
                        "1 %-12s: € %d%n2 %-12s: € %d%n3 %-12s: € %d%n" +
                        "You can book a maximum of %d packages.%nSelect the package you would like to book using the following number: %n",
                ActivityPackage.RELAX.name(), ActivityPackage.RELAX.getPrice(),
                ActivityPackage.ADVENTURE.name(), ActivityPackage.ADVENTURE.getPrice(),
                ActivityPackage.CULTURAL.name(), ActivityPackage.CULTURAL.getPrice(), BookingCart.getMaxPackages());
        packageChoice();
    }


    public static void packageMenu() {
        System.out.printf("1 %-12s: € %d%n2 %-12s: € %d%n3 %-12s: € %d%nSelect the package you would like to book using the following number: %n",
                ActivityPackage.RELAX.name(), ActivityPackage.RELAX.getPrice(),
                ActivityPackage.ADVENTURE.name(), ActivityPackage.ADVENTURE.getPrice(),
                ActivityPackage.CULTURAL.name(), ActivityPackage.CULTURAL.getPrice());
        packageChoice();

    }

    private static void packageChoice() {
       do {
           packageChoice = scan.nextInt();
           scan.nextLine();
           switch (packageChoice) {
               case 1 -> System.out.printf("You have selected the %s package.%n", ActivityPackage.RELAX.name());
               case 2 -> System.out.printf("You have selected the %s package.%n", ActivityPackage.ADVENTURE.name());
               case 3 -> System.out.printf("You have selected the %s package.%n", ActivityPackage.CULTURAL.name());
               default ->
                       System.out.printf("Invalid choice. Please select a valid package number.(1-%d)%n", ActivityPackage.values().length);

           }
       }while (packageChoice < 1 || packageChoice > 3);

    }


    public static int getPackageChoice() {
        return packageChoice;
    }
}
