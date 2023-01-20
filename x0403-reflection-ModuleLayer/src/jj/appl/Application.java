package jj.appl;

import java.lang.module.Configuration;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.module.ResolvedModule;
import java.util.Optional;
import java.util.stream.Stream;

import jj.util.log.Log;

public class Application {
    public static void main(String[] args) throws Exception {
        demoModuleLayer();
        demoModuleReader("jj.appl");
    }

    private static void printModule(ResolvedModule m) {
        System.out.println(m.name());
        m.reads().forEach(r -> System.out.println("\t" + r.name()));
        System.out.println("\t=> " + m.reference());
    }

    static void demoModuleLayer() {
        Log.logMethodCall();
        final ModuleLayer l = ModuleLayer.boot();
        System.out.println("Modules");
        l.modules().forEach(System.out::println);
        final Configuration c = l.configuration();
        System.out.println("Configuration.Modules");
        c.modules().forEach(m -> printModule(m));
    }

    static void demoModuleReader(String moduleName) throws Exception {
        Log.logMethodCall();
        System.out.println("Inspecting " + moduleName);
        final Optional<ResolvedModule> optionalResolvedModule = ModuleLayer.boot().configuration().findModule(moduleName);
        if (!optionalResolvedModule.isPresent())
            return;
        final ResolvedModule resolvedModule = optionalResolvedModule.get();
        final ModuleReference moduleReference = resolvedModule.reference();
        printModule(resolvedModule);

        try (ModuleReader reader = moduleReference.open()) {
            final Stream<String> stream = reader.list();
            stream.forEach(System.out::println);
        }
    }
}
