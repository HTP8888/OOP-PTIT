import java.text.DecimalFormat;
import java.util.*;

abstract class Asset {
    private String name;
    private double value;
    private Date acquisitionDate;

    public Asset(String name, double value, Date acquisitionDate) {
        this.name = name;
        this.value = value;
        this.acquisitionDate = acquisitionDate;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public abstract double getDepreciation();
}

class FixedAsset extends Asset {
    private int usefulLife;

    public FixedAsset(String name, double value, Date acquisitionDate, int usefulLife) {
        super(name, value, acquisitionDate);
        this.usefulLife = usefulLife;
    }

    @Override
    public double getDepreciation() {
        return getValue() / usefulLife;
    }
}

class CurrentAsset extends Asset {
    private double liquidationValue;

    public CurrentAsset(String name, double value, Date acquisitionDate, double liquidationValue) {
        super(name, value, acquisitionDate);
        this.liquidationValue = liquidationValue;
    }

    @Override
    public double getDepreciation() {
        return getValue() * 0.1;
    }
}

class IntangibleAsset extends Asset {
    private int amortizationPeriod;

    public IntangibleAsset(String name, double value, Date acquisitionDate, int amortizationPeriod) {
        super(name, value, acquisitionDate);
        this.amortizationPeriod = amortizationPeriod;
    }

    @Override
    public double getDepreciation() {
        return getValue() / amortizationPeriod;
    }
}

class AssetManager {
    private List<Asset> assetList = new ArrayList<>();

    public void addAsset(Asset asset) {
        assetList.add(asset);
    }

    public double getTotalValue() {
        double total = 0;
        for (Asset a : assetList) {
            total += a.getValue();
        }
        return total;
    }

    public double getTotalDepreciation() {
        double total = 0;
        for (Asset a : assetList) {
            total += a.getDepreciation();
        }
        return total;
    }

    public void displayAssets() {
        DecimalFormat df = new DecimalFormat("#0.0");
        for (Asset a : assetList) {
            System.out.println("Asset Name: " + a.getName());
            System.out.println("Asset Value: " + df.format(a.getValue()));
            System.out.println("Depreciation: " + df.format(a.getDepreciation()));
            System.out.println("---------------------------");
        }
        System.out.println("Total Value of Assets: " + df.format(getTotalValue()));
        System.out.println("Total Depreciation of Assets: " + df.format(getTotalDepreciation()));
    }
}

public class INHERITANCE011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng còn lại sau nextInt

        AssetManager manager = new AssetManager();
        Date now = new Date();

        while (t-- > 0) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            double value = Double.parseDouble(parts[2]);

            if (type.equals("FixedAsset")) {
                int usefulLife = Integer.parseInt(parts[3]);
                manager.addAsset(new FixedAsset(name, value, now, usefulLife));
            } else if (type.equals("CurrentAsset")) {
                double liquidationValue = Double.parseDouble(parts[3]);
                manager.addAsset(new CurrentAsset(name, value, now, liquidationValue));
            } else if (type.equals("IntangibleAsset")) {
                int amortizationPeriod = Integer.parseInt(parts[3]);
                manager.addAsset(new IntangibleAsset(name, value, now, amortizationPeriod));
            }
        }

        manager.displayAssets();
    }
}

