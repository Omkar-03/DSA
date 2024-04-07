package OOPs;

public class OOPS_2 {
    public static void main(String args[]) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();

        Mustang m = new Mustang();

        // Animal a = new Animal(); // Cannot create a constructor of Abstract class

        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eatsGrass();
        b.eatsMeat();

        // calls parameterized constructor 4
        Derived obj = new Derived("test");
        // Calls No-argument constructor
        // Derived obj = new Derived();
    }
}

// Abstract classes
abstract class Animal {
    String color;

    Animal() {
        color = "brown";
        System.out.println("Animal constructor called");
    }

    void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }

    void changeColor() {
        color = "Dark brown";
    }

    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Chicken constructor called");
    }

    void changeColor() {
        color = "Yellow";
    }

    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}

// Interface
interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal by one step");
    }
}

// Multiple level inheritance using interface
interface Herbivore {
    void eatsGrass();
}

interface Carnivore {
    void eatsMeat();
}

class Bear implements Herbivore, Carnivore {
    public void eatsGrass() {
        System.out.println("Eats grass");
    }

    public void eatsMeat() {
        System.out.println("Eats meat");
    }
}

// Constructor chaining
class Base {
    String name;

    // constructor 1
    Base() {
        this("");
        System.out.println("No-argument constructor of" +
                " base class");
    }

    // constructor 2
    Base(String name) {
        this.name = name;
        System.out.println("Calling parameterized constructor"
                + " of base");
    }
}

class Derived extends Base {
    // constructor 3
    Derived() {
        System.out.println("No-argument constructor " +
                "of derived");
    }

    // parameterized constructor 4
    Derived(String name) {
        // invokes base class constructor 2
        super(name);
        System.out.println("Calling parameterized " +
                "constructor of derived");
    }
}

// My logic for operations on complex number

// public class OOPS_2 {
// public static void main(String args[]) {
// Complex c = new Complex();
// c.addition();
// System.out.println("Addition: " + c.add_real + " + " + c.add_imaginary + " i
// ");
// }
// }

// class Complex {
// static Scanner om = new Scanner(System.in);
// int real_1, imaginary_1;
// int real_2, imaginary_2;
// int add_real, add_imaginary;

// void addition() {
// System.out.println("Enter real and imaginary part of first complex number:
// ");
// real_1 = om.nextInt();
// imaginary_1 = om.nextInt();
// System.out.println("Enter real and imaginary pasrt of second complex number:
// ");
// real_2 = om.nextInt();
// imaginary_2 = om.nextInt();
// add_real = real_1 + real_2;
// add_imaginary = imaginary_1 + imaginary_2;
// }
// }

// Solution of Apna College for operation on complex numbers

// class Complex {
// int real, imag;

// public Complex(int r, int i) {
// real = r;
// imag = i;
// }

// public static Complex add(Complex a, Complex b) {
// return new Complex((a.real + b.real), (a.imag + b.imag));
// }

// public static Complex diff(Complex a, Complex b) {
// return new Complex((a.real - b.real), (a.imag - b.imag));
// }

// public static Complex product(Complex a, Complex b) {
// return new Complex(((a.real * b.real) - (a.imag * b.imag)), ((a.real *
// b.imag) + (a.imag * b.real)));
// }

// public void printComplex() {
// if (real == 0 && imag != 0) {
// System.out.println(imag + "i");
// } else if (imag == 0 && real != 0) {
// System.out.println(real);
// } else {
// System.out.println(real + " + " + imag + "i");
// }
// }
// }

// public class OOPS_2 {
// public static void main(String args[]) {
// Complex c = new Complex(4, 5);
// Complex d = new Complex(9, 4);

// Complex e = Complex.add(c, d);
// Complex f = Complex.diff(c, d);
// Complex g = Complex.product(c, d);
// e.printComplex();
// f.printComplex();
// g.printComplex();
// }
// }
