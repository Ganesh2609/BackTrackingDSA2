#include <stdio.h>
#include <stdlib.h>

void solve(int board[9][9], int a, int b);
int check(int board[9][9], int a, int b, int val);

int main() {
    int board[9][9];

    printf("Enter the Sudoku puzzle (9x9 grid):\n");
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            int num;
            if (scanf("%d", &num) != 1) {
                printf("Invalid input. Please enter numbers only.\n");
                return 1;
            }
            
            if (num < 0 || num > 9) {
                printf("Invalid input. Please enter numbers from 0 to 9 only.\n");
                return 1;
            }
            
            board[i][j] = num;
        }
    }

    solve(board, 0, 0);

    return 0;
}


void solve(int board[9][9], int a, int b) {
    int i, j, k = 0;

    for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
            if (board[i][j] != 0) {
                k++;
            }
        }
    }

    if (k == 81) {
        printf("\nThe solution is :\n");
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                printf("%d ", board[i][j]);
            }
            printf("\n");
        }
        exit(0);
    }

    if (board[a][b] != 0) {
        if (b < 8) {
            solve(board, a, b + 1);
            return;
        } else {
            solve(board, a + 1, 0);
            return;
        }
    }

    if (board[a][b] == 0) {
        for (i = 1; i <= 9; i++) {
            if (check(board, a, b, i)) {
                board[a][b] = i;
                if (b < 8) {
                    solve(board, a, b + 1);
                } else {
                    solve(board, a + 1, 0);
                }
                board[a][b] = 0;
            }
        }
    }
}

int check(int board[9][9], int a, int b, int val) {
    int i, j;
    for (i = 0; i < 9; i++) {
        if (board[a][i] == val || board[i][b] == val) {
            return 0;
        }
    }

    int c = (a / 3) + 1;
    int d = (b / 3) + 1;

    for (i = (c - 1) * 3; i < c * 3; i++) {
        for (j = (d - 1) * 3; j < d * 3; j++) {
            if (board[i][j] == val) {
                return 0;
            }
        }
    }
    return 1;
}