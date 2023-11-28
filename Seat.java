
public class Seat{

    private String seat;

    public Seat(){  

    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String newSeat) {
        this.seat = newSeat;
    }
}

public class Seat{

    private String seat;
    private int seat_aval;

    public Seat(String s, int seat_tot){  
        this.seat = s;
        if (seat_tot >0 ){
            seat_aval = seat_tot - 1;
        }
        else{
            throw new Exception("Flight is full");
        }

    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String newSeat) {
        this.seat = newSeat;
    }
    
    public int getSeatsAvailable(){
        return this.seat_aval;
    }

    public void setSeatsAvailable(int newSeats){
        this.seat_aval = newSeats;
    }

    public int seatTaken(int seats){
        return seats -1;
    }

    public int seatRefunded(int seats){
        return seats +1;
    }

    public boolean seatChecker(String seatIDInput){
        db = new DatabaseConnection();

        List<String> seatsAvail = db.extractSeatID();

        if (seatsAvail.contains(seatIDInput)){
            System.out.println("Seat Taken");
            return false;
        }
        System.out.println("Seat Booked");
        return true;
    }
    
}
