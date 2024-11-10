import java.util.*;
import java.util.HashMap;
class Solution{
    public static void main(String[] args){
        HashMap<Integer, Chair> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            int height=sc.nextInt();
            sc.nextLine();
            int base=sc.nextInt();
            sc.nextLine();
            String material=sc.nextLine();
            map.put(id, new Chair(id, height, base, material));
        }
        int maxId=getMaxKey(map);
        System.out.println(map.get(maxId).getMaterial());
    }
    public static int getMaxKey(HashMap<Integer, Chair> map){
        int maxId=-1;
        for(int id:map.keySet()){
            if(id>maxId){
                maxId=id;
            }
        }
        return maxId;
    }
}

class Chair {
    private int id;
    private int height;
    private int base;
    private String material;
    Chair(int id, int height, int base, String material){
        this.id=id;
        this.height=height;
        this.base=base;
        this.material=material;
    }
    public int getId(){
        return id;
    }
    public int getHeight(){
        return height;
    }
    public int getBase(){
        return base;
    }
    public String getMaterial(){
        return material;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setHight(int height){
        this.height=height;
    }
    public void setBase(int base){
        this.base=base;
    }
    public void setMaterial(String material){
        this.material=material;
    }

}