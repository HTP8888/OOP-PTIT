import java.util.*;
class Song{
    private String name;
    private String author;
    private int duration;

    public Song(String name, String author, int duration) {
        this.author = author;
        this.duration = duration;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public boolean equals(Song song) {
        return this.name.equals(song.getName()) && this.author.equals(song.getAuthor()) && this.duration == song.getDuration();
    }
}
public class OBJECT_REFERENCES002_Song_comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] song1Data = sc.nextLine().split(" ");
            String[] song2Data = sc.nextLine().split(" ");
            Song song1 = new Song(song1Data[0], song1Data[1], Integer.parseInt(song1Data[2]));
            Song song2 = new Song(song2Data[0],song2Data[1],Integer.parseInt(song2Data[2]));
            System.out.println(song1.equals(song2));
        }
        sc.close();
    }
}
