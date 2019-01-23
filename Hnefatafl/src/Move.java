
import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Move {

    private Board board;
    private int newX;
    private int newY;

    public Move(int newX, int newY) {
        this.newX = newX;
        this.newY = newY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    public ArrayList<Move> getPiecesPossibleMoves(int column, int length) {

        ArrayList<Move> possibleMoves = new ArrayList<>();

        Piece p = this.board.getPieceAtIndex(column, length);

        Move m;

        //get all possible up moves      
        if (column != 0) {
            int temp = column;
            while (board.getPieceAtIndex(temp, length) != null) {
                m = new Move(temp, length);
                possibleMoves.add(m);
                temp++;
            }
        }

        //get all possible down moves
        if (column != board.getBoardLength() - 1) {
            int temp = length;
            while (board.getPieceAtIndex(column, temp) != null) {
                m = new Move(column, temp);
                possibleMoves.add(m);
                temp--;
            }
        }

        //get all possible left moves
        if (column != 0) {
            int temp = column;
            while (board.getPieceAtIndex(temp, length) != null) {
                m = new Move(temp, length);
                possibleMoves.add(m);
                temp--;
            }
        }

        //get all possible right moves
        if (column != board.getBoardWidth() - 1) {
            int temp = column;
            while (board.getPieceAtIndex(temp, length) != null) {
                m = new Move(temp, length);
                possibleMoves.add(m);
                temp++;
            }
        }
        
        System.out.println(possibleMoves.toString());
        return possibleMoves;     
    }
    
    @Override
    public String toString() {
        return "(" + newX + " , " + newY + ")";
    }
}