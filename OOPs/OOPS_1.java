package OOPs;

public class OOPS_1 {
    public static void main(String args[]) {
        Pen p1 = new Pen();
        // p1.setColor("Blue");
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        BankAccount myAcc = new BankAccount();
        myAcc.username = "OmkarParab";
        myAcc.setPassword("abcd");

        Student s1 = new Student();
        s1.name = "Omkar";
        s1.roll = 84;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        Student s2 = new Student("Omkar");
        Student s3 = new Student(s1);
        s1.marks[2] = 100;

        for (int i = 0; i < 3; i++) {
            System.out.println(s3.marks[i]);
        }

    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }

}

class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    void setColor(String newcolor) {
        color = newcolor;
    }

    int getTip() {
        return this.tip;
    }

    void setTip(int tip) {
        this.tip = tip; // Here (this) is useful as both the variables have same name tip.
    }
}

class Student {
    String name;
    int roll;
    int marks[];

    Student() { // Non-parameterized constructor
        marks = new int[3];
        System.out.println("constructor is called ...");
    }

    Student(String name) { // Parameterized constructor
        this.name = name;
    }

    // Student(Student s1) // Shallow copy constructor
    // {
    // marks = new int[3];
    // this.name = s1.name;
    // this.roll = s1.roll;
    // this.marks = s1.marks;
    // }

    Student(Student s1) // Deep copy constructor
    {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for (int i = 0; i < 3; i++) {
            this.marks[i] = s1.marks[i];
        }
    }
}