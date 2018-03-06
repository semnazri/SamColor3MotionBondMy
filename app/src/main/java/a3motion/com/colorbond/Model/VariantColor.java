package a3motion.com.colorbond.Model;

import java.util.ArrayList;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 26/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class VariantColor {
    public String Txt;
    public String Image;
    public ArrayList<String> text = new ArrayList<String>();

    public VariantColor(String Text) {
        this.Txt = Text;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Txt;
    }
}
