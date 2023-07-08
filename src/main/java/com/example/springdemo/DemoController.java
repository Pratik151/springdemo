package com.example.springdemo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    public static final String MESSAGE_KEY = "message";
    public static final String HOSTNAME_KEY = "hostname";
    public static final String IP_KEY = "ip";

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> helloWorld() throws UnknownHostException {
        return getResponse();
    }

    private Map<String, String> getResponse() throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostName();
        String ip = InetAddress.getLocalHost().getHostAddress();
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "Hello World!");
        response.put(HOSTNAME_KEY, host);
        response.put(IP_KEY, ip);
        System.out.println("Returning " + response);
        return response;
    }

}
