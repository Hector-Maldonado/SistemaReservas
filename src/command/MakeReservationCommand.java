package command;

import model.Reservation;

public class MakeReservationCommand implements Command {
    private Reservation reservation;

    public MakeReservationCommand(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public void execute() {
        reservation.showDetails();
    }
}
