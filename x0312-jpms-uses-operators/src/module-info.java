import jj.operators.MinusOperator;
import jj.operators.PlusOperator;

module jj.operators {
    requires jj.operators.iface;
    provides jj.operators.iface.Operator with MinusOperator, PlusOperator;
}
