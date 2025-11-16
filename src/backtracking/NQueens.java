public class NQueens {

    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // to check if the Queen is safe to place or not 
    public static boolean isSafe(char board[][],int row,int col){
        // vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j] == 'Q'){ 
                return false;
            }
        }

        return true;
    }
    // to place nQueens in n rows
    public static void nQueens(char board[][],int row){
        if(row == board.length){
            printBoard(board);
            System.out.println("---------------");
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                nQueens(board, row+1);
                board[row][i] = 'X';
            }
            
        }
    }
    public static void main(String[] args) {
        char board[][] = new char[4][4];
        // initialise the board with all X
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
    }
}
