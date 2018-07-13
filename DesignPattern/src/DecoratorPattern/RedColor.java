package DecoratorPattern;

public class RedColor extends ShapeDecorator {

	public RedColor(Shape shape) {
		super(shape);
	}
	
	public void draw() {
		shape.draw();
		System.out.println("Color: red");
	}
}
