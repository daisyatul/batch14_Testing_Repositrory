package StepDef;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

@Log4j2

public class StepDef1 {
    private String name;

    public void NewMethod(){
        log.debug("Inside new method");

    }

}
