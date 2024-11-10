import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>();
        ArrayList<Chair> chairs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            int height = sc.nextInt();
            sc.nextLine();
            int base = sc.nextInt();
            sc.nextLine();
            String material = sc.nextLine();
            chairs.add(new Chair(id, height, base, material));
        }
        TreeSet<String> ans = getUniqueMaterials(chairs);
        for (String obj : ans) {
            System.out.println(obj);
        }
    }

    public static TreeSet<String> getUniqueMaterials(ArrayList<Chair> chairs) {
        TreeSet<String> ans = new TreeSet<>();
        for (Chair obj : chairs) {
            ans.add(obj.getMaterial());
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

    public int getHeight() {
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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}