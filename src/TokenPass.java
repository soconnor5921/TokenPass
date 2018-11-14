public class TokenPass
{
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for(int i = 0; i < playerCount; i++)
        {
            board[i] = (int)(Math.random()*10);
        }
        currentPlayer = (int)(Math.random()*playerCount-1);
    }

    public void distributeCurrentPlayerTokens()
    {
        if(board[currentPlayer] <= 1)
        {
            while(board[currentPlayer] > 0)
            {
                int j = currentPlayer + 1;
                if(j < board.length)
                {
                    j = 0;
                }
                board[j] += 1;
                board[currentPlayer] -= 1;

                j++;
            }
        }
    }

    public void printBoard()
    {
        String printedBoard = "";
        for(int i = 0; i < board.length; i++)
        {
            printedBoard += "Player " + i + ": " + board[i] + "\n";
        }
        System.out.println(printedBoard);
    }

    public int gameOver()
    {
        int game = -1;
        for(int i = 0; i < board.length; i++)
        {
            if(board[i] == 0)
            {
                game = i;
            }
        }
        return game;
    }

    public void nextPlayer()
    {
        currentPlayer += 1;
    }
}
