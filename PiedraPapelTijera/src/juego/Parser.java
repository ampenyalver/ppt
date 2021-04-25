package juego;
import java.util.Scanner;
/**
 * Clase Parser (analizador)
 * dos objetos de las clases MoveWords y Scanner como atributos
 * @author maria
 *
 */
public class Parser{
    private MoveWords moves;
    private Scanner reader;
/**
 * Constructor de Parser, donde se declaran como atributos los objetos
 */
    public Parser(){
    	moves = new MoveWords();
	    reader = new Scanner(System.in);
    }
/**
 * llama a la funcion showWords de la clase MoveWords
 */
    public void showCommands(){
	    moves.showWords();
    }
/***
 * genera un objeto de tipo Move, llamando a la función randmMove de la clase MoveWords
 * @return nuevo objeto Move
 */
    public Move newRandomMove(){
	    return new Move(moves.randomMove());
    }

/**
 * Esta función lee lo ingresado por pantalla
 * @return nuevo objeto Move
 */
    public Move getMove(){
        
	    String command = null;
	    System.out.print("Tu elecciÃ³n: ");
	    
	    String input = reader.nextLine();

	    Scanner tokenizer = new Scanner(input);
        
	    if(tokenizer.hasNext()) {
	        // get first word
                command = tokenizer.next().toUpperCase(); //convierte en mayusculas el siguiente tokenizer y lo guarda en command         
                if(tokenizer.hasNext()) {
                    // note: if the command has two or more words, it is not
		            // valid
		            return new Move();
                }
	    }
	    
	    if ( (command != null) && (moves.isValidMoveCommand(command)) )
	        return new Move(command);
	    
	    // we return a move with no associated command, as it is unknown.
	    return new Move();
    }
}
