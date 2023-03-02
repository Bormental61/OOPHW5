import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидает соединения...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            University gb = new University();

            label:
            while (true) {
                dataOutputStream.writeUTF("""
                        Выберите пункт меню:\s
                         1 - добавить студента\s
                         2 - отчислить студента\s
                         3 - вывести список группы\s
                         0 - выход""");
                String clientRequest = dataInputStream.readUTF();
                switch (clientRequest) {
                    case "0":
                        break label;
                    case "1": {
                        dataOutputStream.writeUTF("Введите Имя студента: ");
                        String clientName = dataInputStream.readUTF();
                        dataOutputStream.writeUTF("Введите Фамилию студента: ");
                        String clientSurname = dataInputStream.readUTF();
                        dataOutputStream.writeUTF("Введите номер телефона студента: ");
                        int clientPhone = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF("Введите группу студента: ");
                        int clientGroup = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF(gb.addStudent(clientName, clientSurname, clientPhone, clientGroup));
                        break;
                    }
                    case "2": {
                        dataOutputStream.writeUTF("Введите данные студента: ");
                        dataOutputStream.writeUTF("Введите Имя студента: ");
                        String clientName = dataInputStream.readUTF();
                        dataOutputStream.writeUTF("Введите Фамилию студента: ");
                        String clientSurname = dataInputStream.readUTF();
                        dataOutputStream.writeUTF("Введите телефон студента: ");
                        int clientPhone = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF(gb.delStudent(clientName, clientSurname, clientPhone));
                        break;
                    }
                    case "3": {
                        dataOutputStream.writeUTF("Введите номер группы: ");
                        int clientGroup = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF(gb.getList(clientGroup));
                        break;
                    }
                    default:
                        dataOutputStream.writeUTF("Неверный запрос");
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


