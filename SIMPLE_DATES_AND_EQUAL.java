class SimpleDate {
    private String day;
    private String month;
    private String year;
    
    // Constructor
    public SimpleDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleDate that = (SimpleDate) obj;
        return day.equals(that.day) && month.equals(that.month) && year.equals(that.year);
    }
}

public class SIMPLE_DATES_AND_EQUAL {
    public static void main(String[] args) {
        SimpleDate givenDate = new SimpleDate("1", "2", "2000");
        SimpleDate date1 = new SimpleDate("h", "e", "h");
        SimpleDate date2 = new SimpleDate("5", "2", "2012");
        SimpleDate date3 = new SimpleDate("1", "2", "2000");
        System.out.println( givenDate.equals(date1)); 
        System.out.println( givenDate.equals(date2));
        System.out.println( givenDate.equals(date3)); 
    }
}
