package org.example;

import java.util.List;

public class MethodTests {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println();

        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectCountClients();
        for (MaxProjectCountClient maxProjectCountClient : maxProjectCountClients) {
            System.out.println(maxProjectCountClient);
        }

        System.out.println();

        List<LongestProject> longestProjects = queryService.findLongestProjects();
        for (LongestProject longestProject : longestProjects) {
            System.out.println(longestProject);
        }

        System.out.println();

        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorkers();
        for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers) {
            System.out.println(maxSalaryWorker);
        }

        System.out.println();

        List<YoungestOldestWorkers> youngestOldestWorkers = queryService.findYoungestOldestWorkers();
        for (YoungestOldestWorkers youngestOldestWorker: youngestOldestWorkers) {
            System.out.println(youngestOldestWorker);
        }
    }
}
