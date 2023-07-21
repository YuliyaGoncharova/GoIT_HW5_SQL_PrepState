package org.example.queryResultClasses;

public class TotalProjectPrices {
    private int name;
    private int totalProjectPrice;

    public TotalProjectPrices(int name, int total_project_price) {
        this.name = name;
        this.totalProjectPrice = total_project_price;
    }

    public int getName() {
        return name;
    }

    public int getTotalProjectPrice() {
        return totalProjectPrice;
    }
}
