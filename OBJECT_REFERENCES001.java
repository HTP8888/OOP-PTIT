class SimpleDate {
    private int day;
    private int month;
    private int year;
    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SimpleDate)) return false;
        SimpleDate other = (SimpleDate) obj;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }
}

public class OBJECT_REFERENCES001  {
    public static void main(String[] args) {
        SimpleDate givenDate = new SimpleDate(1, 2, 2000);
        String date1 = "heh";
        SimpleDate date2 = new SimpleDate(5, 2, 2012);
        SimpleDate date3 = new SimpleDate(1, 2, 2000);
        System.out.println(givenDate.equals(date1));
        System.out.println(givenDate.equals(date2));
        System.out.println(givenDate.equals(date3));
    }
}




