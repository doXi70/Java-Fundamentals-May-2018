package P02_ParseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] url = reader.readLine().split("://");

        if (url.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = url[0];
        String server = url[1].substring(0, url[1].indexOf("/"));
        String resource = url[1].substring(url[1].indexOf("/") + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resource);
    }
}
