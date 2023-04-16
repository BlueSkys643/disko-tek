package LoginRegister;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class TestServer {
    public static final int port = 8000;
    private static ServerSocket ss = null;

    public static void runServer() throws IOException, ClassNotFoundException {
        ss = new ServerSocket(port);
        Socket socket = ss.accept();
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        System.out.println(is.read());
        os.writeObject(Registry.userMap);
        socket.close();
    }

    public static void main(String[] args) {
        try {
            runServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}