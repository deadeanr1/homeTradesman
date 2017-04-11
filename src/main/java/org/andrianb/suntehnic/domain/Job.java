package org.andrianb.suntehnic.domain;

/**
 * Created by AndrianB on 3/28/2017.
 */
public class Job {
    public static final String COLUMN_SUBMITTER = "submitter";

    private Customer owner;

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
