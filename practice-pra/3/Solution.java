import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Chair> chairs=new ArrayList<>();
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            int height=sc.nextInt();
            sc.nextLine();
            int base=sc.nextInt();
            sc.nextLine();
            String material=sc.nextLine();
            chairs.add(new Chair(id, height, base, material));
        }
        System.out.println(getChairWithHighestAirVolume(chairs).getId());
    }
    public static Chair getChairWithHighestAirVolume(ArrayList<Chair> chairs){
        int maxVolume=-1;
        Chair ans=null;
        for(Chair obj:chairs){
            int volume=obj.getHight()*obj.getBase();
            if(volume>maxVolume){
                maxVolume=volume;
                ans=obj;
            }
        }
        return ans;
    }
}


class Chair {
    private int id;
    private int height;
    private int base;
    private String material;

    Chair(int id, int height, int base, String material) {
        this.id = id;
        this.height = height;
        this.base = base;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public int getHight() {
        return height;
    }

    public int getBase() {
        return base;
    }

    public String getMaterial() {
        return material;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHight(int height) {
        this.height = height;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}