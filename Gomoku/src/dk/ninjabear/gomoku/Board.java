package dk.ninjabear.gomoku;

public class Board {
	private Player[][] board;
	
	public Board() {
		board = new Player[19][19];
	}
	
	public boolean playAt(int x, int y, Player player) {
		if (board[x][y] != null)
			return false;
		board[x][y] = player;
		return true;
	}
	
	public Player getTileAt(int x, int y) {
		return board[x][y];
	}
	
	public boolean isBoardFilled() {
		for (int x = 0; x < board.length; x++)
			for (int y = 0; y < board[x].length; y++)
				if (board[x][y] == null)
					return false;
		return true;
	}
	
	public Player winnerFound() {
		for (int x = 0; x < board.length; x++)
			for (int y = 0; y < board[x].length; y++)
				if (board[x][y] != null) {
					if (x <= board.length - 5 && y <= board.length - 5) // if not close to lower right corner, check cross right-down
						if (board[x][y] == board[x+1][y+1] &&
							board[x][y] == board[x+2][y+2] &&
							board[x][y] == board[x+3][y+3] &&
							board[x][y] == board[x+4][y+4]) return board[x][y];
					if (x >= 5 && y <= board.length - 5) // if not close to lower left corner, check cross left-down
						if (board[x][y] == board[x-1][y+1] &&
							board[x][y] == board[x-2][y+2] &&
							board[x][y] == board[x-3][y+3] &&
							board[x][y] == board[x-4][y+4]) return board[x][y];
					
					if (x <= board.length - 5) // if not at right edge, check right
						if (board[x][y] == board[x+1][y] &&
							board[x][y] == board[x+2][y] &&
							board[x][y] == board[x+3][y] &&
							board[x][y] == board[x+4][y]) return board[x][y];
					if (y <= board.length - 5) // if not at bottom, check down
						if (board[x][y] == board[x][y+1] &&
							board[x][y] == board[x][y+2] &&
							board[x][y] == board[x][y+3] &&
							board[x][y] == board[x][y+4]) return board[x][y];
				}
		return null;
	}
	
	public int getWidth() {
		return board.length;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++)
				if (board[x][y] == Player.WHITE)
					sb.append("[X]");
				else if (board[x][y] == Player.BLACK)
					sb.append("[O]");
				else
					sb.append("[ ]");
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public Player[][] getData() {
		return board;
	}
}
