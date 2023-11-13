package UserAuthentication;

/**
 *<pre>
 *This class {@code register} its role is login the user
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version  <strong style="color:'white'"> 1.0</strong>
 */
public class LoginHandle {

	/**
	 *<pre>
	 *This method {@code login} its role is register the user
	 *It check if the {@code userName} and {@code Password}
	 *already exist so will {@code return true}
	 *else {@code return false}
	 *</pre>
	 * @param userName <strong style="color:'white'"> Represent the userName of the user</strong>
	 * @param password <strong style="color:'white'"> Represent the password of the user</strong>
	 */
	public static boolean login(String userName, String password) {
		boolean exist = false ;
		// exist = DBHandle.addUser(user).ifUserExist(userName) ;
		// exist = exist && DBHandle.addUser(user).ifPasswordCorrect(userName, password) ;
		return exist ;
	}
}