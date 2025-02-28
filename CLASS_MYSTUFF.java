class MyStuff {
    private String name;

    MyStuff(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;
        MyStuff myStuff = (MyStuff) obj;
        return name.equals(myStuff.name);
    }
}
public class CLASS_MYSTUFF {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");
        if (m2.equals(m1))
            System.out.println("value compared: same");
        else
            System.out.println("value compared: different");
        if (m2 == m1)
            System.out.println("reference compared: same");
        else
            System.out.println("reference compared: different");
    }
}
