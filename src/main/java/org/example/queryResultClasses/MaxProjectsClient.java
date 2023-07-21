package org.example.queryResultClasses;

public class MaxProjectsClient {

    private String name;
    private int maxProjects;

    public MaxProjectsClient(String name, int projectCount) {
        this.name = name;
        this.maxProjects = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return maxProjects;
    }
}
