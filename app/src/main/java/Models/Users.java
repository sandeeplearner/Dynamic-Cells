package Models;

/**
 * Created by sandeepbhandari on 7/15/16.
 */
public class Users {
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}
