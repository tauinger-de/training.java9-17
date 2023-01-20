module jj.modA {

    requires jj.util;
    requires jj.modB;

    exports jj.modA.alpha;
    opens jj.modA.alpha;
}
