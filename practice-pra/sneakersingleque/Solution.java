import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sneaker s[] = new Sneaker[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int availableStock = sc.nextInt();
            sc.nextLine();
            int price = sc.nextInt();
            s[i] = new Sneaker(id, name, availableStock, price);
        }
        int searchId = sc.nextInt();

        int totalStock = findTotalAvailableStock(s);
        if (totalStock != 0) {
            System.out.println("Total Stock : " + totalStock);
        } else {
            System.out.println("No Sneaker found with mentioned attribute.");
        }

        Sneaker ans = searchSneakerById(s, searchId);
        if (ans != null) {
            System.out.println("id-" + ans.getId());
            System.out.println("name-" + ans.getName());
            System.out.println("availableStock-" + ans.getavailableStock());
            System.out.println("price-" + ans.getPrice());
        } else {
            System.out.println("No Sneaker found with mentioned attribute.");
        }
    }

    public static int findTotalAvailableStock(Sneaker[] s) {
        int totalStock = 0;
        for (Sneaker obj : s) {
            totalStock = totalStock + obj.getavailableStock();
        }
        return totalStock;
    }

    public static Sneaker searchSneakerById(Sneaker[] s, int searchId) {
        Sneaker ans = null;
        for (Sneaker obj : s) {
            if (searchId == obj.getId()) {
                ans = obj;
            }
        }
        return ans;
    }
}

class Sneaker {
    private int id;
    private String name;
    private int availableStock;
    private int price;

    Sneaker(int id, String name, int availableStock, int price) {
        this.id = id;
        this.name = name;
        this.availableStock = availableStock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getavailableStock() {
        return availableStock;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setavailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

}