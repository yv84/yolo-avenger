import me.yv84.helloworldws.Bar; // Service
import me.yv84.helloworldws.WsFoo; // Port
import me.yv84.helloworldws.GetList; // Operation
import me.yv84.helloworldws.GetEcho; // Operation

import java.util.List;

public class JAXWSClient {

    public static void main(String args[]) throws Exception {
        if (args.length != 1) {
            System.out.println("One argument is required!");
        }
        else {
            String arg = args[0];
            Bar bar = new Bar(); // Service
            WsFoo wsFoo = bar.getWsFooPort();  // Port
            List<String> getList = wsFoo.getList(); // Operation
            arg = "Hello from JAX-WS, " + arg;
            String getEcho = wsFoo.getEcho(arg); // Operation
            System.out.println(getList);
            System.out.println(getEcho);
        }
    }
}