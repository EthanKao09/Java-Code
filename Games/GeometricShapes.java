import java.util.Scanner;
import java.text.DecimalFormat;
public class GeometricShapes
{
	public static void GeometricShapes()throws InterruptedException{
		description();
		selection();
		
	}
	private static void description() throws InterruptedException{
		System.out.println("Which circle or sphere calculation will you like to start with?");
		System.out.println("1. Radius");
		System.out.println("2. Circle Circumference");
		System.out.println("3. Circle Area");
		System.out.println("4. Sphere Area");
		System.out.println("5. Sphere Volume");
	}
	private static void selection() throws InterruptedException{
		Scanner scan = new Scanner(System.in);
		int select1 = scan.nextInt();
		switch(select1) {
		case 1: givenRadius();
			int a = playAgain();
			if (a==1) {
				GeometricShapes();
			}
			else if (a==-1) {
				playAgain();
			}
			break;
		case 2: givenCircumference();
		int b = playAgain();
		if (b==1) {
			GeometricShapes();
		}
		else if (b==-1) {
			playAgain();
		}
		break;
		case 3: givenAreaCircle();
		int c = playAgain();
		if (c==1) {
			GeometricShapes();
		}
		else if (c==-1) {
			playAgain();
		}
		break;
		case 4: givenAreaSphere();
		int d = playAgain();
		if (d==1) {
			GeometricShapes();
		}
		else if (d==-1) {
			playAgain();
		}
		break;
		case 5: givenVolume();
		int e = playAgain();
		if (e==1) {
			GeometricShapes();
		}
		else if (e==-1) {
			playAgain();
		}
		break;
			}
	}
	private static void givenRadius() throws InterruptedException{
		System.out.println("Enter the radius");
		double radius, circumference, areaCircle, areaSphere, volume;
		Scanner scan = new Scanner(System.in);
		radius = scan.nextDouble();
		
		System.out.println("the radius of the circle: " + radius);
		circumference = (2 * Math.PI * radius);
		System.out.println("the circumference of the circle: " + circumference);
		areaCircle = (Math.PI * (radius * radius));
		System.out.println("the areaCircle of the circle: " + areaCircle);
		areaSphere = (4*Math.PI*(radius*radius));
		System.out.println("the areaSphere of the circle: " + areaSphere);
		volume = (4.0/3.0*Math.PI*Math.pow(radius, 3));
		System.out.println("the volume of the circle: " + volume);
	}
	
	private static void givenCircumference() throws InterruptedException{
		System.out.println("Enter the circumference");
		double radius, circumference, areaCircle, areaSphere, volume;
		Scanner scan = new Scanner(System.in);
		circumference = scan.nextDouble();
		
		radius = circumference/(2*Math.PI);
		System.out.println("the radius of the circle: " + radius);
		System.out.println("the circumference of the circle: " + circumference);
		areaCircle = (Math.PI * (radius * radius));
		System.out.println("the areaCircle of the circle: " + areaCircle);
		areaSphere = (4*Math.PI*(radius*radius));
		System.out.println("the areaSphere of the circle: " + areaSphere);
		volume = (4.0/3.0*Math.PI*Math.pow(radius, 3));
		System.out.println("the volume of the circle: " + volume);
	}
	
	private static void givenAreaCircle() throws InterruptedException{
		System.out.println("Enter the AreaCircle");
		double radius, circumference, areaCircle, areaSphere, volume;
		Scanner scan = new Scanner(System.in);
		areaCircle = scan.nextDouble();
		
		radius = Math.sqrt(areaCircle/Math.PI);
		Math.sqrt(radius);
		System.out.println("the radius of the circle: " + radius);
		circumference = (2 * Math.PI * radius);
		System.out.println("the circumference of the circle: " + circumference);
		System.out.println("the areaCircle of the circle: " + areaCircle);
		areaSphere = (4*Math.PI*(radius*radius));
		System.out.println("the areaSphere of the circle: " + areaSphere);
		volume = (4.0/3.0*Math.PI*Math.pow(radius, 3));
		System.out.println("the volume of the circle: " + volume);
	}
	
	private static void givenAreaSphere() throws InterruptedException{
		System.out.println("Enter the AreaSphere");
		double radius, circumference, areaCircle, areaSphere, volume;
		Scanner scan = new Scanner(System.in);
		areaSphere = scan.nextDouble();
		
		radius= Math.sqrt(areaSphere/ (4*Math.PI));
		Math.sqrt(radius);
		System.out.println("the radius of the circle: " + radius);
		circumference = (2 * Math.PI * radius);
		System.out.println("the circumference of the circle: " + circumference);
		areaCircle = (Math.PI * (radius * radius));
		System.out.println("the areaCircle of the circle: " + areaCircle);
		System.out.println("the areaSphere of the circle: " + areaSphere);
		volume = (4.0/3.0*Math.PI*Math.pow(radius, 3));
		System.out.println("the volume of the circle: " + volume);
	}
	
	private static void givenVolume() throws InterruptedException{
		System.out.println("Enter the Volume");
		double radius, circumference, areaCircle, areaSphere, volume;
		Scanner scan = new Scanner(System.in);
		volume = scan.nextDouble();
		
		radius = Math.cbrt(volume/(4.0/3.0*Math.PI));
		Math.cbrt(radius);
		System.out.println("the radius of the circle: " + radius);
		circumference = (2 * Math.PI * radius);
		System.out.println("the circumference of the circle: " + circumference);
		areaCircle = (Math.PI * (radius * radius));
		System.out.println("the areaCircle of the circle: " + areaCircle);
		areaSphere = (4*Math.PI*(radius*radius));
		System.out.println("the areaSphere of the circle: " + areaSphere);
		System.out.println("the volume of the circle: " + volume);
	}
	
	private static int playAgain() {
		System.out.println("Would you like to play again?");
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
			return 1;
		}
		else if (answer.charAt(0) == 'n' || answer.charAt(0)== 'N') {
			return 0;
		}
		else {
			return -1;
		}
		}
	}
