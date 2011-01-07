/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.util.*;

import DAL.*;
import EL.*;

/**
 *
 * @author Administrator
 */

/* BusinessLogicObject: interactive with DAO, check validation */
public class AccountBLO {
    /* fields */
    private AccountDAO accADO = new AccountDAO();

    /* business methods */
    public boolean isExist(Account account) throws Exception {
        List<Account> accounts = accADO.selectAll();
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword()))
                return true;
        }
        return false;
    }

    public boolean add(Account account) throws Exception { // (username # password) && (password >= 6 characters)
        if (account.getUsername().equals(account.getPassword()))
            return false;
        if (account.getPassword().length() < 6)
            return false;
        boolean result =  accADO.insert(account);
        return result;
    }
}
