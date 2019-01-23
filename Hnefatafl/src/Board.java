
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
    
    public String getPieceAtIndex(int column, int height) {
        return board[column][height].toString();
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
                    board += getPieceAtIndex(j, k) + BAR;
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
