import java.util.HashMap;
import java.util.Map;

public class FileServer {
    private Map<String, byte[]> fileStorage = new HashMap<>();
    private int serverId;

    public FileServer(int serverId) {
        this.serverId = serverId;
    }

    public void storeFile(String filename, byte[] data) {
        fileStorage.put(filename, data);
        System.out.println("Stored file " + filename + " on server " + serverId);
    }

    public byte[] retrieveFile(String filename) {
        System.out.println("Retrieving file " + filename + " from server " + serverId);
        return fileStorage.get(filename);
    }
}
