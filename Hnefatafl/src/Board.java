
/**
 *
 * @author James
 */
public class Board {
    
    public final int WIDTH = 9;
    public final int LENGTH = 9;
    
    private Piece[][] board;
    
    public Board() {
        this.board = new Piece[WIDTH][LENGTH];
    }
    
    public int getBoardWidth() {
        return WIDTH;
    }
    
    public int getBoardLength() {
        return LENGTH;
    }
    
    public void initialise() {
        //Defenders
        for(int i = 3; i < 6; i++) {
            this.board[0][i] = new Piece();
            this.board[i][0] = new Piece();
            this.board[i][WIDTH-1] = new Piece();
            this.board[LENGTH-1][i] = new Piece();
        }
        this.board[4][1] = new Piece();
        this.board[1][4] = new Piece();
        this.board[7][4] = new Piece();
        this.board[4][7] = new Piece();
        
        //Attackers        
        for(int j = 2; j < 7; j++) {
            if(j == 4) {
                this.board[4][j] = new Piece();
            }
            this.board[4][j] = new Piece();
            this.board[j][4] = new Piece();
        }
        
    }
    
    public Piece getPieceAtIndex(int column, int height) {
        return board[column][height];
    }
    
    public boolean positionAtIndexIsEmpty(int column, int height) {
        return board[column][height] == null;
    }
         
    @Override
    public String toString() { 
        final String BAR = "|";
        final String LINE = "-";
        
        String board = "";
        
        for(int i = 0; i < WIDTH * 2 + 1; i++) {
            board += LINE;
        }
        board +="\n";

        for(int j = 0; j < WIDTH; j++) {           
            board += BAR;          
            for(int k = 0; k < LENGTH; k++) {          
                if(positionAtIndexIsEmpty(j, k)) {
                    board += " " + BAR;
                } else {
                    board += getPieceAtIndex(j, k).toString() + BAR;
                }
            }
            board += "\n";
        }
        
        for(int l = 0; l < WIDTH * 2 + 1; l++) {
            board += LINE;
        }  
        return board;     
    }   
}
