/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.models;

/**
 *
 * @author Dell
 */
public class AccountRegistrationError {
    private String passwordFormatNotMatch;
    private String confirmPasswordNotMatch;
    private String usernameLengthError;
    private String emailIsExisted;

    public AccountRegistrationError() {
    }

    public AccountRegistrationError(String passwordFormatNotMatch, String confirmPasswordNotMatch, String usernameLengthError, String emailIsExisted) {
        this.passwordFormatNotMatch = passwordFormatNotMatch;
        this.confirmPasswordNotMatch = confirmPasswordNotMatch;
        this.usernameLengthError = usernameLengthError;
        this.emailIsExisted = emailIsExisted;
    }

    public String getPasswordFormatNotMatch() {
        return passwordFormatNotMatch;
    }

    public void setPasswordFormatNotMatch(String passwordFormatNotMatch) {
        this.passwordFormatNotMatch = passwordFormatNotMatch;
    }

    public String getConfirmPasswordNotMatch() {
        return confirmPasswordNotMatch;
    }

    public void setConfirmPasswordNotMatch(String confirmPasswordNotMatch) {
        this.confirmPasswordNotMatch = confirmPasswordNotMatch;
    }

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getEmailIsExisted() {
        return emailIsExisted;
    }

    public void setEmailIsExisted(String emailIsExisted) {
        this.emailIsExisted = emailIsExisted;
    }
}
