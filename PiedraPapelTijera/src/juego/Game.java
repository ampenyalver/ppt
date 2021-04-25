package juego;
/**
 * Clase principal Game.
 * VersiÃ³n 1.0
 * @author maria
 */
public class Game {

	private Parser parser; //objeto de Parser
/**
 * Constructor de Game
 */
	public Game() {
		parser = new Parser();
	}
/**
 * Método que da la bienvenida al programa
 */
	private void welcome() {
		System.out.println("Bienvenido a nuestro pequeÃ±o juego: Piedra Papel Tijeras :-D");
	}
/**
 * Método que muestra por pantalla las opciones de ayuda
 */
	private void printHelp() {
		System.out.println("");
		System.out.println("Ordenes y comandos vÃ¡lidos para el juego: ");
		parser.showCommands();
	}
/**
 * Devuelve el movimiento del pc
 * @return objeto Move, 
 */
	private Move computerMove() {
		return parser.newRandomMove();
	}
/**
 * 
 * @param who
 */
	private void printWinner(int who) {

		if (who == MoveWords.EMPATE)
			System.out.println("Es un empate\n");
		else if (who == MoveWords.GANA)
			System.out.println("Tu ganas!!! :-D \n");
		else
			System.out.println("Tu pierdes!!! :-( \n");
	}

	private void printMoves(Move player, Move computer) {
		System.out.println("Y el resultado es...");
		System.out.println("Tu elegiste: " + player.getMove());
		System.out.println("El PC elige: " + computer.getMove());
	}
/**
 * Evalua si el objeto move, es una opcion valida
 * @param move
 * @return
 */
	private boolean processMove(Move move) {
		Move pcMove;

		if (move.isUnknown()) {//Evalua si el move pasado por parámetro es null
			System.out.println("OpciÃ³n No VÃ¡lida");
			printHelp();
			return true;
		}

		if (move.getMove().equals("SALIR")) {//devuelve false si es igual a salir
			return false;
		}

		if (move.getMove().equals("HELP")) {//devuelve true si es igual a help
			printHelp();
			return true;
		}
		pcMove = computerMove(); //guarda en pcMove el movimiento generado aleatoriamente por el pc, su tirada
		printMoves(move, pcMove); //llamada al metodo paandole eleccion de usuario y el randon del pc
		printWinner(move.beats(pcMove));//llamada al método, que a su vez llama al método beats, que internamente llama a checkWinner y compara los dos objetos
		return true;
	}
/**
 * El método se ejecutara mientras continuing sea true, imprime en que ronda esta(contabilizado por contador), 
 * llama a getMove, que leera y evaluara lo que se ingresa por pantalla, 
 * actualiza el valor de continuing con el resultado de llamar a processMove, y ejecuta el interior del método
 * 
 */
	public void playGame() {

		boolean continuing = true;
		Move move;
		int round = 1;
		while (continuing) {
			System.out.println("****** " + round + " turno ******");
			move = parser.getMove();
			continuing = processMove(move);
			round++;
		}
		System.out.println("Adios!!");
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.welcome();
		g.playGame();
	}

}
