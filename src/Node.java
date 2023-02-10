import java.io.File;
import java.util.ArrayList;

public class Node {

    private File folder;
    private ArrayList<Node> children;
    private long size;
    private long sizeLimit;
    private int level;

    public Node (File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 2);
        node.setSizeLimit(sizeLimit);
        children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public void setSizeLimit(long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children) {
            if (child.getSize() > sizeLimit) {
                builder.append(" ".repeat(child.getLevel()) + child);
            }
        }
        return builder.toString();
    }
}
