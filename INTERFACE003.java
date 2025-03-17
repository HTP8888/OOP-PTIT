//made by HTP tai nha HUy LX 
// DCM thang DAO DUY KHOI tham sac bo ban
interface TacoBox{
    int tacosRemaining();
    void eat();
}
class TripleTacoBox implements TacoBox{
    int tacos = 3;

    public TripleTacoBox(int tacos) {
        this.tacos = tacos;
    }
    @Override
    public int tacosRemaining(){
        return tacos;
    }
    @Override
    public void eat(){
        if(tacos > 0){
            tacos -=1;
        }
    }

}
class CustomTacos implements TacoBox{
    public int tacos;

    public CustomTacos(int tacos) {
        this.tacos = tacos;
    }
    @Override
    public int tacosRemaining(){
        return tacos;
    }
    @Override
    public void eat(){
        if(tacos > 0){
            tacos -=1;
        }
    }
}
public class INTERFACE003 {
    public static void main(String[] args) {
        TripleTacoBox ttb = new TripleTacoBox(3);
        ttb.eat();
        ttb.eat();
        System.out.println("Triple taco boxes left: "+ttb.tacosRemaining());
        CustomTacos ct = new CustomTacos(8);
        ct.eat();
        System.out.println("Custom taco boxes left: "+ct.tacosRemaining());
    }
}
