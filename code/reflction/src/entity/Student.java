package entity;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    private String schoolName;
    public int tall;
    public String lala = "li";

    public Student(String schoolName,int tall){
        this.schoolName = schoolName;
        this.tall = tall;
    }

    public String getSchoolName(){
        return this.schoolName;
    }

    public int geta(int a){
        System.out.println(a);
        return a;
    }

    private void show(){
        System.out.println("private,show");
    }

    public void outVa(int a,String n){
        System.out.println(a);
        System.out.println(n);
    }
}
