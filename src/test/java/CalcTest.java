import com.example.Calc;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void add() {

    assertEquals(7,new Calc().add(2,5));
    }

}