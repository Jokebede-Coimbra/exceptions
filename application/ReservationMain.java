package tratamento.excecoes.exercicio.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tratamento.excecoes.exercicio.domain.Reservation;

public class ReservationMain {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date in = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date out = sdf.parse(sc.next());

        if (!out.after(in)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, in, out);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            in = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            out = sdf.parse(sc.next());

            Date now = new Date();
            if (in.before(now) || out.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!out.after(in)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(in, out);
                System.out.println("Reservation: " + reservation);
            }

        }
        sc.close();
    }
}
