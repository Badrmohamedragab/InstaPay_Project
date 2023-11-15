package UserAuthentication;
import Account.*;

/**
 * <pre>
 * This class {@code Registration} its role is register the user
 * </pre>
 * <blockquote></blockquote>
 *
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.2</strong>
 */
public interface Registration {

     /**
      * <pre>
      * This method {@code register} its role is register the user
      * it has 3 parts
      * 		1- <strong style="color:'white'"> Provider</strong>
      * 			It handle the provider which user want to select
      * 		2- 	<strong style="color:'white'"> Checking</strong>
      * 			It handle checking the information {@code mobile Number}
      * 			and {@code Account Bank} in the provider
      * 		3- 	<strong style="color:'white'"> Username and Password</strong>
      * 			It handle the {@code userName} of user to be unique
      * 			and the {@code password} of the user to be strong
      * </pre>
      *
      * @return User <strong style="color:'white'"> The registered user</strong>
      */
     Account register();
}
