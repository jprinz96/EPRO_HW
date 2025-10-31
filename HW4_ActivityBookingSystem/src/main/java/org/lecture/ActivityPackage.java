package org.lecture;

public enum ActivityPackage {
    RELAX (40) ,
    ADVENTURE(80),
    CULTURAL(60);

    private final int price;


    ActivityPackage(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
