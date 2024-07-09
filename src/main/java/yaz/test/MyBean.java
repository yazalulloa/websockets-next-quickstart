package yaz.test;

import io.quarkus.websockets.next.WebSocketClientConnection;
import io.quarkus.websockets.next.WebSocketConnector;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.net.URI;

@Singleton
public class MyBean {

  @Inject
  WebSocketConnector<TestWebSocketClient> connector;

  public void openAndSendMessage() {
    WebSocketClientConnection connection = connector
        .baseUri(URI.create("https://echo.websocket.org"))
        .connectAndAwait();
    connection.sendTextAndAwait("Hi!");
  }
}
