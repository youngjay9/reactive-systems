package operator;

import com.jay.operator.FluxAndMonoMapOperator;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoMapOperatorTest {

  FluxAndMonoMapOperator mapOperator = new FluxAndMonoMapOperator();

  @Test
  void namesFlux() {

    // when
    var namesFlux = mapOperator.namesFlux();

    // then
    StepVerifier.create(namesFlux)
          .expectNext("JAY", "THUY", "PING", "ANG")
          .verifyComplete();
  }
}
