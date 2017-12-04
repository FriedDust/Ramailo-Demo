package com.frieddust.ramailodemo.pojo;

/**
 * @author Binod Shrestha <binodshrestha@lftechnology.com> on 12/2/17.
 */
public class TestObj {

    private String firstName;

    private String lastName;

    public TestObj(String fn, String ln) {
        this.firstName = fn;
        this.lastName = ln;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
