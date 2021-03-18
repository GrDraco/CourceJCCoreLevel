package homework.lesson_6;

import java.net.Socket;

public class ChatClient {
    private final IChatViewModel viewModel;
    private ReaderSocket reader;

    public ChatClient(IChatViewModel viewModel) throws Exception {
        if (viewModel == null)
            throw new Exception("ChatClient.viewModel is null");
        this.viewModel = viewModel;
    }

    public void Start() {
        try (Socket socket = new Socket(viewModel.getHost(),viewModel.getPort())) {
            viewModel.onStart();
            reader = new ReaderSocket(socket, viewModel, viewModel);
            reader.start();
            new WriterSocket(viewModel.getNickName(), socket, viewModel, viewModel).run();
        } catch (Exception e) {
            viewModel.onSetLog(e.toString());
        } finally {
            reader.interrupt();
            viewModel.onClose();
        }
    }
}
