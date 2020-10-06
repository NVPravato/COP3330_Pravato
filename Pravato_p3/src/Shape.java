public abstract class Shape {
    protected String name;
    protected double area;
    protected double volume;

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    public double getVolume(){
        return volume;
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

class Cube extends Shape3D{

    private String nameCu = "cube";
    private double side;
    private double areaCu;
    private double volumeCu;

    public Cube(double side){
        setSide(side);
        setName();
        setArea();
        setVolume();
    }

    public void setSide(double side){
        this.side = side;
        setThisArea(side);
        setThisVolume(side);
    }

    public void setThisArea(double side){
        this.areaCu = (6*(side*side));
    }

    public void setThisVolume(double side){
        this.volumeCu = (side*side*side);
    }

    public void setName(){
        name = nameCu;
    }

    public void setArea(){
        area = areaCu;
    }

    public void setVolume(){
        volume = volumeCu;
    }

}

class Pyramid extends Shape3D{

    private String nameP = "pyramid";
    private double length;
    private double width;
    private double height;
    private double areaP;
    private double volumeP;

    public Pyramid(double length, double width, double height){
        setSide(length, width, height);
        setName();
        setArea();
        setVolume();
    }

    public void setSide(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
        setThisArea(length, width, height);
        setThisVolume(length, width, height);
    }

    public void setThisArea(double length, double width, double height){
        double temp = (length*width) + (length * Math.sqrt( ((width/2)*(width/2)) + (height*height) )) + (width * Math.sqrt( ((length/2)*(length/2)) + (height*height)));
        this.areaP = temp;
    }

    public void setThisVolume(double length, double width, double height){
        this.volumeP = (length*width*height)/3;
    }

    public void setName(){
        name = nameP;
    }

    public void setArea(){
        area = areaP;
    }

    public void setVolume(){
        volume = volumeP;
    }

}

class Sphere extends Shape3D{

    private String nameSp = "sphere";
    private double radius;
    private double areaSp;
    private double volumeSp;

    public Sphere(double radius){
        setRadius(radius);
        setName();
        setArea();
        setVolume();
    }

    public void setRadius(double radius){
        this.radius = radius;
        setThisArea(radius);
        setThisVolume(radius);
    }

    public void setThisArea(double radius){
        this.areaSp = 4 * Math.PI * (radius*radius);
    }

    public void setThisVolume(double radius){
        this.volumeSp = (4 * Math.PI * (radius*radius*radius))/3;
    }

    public void setName(){
        name = nameSp;
    }

    public void setArea(){
        area = areaSp;
    }

    public void setVolume(){
        volume = volumeSp;
    }

}