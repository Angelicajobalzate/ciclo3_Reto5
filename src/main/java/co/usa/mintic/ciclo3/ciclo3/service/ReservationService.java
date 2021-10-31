package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Reservation;
import co.usa.mintic.ciclo3.ciclo3.model.custom.CountClient;
import co.usa.mintic.ciclo3.ciclo3.model.custom.StatusAmount;
import co.usa.mintic.ciclo3.ciclo3.repository.RsvRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angelica Alzate
 */
@Service
public class ReservationService {

    @Autowired
    /**
     * Instancia clase RsvRepository
     */
    private RsvRepository rsvRepository;

    /**
     * Creación lista Reservation
     *
     * @return repositorio de la la clase reservacion
     */
    public List<Reservation> getAll() {
        return rsvRepository.getAll();
    }

    /**
     * Creación de la clase Optional
     *
     * @param idRsv
     * @return idRsv
     */
    public Optional<Reservation> getReservation(int idRsv) {
        return rsvRepository.getReservation(idRsv);
    }

    /**
     * Creación clase Reservation para grabar
     *
     * @param reserva
     * @return reserva nuerva
     */
    public Reservation save(Reservation reserva) {
        if (reserva.getIdReservation() == null) {
            return rsvRepository.save(reserva);
        } else {
            Optional<Reservation> raux = rsvRepository.getReservation(reserva.getIdReservation());
            if (!raux.isPresent()) {
                return rsvRepository.save(reserva);
            } else {
                return reserva;
            }
        }
    }

    /**
     * Creación clase reservation para actualizar
     *
     * @param reserva
     * @return reserva modificada
     */
    public Reservation update(Reservation reserva) {
        if (reserva.getIdReservation() != null) {
            Optional<Reservation> paux = rsvRepository.getReservation(reserva.getIdReservation());
            if (paux.isPresent()) {
                if (reserva.getStartDate() != null) {
                    paux.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    paux.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                return rsvRepository.save(paux.get());
            }
        }
        return reserva;
    }

    /**
     * Método para borrar la clase reservation
     *
     * @param idRsv
     * @return true o false
     */

    public boolean deleteReservation(int idRsv) {
        Optional<Reservation> rsv = getReservation(idRsv);
        if (rsv.isPresent()) {
            rsvRepository.delete(rsv.get());
            return true;
        }
        return false;
    }

    public List<CountClient> getTopClients() {
        return rsvRepository.getTopClients();
    }

    public StatusAmount getStatusReport() {
        List<Reservation> completed = rsvRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = rsvRepository.getReservationsByStatus("cancelled");

        StatusAmount statusAmt = new StatusAmount(completed.size(), cancelled.size());
        return statusAmt;
    }

    public List<Reservation> getReservationPeriod(String d1, String d2)  {

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try{
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
            
        }catch(ParseException evn){
            evn.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return rsvRepository.getReservationPeriod(dateOne, dateTwo);
    }else{
        return new ArrayList<>();
    }
  }
}
