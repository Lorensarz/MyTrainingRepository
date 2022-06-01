import java.util.concurrent.CopyOnWriteArraySet;

public class SiteMapNode {

    private final String url;
    private volatile SiteMapNode parent;
    private volatile int depth;
    private final CopyOnWriteArraySet<SiteMapNode> subLinks;

    public SiteMapNode(String url) {
        this.url = url;
        subLinks = new CopyOnWriteArraySet<>();
        depth = 0;
        parent = null;

    }

    public void addSubLinks(SiteMapNode subLink) {
        if (!subLinks.contains(subLink) && subLink.getUrl().startsWith(url)) {
            this.subLinks.add(subLink);
            subLink.setParent(this);
        }
    }

    private void setParent(SiteMapNode siteMapNode) {
        synchronized (this) {
            this.parent = siteMapNode;
            this.depth = setDepth();
        }
    }

    public String getUrl() {
        return url;
    }

    public int getDepth() {
        return depth;
    }

    public int setDepth() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.getDepth();
    }

    public CopyOnWriteArraySet<SiteMapNode> getSubLinks() {
        return subLinks;
    }

}
