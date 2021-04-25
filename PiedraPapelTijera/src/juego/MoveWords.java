package juego;
import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

   // private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA"};
    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTO", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
 /**
  * Evalua que value esta dentro de uno de los dos arrays   
  * @param value
  * @return true si es valido
  */
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }
/**
 * Genera un aleatorio que multiplica por la longitu del array, obteniendo una posición de este
 * @return String que corresponde a una posicion del array
 */
    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }
/**
 * Muestra por pantalla los valores para todas las posiciones del array validMoves
 */
    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
/**
 * Muestra por pantalla los valores para todas las posiciones del array validCommands
 */
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }
/**
 * LLama a las funciones anteriores
 */
    public void showWords(){
        showMoves();
        showCommands();    
    }
/**
 * Recorre el array validMoves y compara los valores de las posiciones del array con value, si es igual devuelve la posicion
 * @param value
 * @return un entero con la posicion
 */
    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }
/**
 * 
 * @param first
 * @param second
 * @return 
 * @return
 */
      public static int checkWinner(String first, String second) {
    	  int first_i, second_i;

  	    first_i = getIndex(first);
  	    second_i = getIndex(second);
  	    if (first_i == second_i) {
  	    	return EMPATE;
  	    }
  	    if((first_i==0)&&(second_i==1 ||second_i==3)) {
  	    	return GANA;
  	    }
  	    if((first_i==1)&&(second_i==2 ||second_i==4)) {
	    	return GANA;
	    }
  	    if((first_i==2)&&(second_i==0 ||second_i==3)) {
	    	return GANA;
	    }
  	    if((first_i==3)&&(second_i==1 ||second_i==4)) {
	    	return GANA;
	    }
  	    if((first_i==4)&&(second_i==0 ||second_i==2)) {
	    	return GANA;
	    }
  	    else return PIERDE;
      }
  /*  public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);//piedra = 2 +1 = 3 % 3 = 1+1=2
	    second_i = getIndex(second);// papel = 1

	    if (first_i == second_i) return EMPATE;// a partir de aqui hacer 
	    
	    return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	}
	
	*Sobreescribimos el método checkWinner, ya que el algoritmo que utiliza, al cambiar el tamaño del array validMoves no funciona, 
	*por lo que no podemos extenderlo a tamaño 5, es necesario describir otro funcionamiento para el método.
	*/
	
} 
