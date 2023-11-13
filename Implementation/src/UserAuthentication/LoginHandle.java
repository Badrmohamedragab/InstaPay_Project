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
	 *already exist so will {@code return true}
	 *else {@code return false}
	 *</pre>
	 * @param user <strong style="color:'white'"> Represent the User which will login</strong>
	 */
	public static User login(User user) {
		boolean exist = false ;
		exist = DBHandle.ifUserExist(user.getAccount().getUserName()) ;
		exist = exist && DBHandle.ifPasswordCorrect(user.getAccount().getUserName(), user.getAccount().getPassword()) ;

		if (exist){
			return DBHandle.loadUser(user.getAccount().getUserName()) ;
		}

		return null ;
	}
}