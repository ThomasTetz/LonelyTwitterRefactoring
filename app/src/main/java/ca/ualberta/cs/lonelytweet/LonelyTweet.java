package ca.ualberta.cs.lonelytweet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

// @Refactor 2: was using default class. Edited comment to remove warning.
/**
 * Created by thomas on 2017-11-01.
 * CMPUT 301 Lab 9
 */

abstract class LonelyTweet implements Serializable {
    private static final long serialVersionUID = 1L;
    Date tweetDate;     // @Refactor 3: could change scope and not affect function
    String tweetBody;   // @Refactor 3: could change scope and not affect function

    public Date getTweetDate() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public abstract String getTweetBody();

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(tweetDate);
        out.writeObject(tweetBody);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        tweetDate = (Date) in.readObject();
        tweetBody = (String) in.readObject();
    }

    public abstract boolean isValid();

    @Override
    public String toString() {
        return getTweetDate() + " | " + getTweetBody() ;
    }
}
