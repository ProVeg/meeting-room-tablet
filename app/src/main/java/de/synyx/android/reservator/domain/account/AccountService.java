package de.synyx.android.reservator.domain.account;

/**
 * @author  Julian Heetel - heetel@synyx.de
 */
public interface AccountService {

    String[] getAccountNames();


    String getUserAccountName();


    String getUserAccountType();
}