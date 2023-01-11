package appl;

//sealed class A<T> permits B<T> {
//	
//}
//final class B<T> extends A<? extends T> {
//	
//}
//@SuppressWarnings("preview")
public class Application {
	public static void main(String[] args) {
		Window window = new Window();
		Panel panel0 = new Panel();
		Panel panel1 = new Panel();
		Button button0 = new Button();
		Button button1 = new Button();
		TextField textField0 = new TextField();
		TextField textField1 = new TextField();
		window.add(panel0);
		window.add(panel1);
		panel0.add(button0);
		panel0.add(textField0);
		panel1.add(button1);
		panel1.add(textField1);
		window.traverse(0, (node, depth) -> {
			while (depth --> 0)
				System.out.print("\t");
			System.out.println(node);
		});
	}
}
