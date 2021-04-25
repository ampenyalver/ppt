package juego;
/**
 * Class that stores a move
 */
 
public class Move{

    private String move;
/**
 * Constructor por defecto, si no le pasamos nada pone move a null
 */
    public Move(){
    	this.move = null;
    }
/**
 * Constructor que acepta parámetro
 * @param move 
 */
    public Move(String move){
    	this.move = move;
    }
/**
 * @return String move
 */
    public String getMove(){
	    return move;
    }
/**
 * Si move es null devuelve true
 * @return
 */
    public boolean isUnknown(){
	    return (move == null);
    }
/**
 * @param other objeto de tipo Move
 * @return devuelve un int resultado de llamar a checkWinner de la clase MoveWords.
 */
    public int beats(Move other){
	    return MoveWords.checkWinner(this.move, other.getMove());
    }  
}

