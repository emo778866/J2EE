//class C {
//}
//
//class D extends C {
//}
//
//class A {
//    public C getOBJ() {
//        System.out.println("class A - return C");
//        return new C();
//    }
//}
//
//class B extends A {
//    public D getOBJ() {
//        System.out.println("class B - return D");
//        return new D();
//    }
//}

public class Main {
    Main a = new Main() {
        public void tech() {
            System.out.println("anonymous tech");
        }
    };


    public static void main(String[] args) {
//        A a = new B();
//        a.getOBJ();
//        System.out.println();

    }

}

interface AInf {
    String toString();
}

class Tech {
    public void tech() {
        System.out.println("Tech");
    }
}