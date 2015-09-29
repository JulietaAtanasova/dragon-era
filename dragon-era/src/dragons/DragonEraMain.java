package dragons;

import java.util.Scanner;

import dragons.years.DragonYear;
import dragons.years.DragonYearFactory;
import dragons.years.DragonYearType;

public class DragonEraMain {

    public static void main(String[] args) {
        DragonEra dragonEra = new DragonEra();
        
        Scanner in = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfDragons; i++) {
            Dragon dragon = new Dragon("Dragon_" + (i + 1));
            int numberOfEggs = Integer.parseInt(in.nextLine());
            for (int j = 0; j < numberOfEggs; j++) {
                Egg egg = new Egg(dragon);
                dragon.getEggs().add(egg);
                dragonEra.getEggs().add(egg);
            }
            
            dragonEra.getDragons().add(dragon);
        }
        
        int numberOfYears = Integer.parseInt(in.nextLine());
        DragonYearFactory yearFactory = new DragonYearFactory();
        for (int i = 0; i < numberOfYears; i++) {
            String currentYear = in.nextLine();
            DragonYear dragonYear = yearFactory.create(DragonYearType.valueOf(currentYear.toUpperCase()));
            dragonEra.getDragonYears().add(dragonYear);
        }

        dragonEra.pass();
        System.out.println(dragonEra);
    }

}
