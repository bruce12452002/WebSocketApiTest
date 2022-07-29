package bruce.home.WebSocketApiTest.controller;

import bruce.home.WebSocketApiTest.config.MyWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketController {
    @GetMapping("/client")
    public String client() {
        List<Transport> transports = new ArrayList<>(2);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.doHandshake(new MyWebSocketHandler(), "ws://127.0.0.1:8080/myWebSocketHandler");

        System.out.println("handshake finish");
        return "SUCCESS";
    }

    @GetMapping("/js")
    public String js() {
        return "nasus.html";
    }
}
