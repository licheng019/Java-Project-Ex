package DecoratorPattern;

public class DottedBorder extends ShapeDecorator {

	public DottedBorder(Shape shape) {
		super(shape);
	}
	
	public void draw() {
		shape.draw();
		System.out.println("Border: Dotted");
	}

}
