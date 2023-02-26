import java.util.ArrayList;
import java.util.List;

public class PropertyService {
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

    