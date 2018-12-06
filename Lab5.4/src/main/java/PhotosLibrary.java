import io.indico.api.IndicoResult;
import io.indico.api.BatchIndicoResult;

import java.util.List;

public class PhotosLibrary {

    // single example
    PhotosLibrary indico = new PhotosLibrary("db4774d513dfaed416c4571314f074d4");
    IndicoResult single = indico.imageRecognition.predict(
            "<IMAGE>"
    );
    Double result = single.getImageRecognition();
    System.out.println(result);

    // batch example
    String[] example = {
            "<IMAGE>",
            "<IMAGE>"
    };
    BatchIndicoResult multiple = indico.imageRecognition.predict(example);
    List<Double> results = multiple.getImageRecognition();
    System.out.println(results);
}
