package bowtruckle.mods.gods.tools;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3 add(Vector3 addend) {
        return new Vector3(x + addend.getX(), y + addend.getY(), z + addend.getZ());
    }

    public Vector3 subtract(Vector3 addend) {
        return new Vector3(x - addend.getX(), y - addend.getY(), z - addend.getZ());
    }

    public boolean compare(Vector3 Input) {
        return (this.x == Input.getX()) && (this.y == Input.getY()) && (this.z == Input.getZ());
    }

    public void roundToDecimal(int decimals) {
        this.x = (int) (this.x*Math.pow(10,decimals));
        this.y = (int) (this.y*Math.pow(10,decimals));
        this.z= (int) (this.z*Math.pow(10,decimals));
    }

}
