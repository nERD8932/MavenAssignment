import com.smu.mscda.HashCalculator;
import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashCalculatorTests {
    @Test
    public void testHashing() throws NoSuchAlgorithmException {
        String testInput = "Hello World!"; // Using pre-capitalized word for hashing test.
        String preComputedHash = "ed076287532e86365e841e92bfc50d8c"; // Computed online at https://www.md5hashgenerator.com/

        List<String> list = HashCalculator.getCapitalizedHash(testInput);

        assertEquals(preComputedHash, list.get(1));
    }

    @Test
    public void testCapitalization() throws NoSuchAlgorithmException  {
        String testInput = "this is a test sentence.";
        String testCapitalized = "This Is A Test Sentence.";

        List<String> list = HashCalculator.getCapitalizedHash(testInput);

        assertEquals(testCapitalized, list.getFirst());
    }
}
