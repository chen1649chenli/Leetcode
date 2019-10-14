import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _588DesignInMemoryFileSystem {
    private File root;

    private class File{
        boolean isFile;
        String name;
        String content;
        Map<String, File> children = new HashMap<>();
    }

    public _588DesignInMemoryFileSystem() {
        this.root = new File();
        this.root.name = "";
    }

    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        File curr = this.root;

        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i += 1){
            String currDir = dirs[i];
            curr = curr.children.get(currDir);
        }
        if (curr.isFile){
            ans.add(curr.name);
        }else{
            for (String name: curr.children.keySet()){
                ans.add(name);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        File curr = this.root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i += 1){
            String currDir = dirs[i];
            if (!curr.children.containsKey(currDir)){
                curr.children.put(currDir, new File());
            }
            curr = curr.children.get(currDir);
            curr.name = currDir;
        }
    }

    public void addContentToFile(String filePath, String content) {
        File curr = this.root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i += 1){
            String currDir = dirs[i];
            if (!curr.children.containsKey(currDir)){
                curr.children.put(currDir, new File());
            }
            curr = curr.children.get(currDir);
            curr.name = currDir;
        }
        curr.isFile = true;

        curr.content = (curr.content == null)?content: curr.content + content;
    }

    public String readContentFromFile(String filePath) {
        File curr = this.root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i += 1){
            String currDir = dirs[i];
            curr = curr.children.get(currDir);
        }
        return curr.content;
    }
}
