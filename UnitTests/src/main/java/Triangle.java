class Triangle {
    boolean isPossible(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0) return a + b > c && a + c > b && b + c > a;
        else return false;
    }
}
