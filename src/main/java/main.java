import java.util.Hashtable;

public class main {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("kim", "25살 남");
        hashtable.put("park", "22살 여");
        hashtable.put("lee", "20살 남");
        hashtable.put("lee", "30살 여");
        System.out.println(hashtable.get("kim"));
        System.out.println(hashtable.get("park"));
        System.out.println(hashtable.get("lee"));

    }
}
