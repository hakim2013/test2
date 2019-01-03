import com.example.Calc;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void add() {

    assertEquals(7,new Calc().add(2,5));
    }

    @Test
    public void mult() {

        assertEquals(10,new Calc().mul(2,5));
    }
    
      @Test
    public void sub() {
        
        assertEquals(2,new Calc().sub(5,3));
    }
    
    
     @Test
    public void add2() {

    assertEquals(7,new Calc().add(2,5));
    }


}
