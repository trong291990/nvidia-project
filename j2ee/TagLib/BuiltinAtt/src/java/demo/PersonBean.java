/*
 * PersonBean.java
 *
 * Created on February 15, 2009, 5:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package demo;

/**
 *
 * @author minhlg
 */
public class PersonBean {
    
    /** Creates a new instance of PersonBean */
    private String pname;
    private int age;
    public PersonBean() {
        pname = "" ; 
        age = 0;
    }
    //---------- get method ----------------
    public String getPname()
    {
        return pname;
    }
    public int getAge()
    {
        return age;
    }
    //--------- set method ------------------
    public void setPname(String newval)
    {
        pname = newval;
    }
    public void setAge(int newval)
    {
        age = newval;
    }
    //-------- business method --------------
    public static String displayInfo(String varpname , int varage)
    {
        return "Name : " + varpname + " and Age : " + varage;
    }
}
