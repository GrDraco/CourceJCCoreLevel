package homework.lesson_6;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private final String WAITING_CONNECT_CLIENT = "Ожидаем подключение клиента";
    private final String CONNECTED_CLIENT = "Клиент подключился";

    private final IChatViewModel viewModel;
    private WriterSocket writer;

    public ChatServer(IChatViewModel viewModel) throws Exception {
        if (viewModel == null)
            throw new Exception("ChatServer.viewModel is null");
        this.viewModel = viewModel;
    }

    public void Start() {
        try (ServerSocket serverSocket = new ServerSocket(viewModel.getPort())) {
            viewModel.onStart();
            viewModel.onSetLog(WAITING_CONNECT_CLIENT);
            Socket socket = serverSocket.accept();
            writer = new WriterSocket(viewModel.getNickName(), socket, viewModel, viewModel);
            writer.start();
            viewModel.onSetLog(CONNECTED_CLIENT);
            new ReaderSocket(socket, viewModel, viewModel).run();
        } catch (Exception e) {
            viewModel.onSetLog(e.toString());
        } finally {
            writer.interrupt();
            viewModel.onClose();
        }
    }
}
