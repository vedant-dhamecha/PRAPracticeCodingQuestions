import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bike[] b = new Bike[n];
        for (int i = 0; i < n; i++) {
            int bikeNo = sc.nextInt();
            sc.nextLine();
            String bikeName = sc.nextLine();
            String category = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            b[i]=new Bike(bikeNo, bikeName, category, price);
        }
        String searchCategory = sc.nextLine();
        String searchBikeByName = sc.nextLine();
        System.out.println("Average Price-" + findAveragePriceByCategory(b, searchCategory));
        Bike ans = searchBikeByName(b, searchBikeByName);
        System.out.println("number-" + ans.getBikeNo());
        System.out.println("name-" + ans.getBikeName());
        System.out.println("category-" + ans.getCategory());
        System.out.println("price-" + ans.getPrice());
    }

    public static double findAveragePriceByCategory(Bike[] b, String searchCategory) {
        double sum = 0;
        int count = 0;
        for (Bike obj : b) {
            if (obj.getCategory().equals(searchCategory)) {
                sum = sum + obj.getPrice();
                count = count + 1;
            }
        }
        double average = sum / count;
        return average;
    }

    public static Bike searchBikeByName(Bike[] b, String searchBikeByName) {
        Bike ans = null;
        for (Bike obj : b) {
            if (obj.getBikeName().equals(searchBikeByName)) {
                ans = obj;
                break;
            }
        }
        return ans;
    }
}

class Bike {
    private int bikeNo;
    private String bikeName;
    private String category;
    private double price;

    Bike(int bikeNo, String bikeName, String category, double price) {
        this.bikeNo = bikeNo;
        this.bikeName = bikeName;
        this.category = category;
        this.price = price;
    }

    public int getBikeNo() {
        return this.bikeNo;
    }

    public String getBikeName() {
        return this.bikeName;
    }

    public String getCategory() {
        return this.category;
    }

    public double getPrice() {
        return this.price;
    }

    public void setBikeNo(int bikeNo) {
        this.bikeNo = bikeNo;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}