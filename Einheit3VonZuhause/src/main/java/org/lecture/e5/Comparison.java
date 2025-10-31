package org.lecture.e5;

public class Comparison {
// Meine Lösung
    /*
    int numb1, numb2;

    public Comparison(int numb1, int numb2) {
        this.numb1 = numb1;
        this.numb2 = numb2;
    }

    public static void compare(int numb1, int numb2) {
        if (numb1 < numb2) {
            System.out.println(numb1 + " is less than " + numb2);
        } else if (numb1 > numb2) {
            System.out.println(numb1 + " is greater than " + numb2);
        } else if (numb1 == numb2) {
            System.out.println(numb1 + " is equal to " + numb2);
        }
           }

 */
    //Lösung nach Aufgabenstellung mit String

    public static String compare(int numb1, int numb2) {
        if (numb1 < numb2) {
            return String.format("%d is less than %d", numb1, numb2);
        } else if (numb1 > numb2) {
            return String.format("%d is more than %d", numb1, numb2);
        } else  {
            return String.format("%d is equal to %d", numb1, numb2);
        }

    }


}
