public class CoverterTemperatura {
    public static void main(String[] args) {
        double celsius = 30;
        double fahrenheit = (celsius * 1.8) + 32;

        System.out.printf("%.2f graus Celsius e igual a %.2f graus Fahrenheit %n", celsius, fahrenheit);

        int temperatura = (int) fahrenheit;

        System.out.println("Temperatura: " + temperatura);

    }
}
