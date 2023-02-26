import java.util.ArrayList;
import java.util.List;

class House extends Property {
    public House(double price, int area, int roomCount, int livingRoomCount) {
        super("House", price, area, roomCount, livingRoomCount);
    }
}

class Villa extends Property {
    public Villa(double price, int area, int roomCount, int livingRoomCount) {
        super("Villa", price, area, roomCount, livingRoomCount);
    }
}

class SummerHouse extends Property {
    public SummerHouse(double price, int area, int roomCount, int livingRoomCount) {
        super("SummerHouse", price, area, roomCount, livingRoomCount);
    }
}

class PropertyService {
    private List<Property> properties;

    public PropertyService() {
        properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public List<Property> getPropertiesByType(String type) {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property.getType().equals(type)) {
                result.add(property);
            }
        }
        return result;
    }

    public double getTotalPriceByType(String type) {
        double total = 0;
        for (Property property : properties) {
            if (property.getType().equals(type)) {
                total += property.getPrice();
            }
        }
        return total;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Property property : properties) {
            total += property.getPrice();
        }
        return total;
    }

    public double getAverageAreaByType(String type) {
        double totalArea = 0;
        int count = 0;
        for (Property property : properties) {
            if (property.getType().equals(type)) {
                totalArea += property.getArea();
                count++;
            }
        }
        if (count > 0) {
            return totalArea / count;
        } else {
            return 0;
        }
    }

    public double getAverageArea() {
        double totalArea = 0;
        for (Property property : properties) {
            totalArea += property.getArea();
        }
        return totalArea / properties.size();
    }

    public List<Property> filterByRoomCountAndLivingRoomCount(int roomCount, int livingRoomCount) {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property.getRoomCount() == roomCount && property.getLivingRoomCount() == livingRoomCount) {
                result.add(property);
            }
        }
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        PropertyService propertyService = new PropertyService();  // PropertyService sınıfından bir örnek oluşturuyoruz

        // Ev, villa ve yazlık tiplerinde 6 adet özellik ekliyoruz
        propertyService.addProperty(new House(100000, 100, 3, 1));
        propertyService.addProperty(new House(150000, 120, 4, 2));
        propertyService.addProperty(new Villa(300000, 200, 5, 3));
        propertyService.addProperty(new Villa(400000, 250, 6, 4));
        propertyService.addProperty(new SummerHouse(50000, 50, 2, 1));
        propertyService.addProperty(new SummerHouse(75000, 80, 3, 1));

        List<Property> houses = propertyService.getPropertiesByType("House");
        List<Property> villas = propertyService.getPropertiesByType("Villa");
        List<Property> summerHouses = propertyService.getPropertiesByType("SummerHouse");

        // Ev tipindeki özellikleri alıyoruz ve konsola yazdırıyoruz
        System.out.println("House list:");
        for (Property property : houses) {
            System.out.println(property.getType() + " - Price: " + property.getPrice() + ", Area: " + property.getArea() + ", Room Count: " + property.getRoomCount() + ", Living Room Count: " + property.getLivingRoomCount());
        }
        System.out.println();

        System.out.println("Villa list:");
        for (Property property : villas) {
            System.out.println(property.getType() + " - Price: " + property.getPrice() + ", Area: " + property.getArea() + ", Room Count: " + property.getRoomCount() + ", Living Room Count: " + property.getLivingRoomCount());
        }
        System.out.println();

        System.out.println("Summer house list:");
        for (Property property : summerHouses) {
            System.out.println(property.getType() + " - Price: " + property.getPrice() + ", Area: " + property.getArea() + ", Room Count: " + property.getRoomCount() + ", Living Room Count: " + property.getLivingRoomCount());
        }
        System.out.println();

        System.out.println("Total price of houses: " + propertyService.getTotalPriceByType("House"));
        System.out.println("Total price of villas: " + propertyService.getTotalPriceByType("Villa"));
        System.out.println("Total price of summer houses: " + propertyService.getTotalPriceByType("SummerHouse"));
        System.out.println("Total price of all properties: " + propertyService.getTotalPrice());
        System.out.println();

        System.out.println("Average area of houses: " + propertyService.getAverageAreaByType("House"));
        System.out.println("Average area of villas: " + propertyService.getAverageAreaByType("Villa"));
        System.out.println("Average area of summer houses: " + propertyService.getAverageAreaByType("SummerHouse"));
        System.out.println("Average area of all properties: " + propertyService.getAverageArea());
        System.out.println();

        List<Property> filteredProperties = propertyService.filterByRoomCountAndLivingRoomCount(4, 2);
        System.out.println("Properties filtered by room count=4 and living room count=2:");
        for (Property property : filteredProperties) {
            System.out.println(property.getType() + " - Price: " + property.getPrice() + ", Area: " + property.getArea() + ", Room Count: " + property.getRoomCount() + ", Living Room Count: " + property.getLivingRoomCount());
        }
    }
}
