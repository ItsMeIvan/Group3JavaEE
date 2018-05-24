package ejb;


import javax.ejb.Remote;
import javax.ejb.Startup;

@Remote
public interface GenerateService {
    void generateData();
}
