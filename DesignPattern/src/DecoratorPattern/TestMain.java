package DecoratorPattern;

public class TestMain {
	public static void main(String[] args) {
		Shape circle = new Circle();
		RedColor red = new RedColor(circle);
		red.draw();
		System.out.println("----------");
		Shape square = new Square();
		BlueColor blue = new BlueColor(square);
		DottedBorder dotted = new DottedBorder(blue);
		dotted.draw();
	}
}
