package yaz.test;

import io.quarkus.websockets.next.OnBinaryMessage;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnPongMessage;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocketClient;
import io.quarkus.websockets.next.WebSocketClientConnection;
import io.vertx.core.buffer.Buffer;
import org.jboss.logging.Logger;

@WebSocketClient(path = "/")
public class TestWebSocketClient {
  private static final Logger LOG = Logger.getLogger(TestWebSocketClient.class);

  @OnTextMessage
  public void onMessage(String message, WebSocketClientConnection connection) {
    LOG.info("Received message: " + message + " " + connection.id());
  }

  @OnBinaryMessage
  public void onMessage(Buffer buffer, WebSocketClientConnection connection) {
    LOG.info("Received message: " + buffer.toString() + " " + connection.id());
  }

  @OnPongMessage
  public void onPong(Buffer buffer, WebSocketClientConnection connection) {
    LOG.info("Received pong: " + buffer.toString() + " " + connection.id());
  }

  @OnOpen
  public void onOpen(WebSocketClientConnection connection) {
    LOG.info("Connected to: " + connection.clientId() + " " + connection.id());
  }
}
