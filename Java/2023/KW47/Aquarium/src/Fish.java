
public class Fish {
    public enum WaterType {
        FRESHWATER,
        SALTWATER
    }

    public String type;
    public WaterType waterType;
    public Integer speed;

    public String bitmap;

    public Integer x;
    public Integer y;
    public boolean lookingRight = true;

    public Fish(String type, WaterType waterType, Integer speed, String bitmap) {
        this.type = type;
        this.waterType = waterType;
        this.speed = speed;
        this.bitmap = bitmap;
    }
}
