package DecoratorPattern;

public class BlueColor extends ShapeDecorator {

	public BlueColor(Shape shape) {
		super(shape);
	}
	
	public void draw() {
		shape.draw();
		System.out.println("Color: blue");
	}
}
