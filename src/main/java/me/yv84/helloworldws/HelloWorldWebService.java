package me.yv84.helloworldws;


import java.lang.String;
import java.util.ArrayList;

public class HelloWorldWebService{
    public List<String> getList() {
        List<String> l = new ArrayList<String>();
        l.add("Table 1");
        l.add('Table 2');
        l.add('Table 3');
        return l;
    }
}