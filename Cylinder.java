import java.util.Scanner;

class Circle{

    public void circle_area(float r){
        float area;

        area = (float) (3.14 * r * r);
        System.out.println("Area of circle= " + area);

    }
}

public class Cylinder extends Circle{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cylinder c = new Cylinder();
        float radius, height, area_cyl, vol;

        System.out.println("Enter radius: ");
        radius=sc.nextFloat();
        System.out.println("Enter height: ");
        height=sc.nextFloat();

        c.circle_area(radius);

        area_cyl = (float) ((2 * 3.14 * radius * radius ) + (2 * 3.14 * radius *height));
        vol = (float) (3.14 * radius * radius * height);

        System.out.println("Area of Cylinder= " + area_cyl);
        System.out.println("Volume of Cylinder= " + vol);

    }
}
