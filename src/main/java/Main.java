public class Main {
    public static void main(String[] args) {
        for (int r : new Randoms(90, 100)) {
            System.out.println("Generate random number: " + r);
            if (r == 100) {
                System.out.println("Generated number is 100. Let's stop on this number");
                break;
            }
        }
    }
}
