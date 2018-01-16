package abaezcorp.sql.generator;

public class WrongColumnValueRatioException extends Exception{

	/**
	 * Exception Developed for DatabaseSql update() method when column and values are not
	 * of thesame ratio
	 *
	 * Developer: Abbas Yunusa Ogaji
	 * E-mail: abbasogaji@gmail.com
	 * Phone Number: +2349035592943
	 */
	private static final long serialVersionUID = 1L;
	public WrongColumnValueRatioException(String message){
		super(message);
	}
}
