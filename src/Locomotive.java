public class Locomotive {
    String model;
    String spriteUrl;
    int fuel;
    int lives;
    int price;
    int speed;
    int moneyMultiplier;

    //Locomotive object constructor, various arguments for future use
    public Locomotive(String model, String spriteUrl, int fuel, int lives, int price, int speed, int moneyMultiplier) {
        this.model = model;
        this.spriteUrl = spriteUrl;
        this.fuel = fuel;
        this.lives = lives;
        this.price = price;
        this.speed = speed;
        this.moneyMultiplier = moneyMultiplier;
    }
}
