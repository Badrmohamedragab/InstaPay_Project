package UserAuthentication;
import DataBase.DBHandle;
import User.*;

/**
 *<pre>
 *This class {@code register} its role is login the user
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version  <strong style="color:'white'"> 1.1</strong>
 */
public class LoginHandle {

	/**
	 *<pre>
	 *This method {@code login} its role is register the user
	 *It check if the {@code userName} and {@code Password}
	 *already exist so will {@code return profile of the user}
	 *else {@code return null}
	 *</pre>
	 * @param userName <strong style="color:'white'"> Represent the userName of the user</strong>
	 * @param password <strong style="color:'white'"> Represent the password of the user</strong>
	 * @return User    <strong style="color:'white'"> Represent the user</strong>
	 */
	public static User login(String userName, String password) {
		boolean exist = DBHandle.ifUserExist(userName) && DBHandle.ifPasswordCorrect(userName, password) ;

		if (exist){
			return DBHandle.loadUser(userName) ;
		}

		return null ;
	}
}