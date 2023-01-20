@jj.util.annotations.Author(name = "Nowak")
module jj.mod {

    requires jj.util;

    //exports jj.mod.pri;
    exports jj.mod.pub to jj.appl;

    opens jj.mod.pri;
    //opens jj.mod.pub;
}