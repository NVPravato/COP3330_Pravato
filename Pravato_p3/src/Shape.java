public abstract class Shape {
    protected String name;
    protected double area;

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }


}


abstract class Shape2D extends  Shape {



}



class Square extends Shape2D{
    private String nameS = "square";
    private double side;
    private double areaS;

    public Square(double side){
        setSide(side);
        setName();
        setArea();
    }

    public void setSide(double side){
        this.side = side;
        setThisArea(side);
    }

    public void setThisArea(double side){
        this.areaS = (side*side);
    }

    public void setName(){
        name = nameS;
    }

    public void setArea(){
        area = areaS;
    }

}

class Triangle extends Shape2D{
    private String nameT = "triangle";
    private double base;
    private double height;
    private double areaT;

    public Triangle(double base, double height){
        setBaseHeight(base, height);
        setName();
        setArea();
    }

    public void setBaseHeight(double base, double height){
        this.base = base;
        this.height = height;
        setThisArea(base, height);
    }

    public void setThisArea(double base, double height){
        this.areaT = ((base*height)/2);
    }

    public void setName(){
        name = nameT;
    }

    public void setArea(){
        area = areaT;
    }


}

class Circle extends Shape2D{
    private String nameC = "circle";
    private double radius;
    private double areaC;

    public Circle(double radius){
        setRadius(radius);
        setName();
        setArea();
    }

    public void setRadius(double radius){
        this.radius = radius;
        setThisArea(radius);
    }

    public void setThisArea(double radius){
        this.areaC = Math.PI * (radius*radius);
    }

    public void setName(){
        name = nameC;
    }

    public void setArea(){
        area = areaC;
    }


}

abstract class Shape3D extends  Shape {



}

