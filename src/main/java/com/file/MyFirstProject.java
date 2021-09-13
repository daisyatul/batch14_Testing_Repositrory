package com.file;

public class MyFirstProject {
    //variables
    int a;
    int b;
    int result;
    //method
    public MyFirstProject(int x,int y){
        this.a=x;
        this.b=y;
    }
    public int addNumbers()
    {
        result=a+b;
        return result;

    }
    public int subNumbers()
    {
        result=a-b;
        return result;
    }
    public int multiNumbers()
    {
        result=a*b;
        return result;
    }
}
