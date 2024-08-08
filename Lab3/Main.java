public class Main {
    public static void main(String[] args) {
        // Create servers
        FileServer server1 = new FileServer(0);
        FileServer server2 = new FileServer(1);
        FileServer server3 = new FileServer(2);
        FileServer[] servers = {server1, server2, server3};

        // Create metadata server
        MetadataServer metadataServer = new MetadataServer();

        // Create DFS client
        DFSClient client = new DFSClient(servers, metadataServer);

        // Store a file
        String filename = "example.txt";
        byte[] data = "Hello, Distributed File System!".getBytes();
        client.storeFile(filename, data);

        // Retrieve the file
        byte[] retrievedData = client.retrieveFile(filename);
        if (retrievedData != null) {
            System.out.println("Retrieved file content: " + new String(retrievedData));
        }
    }
}
