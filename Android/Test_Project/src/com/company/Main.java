package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //Question no.2
        /*byte a=100;
        short b= (short) (a*3);
        long l = 2000;
        double k = 284.24;
        byte c= (byte) k;
        int m=a;
        double d=b;
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);*/


        //Question no.3
        /*int y;
        int x=1;
        int total = 0;
        while (x<=10) {
            y = x * x;
            System.out.println(y);
            total += y;
            ++x;
        }
        System.out.printf("Total is %d\n", total);*/


        //Question no.4
        /*PointsOrShape s;
        s = new Circle(20,30,40);
        s.area();

        s = new Cylinder(20,30,40,50);
        s.area();*/


        //Thread
        /*ThreadA a = new ThreadA();
        a.start();

        TreadB b = new TreadB();
        b.start();*/


        //Custom Exception
        /*try{
            BankAccount.checkBalance(30);
            System.out.println("Everything is fine");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }*/


        //NAME:M.BHARGAVI...ROLL:20121A1268
/*AIM: A University awards some grace marks to students who participates in the Inter University games.
Therefore, total marks awarded =Exam_marks+Sports_Grace_Marks.If total marks scored are greater than
the MAXIMUM MARKS,then the final marks awwarded will be equal to the maximum marks.An object oriented
bases implementation will contain a class called Results,which extends a class called exam,which itself
extends a class called Student.It will also contain an interface called Sports,it is implemented by the
Result class.The Result class will be responsible for computing the final marks scored by the Students.
Write a java program along with an interactive driver class.*/
//PROGRAM:



/*import java.util.Scanner;
        interface sports68 {
            public void gracemarks68();
        }
        class Student68 {
            String myname68, myidnum68, mygender68;
            int myage68;
            Scanner s = new Scanner(System.in);

            void readdetails68(String name68, int age68, String idnum68, String gender68) {
                myname68 = name68;
                myage68 = age68;
                myidnum68 = idnum68;
                mygender68 = gender68;
            }

            void display68() {
                System.out.println("Name is:" + myname68);
                System.out.println("age is:" + myage68);
                System.out.println("Gender of" + myname68 + "is:" + mygender68);
                System.out.println("Roll number of" + myname68 + "is:" + myidnum68);
            }
        }
        class Exam68 extends Student68 {
            int marks68[] = new int[10];

            void readmarks68() {
                System.out.println("Enter the marks of 6 courses");
                for (int i = 0; i < 6; i++) {
                    System.out.println("Course" + (i + 1));
                    marks68[i] = s.nextInt();
                }
            }
        }
        class Results68 extends Exam68 implements sports68 {
            double Exam_marks68 = 0;
            char ch;

            void calculatetotal68() {
                System.out.println("total marks of 6 courses are:");
                for (int i = 0; i < 6; i++) {
                    Exam_marks68 = Exam_marks68 + marks68[i];
                }
                System.out.println(Exam_marks68);
            }

            public void gracemarks68() {
                double totalmarksawarded68 = 0;
                double sports_grace_marks68 = 50;
                System.out.println("Enter whether the Student participated in inter university games");
                ch = s.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    totalmarksawarded68 = Exam_marks68 + sports_grace_marks68;
                    if (totalmarksawarded68 > 600)
                        totalmarksawarded68 = 600;
                } else {
                    totalmarksawarded68 = Exam_marks68;
                }
                System.out.println("Final marks awarded is:" + totalmarksawarded68);
            }
        }
        class Examination68 {
            public static void main(String args[]) {
                {
                    System.out.println("*****Details of the student*****");
                    Results68 r = new Results68();
                    r.readdetails68("Bharu", 19, "F", "20121A1268");
                    r.display68();
                    r.readmarks68();
                    r.calculatetotal68();
                    r.gracemarks68();
                }

            }
        }*/





        /*public abstract class Animal {
            protected int legs;
            protected Animal(int legs)
            {
                this.legs=legs;
            }
            public void walk()
            {
                System.out.println("This animal walk by "+legs+" legs.");
            }
            public abstract void eat();
        }
        public class Cat extends Animal implements Pet {
            private String catName;
            public Cat()
            {
                this("");
            }
            public Cat(String name)
            {
                super(4);
                catName=name;
            }
            // @Override
            public void eat() {
                System.out.println("Cat eat fishes");
            }
            public String getName() {
                return catName;
            }
            public void setName(String name) {
                catName=name;
            }
            public void play() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }
        public class Fish extends Animal implements Pet {
            public Fish() {
                super(0);
            }
            private String fishName;
            //Override
            public void eat() {
                System.out.println("Fish eat plants");
            }
            public String getName() {
                return fishName;
            }
            public void setName(String name) {
                fishName = name;
            }
            public void play() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            //@Override
            public void walk()
            {
                System.out.println("Fish has no legs.");
            }
        }
        public class Spider extends Animal {
            public Spider()
            {
                super(8);
            }
            public void eat()
            {
                System.out.println("Spider eat insects");
            }
        }
        public interface Pet {
            public String getName();
            public void setName(String name);
            public void play();
        }
        public class TestAnimals {
            public static void main(String[] args) {
                Fish d = new Fish();
                Cat c = new Cat("Fluffy");
                Animal a = new Fish();
                Animal e = new Spider();
                Pet p = new Cat();
                d.setName("MyFish");
                d.eat();
                System.out.println("This fish's name is"+d.getName());
                d.walk();
                c.eat();
                System.out.println("This fish's name is"+c.getName());
                c.walk();
                ((Fish)a).setName("MyFish2");
                ((Fish)a).eat();
                System.out.println("This fish's name is"+((Fish)a).getName());
                ((Fish)a).walk();
                ((Spider)e).eat();
                ((Spider)e).walk();
                ((Cat)p).setName("MyCat");
                ((Cat)p).eat();
                System.out.println("This fish's name is"+((Cat)p).getName());
                ((Cat)p).walk();
            }
        }*/

        FileInputStream in=null;
        FileOutputStream out=null;

        try{
            in=new FileInputStream("input.txt");
            out=new FileOutputStream("output.txt");

            int o;
            while((o=in.read())!=-1)
            {
                out.write(o);
            }
        }
        catch(IOException e)
        {
            System.out.println("File not found..");
        }
        finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
