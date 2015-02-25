package me.yv84.helloworldws;


import javax.jws.WebService;
import javax.jws.WebMethod;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;


@WebService(name="wsFoo", serviceName="bar")
public class HelloWorldWebService {

    @WebMethod(operationName="getList")
    public List<String> getList() {
        List<String> l = new ArrayList<String>();
        l.add("Table 1");
        l.add("Table 2");
        l.add("Table 3");
        return l;
    }

}