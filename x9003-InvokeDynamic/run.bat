javac -d bin -cp asm-7.3.jar ^
  src/appl/FooInvokerGenerator.java ^
  src/appl/Foo.java ^
  src/appl/FooCallSites.java 

java -cp asm-7.3.jar;bin appl.FooInvokerGenerator
java -cp bin appl.FooInvoker
: javap -v bin/appl/FooInvoker.class
