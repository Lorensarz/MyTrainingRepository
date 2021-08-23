public class GeometryCalculator {

    // метод должен использовать абсолютное значение radius

    public static double getCircleSquare(double radius) {
        double area = Math.PI * (radius * radius);
        return area;
    }

    // метод должен использовать абсолютное значение radius

    public static double getSphereVolume(double radius) {
        double volume = (4*Math.PI*Math.pow(Math.abs(radius), 3))/3;
        return volume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }

    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0

    public static double getTriangleSquare(double a, double b, double c) {
        double p = ((a + b + c) / 2);
        double triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        if (!isTrianglePossible(a, b, c)) {
            return -1;
        } else {
            return triangleSquare;
        }
    }

}
