package dragons;

import java.util.Scanner;

import dragons.years.Year;
import dragons.years.YearFactory;
import dragons.years.YearType;

public class DragonEraMain {

    public static void main(String[] args) {
        DragonEra dragonEra = new DragonEra();
        
        Scanner in = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfDragons; i++) {
            Dragon dragon = new Dragon();
            int numberOfEggs = Integer.parseInt(in.nextLine());
            for (int j = 0; j < numberOfEggs; j++) {
                Egg egg = new Egg(dragon);
                dragon.getEggs().add(egg);
            }
            
            dragonEra.getDragons().add(dragon);
        }
        
        int numberOfYears = Integer.parseInt(in.nextLine());
        YearFactory yearFactory = new YearFactory();
        for (int i = 0; i < numberOfYears; i++) {
            String currentYear = in.nextLine();
            Year dragonYear = yearFactory.create(YearType.valueOf(currentYear.toUpperCase()));
            dragonEra.getYears().add(dragonYear);
        }

        dragonEra.pass();
        System.out.println(dragonEra);
    }

}
