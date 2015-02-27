
package eu.scase.agora.query;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Bool {

    @Expose
    private List<Must> must = new ArrayList<Must>();

    /**
     * 
     * @return
     *     The must
     */
    public List<Must> getMust() {
        return must;
    }

    /**
     * 
     * @param must
     *     The must
     */
    public void setMust(List<Must> must) {
        this.must = must;
    }

}
