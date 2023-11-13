package UserAuthentication;
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
	 *already exist so will {@code return true}
	 *else {@code return false}
	 *</pre>
	 * @param userName <strong style="color:'white'"> Represent the userName of the user</strong>
	 * @param password <strong style="color:'white'"> Represent the password of the user</strong>
	 */
	public static User login(User user) {
		boolean exist = false ;
		exist = DBHandle.ifUserExist(user.getAccount().getUserName()) ;
		exist = exist && DBHandle.ifPasswordCorrect(user.getAccount().getUserName(), user.getAccount().getPassword()) ;

		if (exist){
			return DBHandle.loadProfile(user.getAccount().getUserName()) ;
		}

		return null ;
	}
}