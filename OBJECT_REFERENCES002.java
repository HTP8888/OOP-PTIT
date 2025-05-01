import java.util.Scanner;

class Song{
     private String name;
     private String author;
     private int duration;
     public Song(String name, String author, int duration) {
         this.name = name;
         this.author = author;
         this.duration = duration;
     }
     public String getName() {
         return name;
     }
     public String getAuthor() {
         return author;
     }
     public int getDuration() {
         return duration;
     }
     public boolean equals(Song song){
         return this.name.equals(song.name) && this.author.equals(song.author) && this.duration == song.duration;
     }
}

public class OBJECT_REFERENCES002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] Song1Data = sc.nextLine().split(" ");
            String[] Song2Data = sc.nextLine().split(" ");
            Song s1 = new Song(Song1Data[0],Song1Data[1],Integer.parseInt(Song1Data[2]));
            Song s2 = new Song(Song2Data[0],Song2Data[1],Integer.parseInt(Song2Data[2]));
            System.out.println(s1.equals(s2));
        }
    }
}
