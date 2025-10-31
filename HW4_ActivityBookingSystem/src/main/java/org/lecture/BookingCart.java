package org.lecture;

import static org.lecture.Main.scan;

public class BookingCart {
    private static int maxPackages = 20;
    private static int relaxCount = 0;
    private static int adventureCount = 0;
    private static int culturalCount = 0;
    private static int countOfAllPackages;
    private static int numberOfPackages = 0;

    public static void packageBooking() {
        boolean temp = false;
        do {
            System.out.printf("How many packages would you like to book?(1-%d)%n", maxPackages - countOfAllPackages);
            numberOfPackages = scan.nextInt();
            scan.nextLine();
            if (numberOfPackages+ countOfAllPackages > maxPackages) {
                System.out.printf("Invalid number. Please enter a valid number.(1-%d)%n", maxPackages - countOfAllPackages);
            } else if (numberOfPackages < 1) {
                System.out.printf("Invalid number. Please enter a valid number.(1-%d)%n", maxPackages - countOfAllPackages);
            } else {
                switch (Menu.getPackageChoice()) {
                    case 1 -> relaxCount += numberOfPackages;
                    case 2 -> adventureCount += numberOfPackages;
                    case 3 -> culturalCount += numberOfPackages;
                }
                countOfAllPackages = relaxCount + adventureCount + culturalCount;
                temp = true;
            }
        } while (temp == false);


    }
    public static void printSummary() {
        //Preis pro Paket
        int totalPriceRelax = relaxCount * ActivityPackage.RELAX.getPrice();
        int totalPriceAdventure = adventureCount * ActivityPackage.ADVENTURE.getPrice();
        int totalPriceCultural = culturalCount * ActivityPackage.CULTURAL.getPrice();
        int totalPriceOfAllBookedPackages = totalPriceRelax + totalPriceAdventure + totalPriceCultural;

        System.out.printf(
                "You have booked %d packages, including:%n" +
                        "%-12s: %3d pcs  = €%6d%n%-12s: %3d pcs  = €%6d%n%-12s: %3d pcs  = €%6d%n" +
                        "---------------------------------------------%n" +
                        "Total Price: €%17d%n",
                countOfAllPackages ,
                ActivityPackage.RELAX.name(), relaxCount, totalPriceRelax,
                ActivityPackage.ADVENTURE.name(), adventureCount, totalPriceAdventure,
                ActivityPackage.CULTURAL.name(), culturalCount, totalPriceCultural,
                totalPriceOfAllBookedPackages
        );

    }


    public static int getMaxPackages() {
        return maxPackages;
    }

    public static int getRelaxCount() {
        return relaxCount;
    }

    public static int getAdventureCount() {
        return adventureCount;
    }

    public static int getCulturalCount() {
        return culturalCount;
    }

    public static int getCountOfAllPackages() {
        return countOfAllPackages;
    }
}
