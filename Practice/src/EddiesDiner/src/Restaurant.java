package EddiesDiner.src;

public class Restaurant {
    
    protected boolean isLunchTime = true;
    protected Factory fred = new LunchFactory();
    
    public void changeTime(){
        if (isLunchTime) {
            System.out.println("\nIt is 6 PM. Time for dinner");
            fred = new DinnerFactory();
            isLunchTime = false;
        }
        else {
            System.out.println("\nIt is 11 AM. Time for lunch");
            fred = new LunchFactory();
            isLunchTime = true;
        }
    }
    
    public void makeMeal(){
        Meal aMeal = fred.makeMeal();
    }
    
    
    
    
    
    public Restaurant() {
        
        changeTime();
        makeMeal();
        makeMeal();
        makeMeal();
        makeMeal();

        changeTime();
        makeMeal();
        makeMeal();
        makeMeal();
        makeMeal();
        
        changeTime();
        makeMeal();
        makeMeal();
        makeMeal();
        makeMeal();
        
    }
    
}
