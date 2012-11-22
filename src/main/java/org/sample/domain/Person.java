package org.sample.domain;

/**
 * @author Jatinder Singh on 2012-11-21 at 10:06 PM
 */
public class Person {
    private String id;
    private String fname;
    private String lname;
    private String telephone;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person => {" +
                "id -> " + id + ", " +
                "fname -> " + fname + ", " +
                "lname -> " + lname + ", " +
                "telephone -> " + telephone + ", " +
                "address -> " + address +
                "}";

    }
}
