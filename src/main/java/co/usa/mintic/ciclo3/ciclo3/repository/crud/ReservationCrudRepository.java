package co.usa.mintic.ciclo3.ciclo3.repository.crud;

import co.usa.mintic.ciclo3.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Angélica Alzate
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> { 
   
    @Query ("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus (String status); 
}
