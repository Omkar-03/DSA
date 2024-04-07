package BackTracking;

public class NKnights {
    static int n = 8;

    public static void printSol(int sol[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && y >= 0 && x < n && y < n && sol[x][y] == -1);
    }

    public static boolean nKnights() {
        int sol[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = -1;
            }
        }

        sol[0][0] = 0; // as knight starts from cell (0, 0)

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        if (!nKnightsUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist !!!");
            return false;
        } else {
            printSol(sol);
        }
        return true;
    }

    public static boolean nKnightsUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == n * n) {
            return true;
        }

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (nKnightsUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1; // backtracking
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        nKnights();

    }
}
