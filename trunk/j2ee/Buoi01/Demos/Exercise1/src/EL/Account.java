/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EL;

/**
 *
 * @author Administrator
 */

/* EntityObject: mapping with Table in DB */ 
public class Account {
    /* fields */
    private String username;
    private String password;

    /* constructor methods */
    public Account() {}
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* accessor methods */
    public String getUsername() { return this.username; }
    public void setUsername(String value) { this.username = value; }
    public String getPassword() { return this.password; }
    public void setPassword(String value) { this.password = value; }
}
