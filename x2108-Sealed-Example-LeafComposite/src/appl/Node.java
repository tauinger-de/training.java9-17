package appl;

import java.util.List;
import java.util.function.BiConsumer;

@SuppressWarnings("preview")
public abstract sealed class Node permits Leaf, Composite {

    public abstract List<Node> nodes();

    public final void traverse(final int depth, final BiConsumer<Node, Integer> action) {
        action.accept(this, depth);
        for (final Node node : this.nodes()) {
            node.traverse(depth + 1, action);
        }
    }
}
