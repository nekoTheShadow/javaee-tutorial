package beans;

import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {
    
    
    @EJB
    CommuteDb commuteDb;

    public String init() {        
        Commute bus = new Commute(Transportation.BUS, 15_000, null);
        Commute car = new Commute(Transportation.CAR, 12_000, null);
        Commute tram = new Commute(Transportation.TRAM, 10_000, null);
        
        Employee e1 = new Employee("田中宏", bus);
        Employee e2 = new Employee("鈴木一郎", bus);
        Employee e3 = new Employee("佐藤修", car);
        Employee e4 = new Employee("山田花子", tram);
        Employee e5 = new Employee("中村太郎", tram);
        
        bus.setEmployees(Arrays.asList(e1, e2));
        car.setEmployees(Arrays.asList(e3));
        tram.setEmployees(Arrays.asList(e4, e5));
        
        commuteDb.persist(bus);
        commuteDb.persist(car);
        commuteDb.persist(tram);
//        commuteDb.persist(bus);
//        commuteDb.persist(car);
//        commuteDb.persist(tram);

        return "output";
    }

    // 全データを取得する
    public List<Commute> getAllCommute() {
        return commuteDb.findAll();
    }
}
