import jj.operators2.TimesOperator;

module jj.operators2 {
    requires jj.operators.iface;
    provides jj.operators.iface.Operator with TimesOperator;
}
