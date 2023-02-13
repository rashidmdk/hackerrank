public class DoTheyBelong {
    public static void main(String[] args) {
        System.out.println(pointsBelong(3, 1, 7, 1, 5, 5, 1, 1, 2, 2));
    }

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {

        double ab = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double bc = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double ac = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        if ((ab + bc > ac) && (ac + ab > bc) && ((bc + ac) > ab)) {
            if (isInside(x1, y1, x2, y2, x3, y3, xp, yp) && !isInside(x1, y1, x2, y2, x3, y3, xq, yq)) {
                return 1;
            } else if (!isInside(x1, y1, x2, y2, x3, y3, xp, yp) && isInside(x1, y1, x2, y2, x3, y3, xq, yq)) {
                return 2;
            } else if (isInside(x1, y1, x2, y2, x3, y3, xp, yp) && isInside(x1, y1, x2, y2, x3, y3, xq, yq)) {
                return 3;
            } else {
                return 4;
            }
        } else {
            return 0;
        }
    }

    static boolean isInside(int x1, int y1, int x2,
                            int y2, int x3, int y3, int x, int y) {
        /* Calculate area of triangle ABC */
        double A = area(x1, y1, x2, y2, x3, y3);

        /* Calculate area of triangle PBC */
        double A1 = area(x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        double A2 = area(x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        double A3 = area(x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    static double area(int x1, int y1, int x2, int y2,
                       int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) +
                x3 * (y1 - y2)) / 2.0);
    }

}