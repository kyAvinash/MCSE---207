import java.util.Set;

public class DFSClient {
    private FileServer[] servers;
    private MetadataServer metadataServer;

    public DFSClient(FileServer[] servers, MetadataServer metadataServer) {
        this.servers = servers;
        this.metadataServer = metadataServer;
    }

    public void storeFile(String filename, byte[] data) {
        int primaryServerId = 0; // Simplification: primary server
        servers[primaryServerId].storeFile(filename, data);
        metadataServer.addFileLocation(filename, primaryServerId);

        // Replicate file to other servers
        for (int i = 1; i < servers.length; i++) {
            servers[i].storeFile(filename, data);
            metadataServer.addFileLocation(filename, i);
        }
    }

    public byte[] retrieveFile(String filename) {
        Set<Integer> serverIds = metadataServer.getFileLocations(filename);
        if (serverIds.isEmpty()) {
            System.out.println("File not found.");
            return null;
        }

        // Retrieve from the primary server (simplification)
        return servers[serverIds.iterator().next()].retrieveFile(filename);
    }
}
