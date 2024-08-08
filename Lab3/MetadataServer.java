import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MetadataServer {
    private Map<String, Set<Integer>> fileLocations = new HashMap<>();

    public void addFileLocation(String filename, int serverId) {
        fileLocations.computeIfAbsent(filename, k -> new HashSet<>()).add(serverId);
    }

    public Set<Integer> getFileLocations(String filename) {
        return fileLocations.getOrDefault(filename, new HashSet<>());
    }
}
