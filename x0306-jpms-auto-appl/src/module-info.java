module jj.appl {
    requires jj.util;
    requires mod.A.X;  // Warning: Name of automatic module 'mod.A.X' is unstable, it is derived from the module's file name
    requires mod.BB.YY;
}