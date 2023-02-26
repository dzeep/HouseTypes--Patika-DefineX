public class Property {
    private String type;
    private double price;
    private int area;
    private int roomCount;
    private int livingRoomCount;

    public Property(String type, double price, int area, int roomCount, int livingRoomCount) {
        this.type = type;
        this.price = price;
        this.area = area;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }

    // Getter ve setter metotları

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getArea() {
        return area;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }
}

    