package appl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("preview")
public non-sealed class Composite extends Node {
    private final List<Node> nodes = new ArrayList<>();

    public void add(Node node) {
        this.nodes.add(node);
    }

    @Override
    public List<Node> nodes() {
        return Collections.unmodifiableList(this.nodes);
    }

}
