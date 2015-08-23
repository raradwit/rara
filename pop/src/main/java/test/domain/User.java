package test.domain;

/**
 * Created by saneel on 8/23/15.
 */
public class User {
    private int id;
    private String name;
    private int roll;
    private String alias;

    public User() {
    }

    public User(int id, int roll,String name,String alias) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.alias = alias;
    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
