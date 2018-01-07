package a3motion.com.colorbond.POJO;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 10/31/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class PayloadJSON {

    String email, password;

    public PayloadJSON() {
    }

    public PayloadJSON(String email, String password) {
        this.email = email;
        this.password = password;

    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
