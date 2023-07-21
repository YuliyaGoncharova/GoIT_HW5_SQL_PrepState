package org.example.queryResultClasses;

public class LongestProject {
    int name;
    int month_count;

    public LongestProject(int name, int month_count) {
        this.name = name;
        this.month_count = month_count;
    }

    public int getName() {
        return name;
    }

    public int getMonth_count() {
        return month_count;
    }
}
