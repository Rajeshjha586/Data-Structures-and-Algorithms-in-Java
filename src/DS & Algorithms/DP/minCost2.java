package DP;

public class minCost2 {

    static int minCost2(int cost[][], int m, int n) {
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];
        for (int j = 1; j <= n; j++) {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i <= m; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tc[i][j] = Math.min(tc[i - 1][j], Math.min(tc[i][j - 1], tc[i - 1][j - 1])) + cost[i][j];
            }
        }
        return tc[m][n];
    }

    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(minCost2(cost, 2, 2));
    }
}
