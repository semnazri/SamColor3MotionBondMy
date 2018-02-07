package a3motion.com.colorbond.Model;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Voucher {

    String amount, place;
    int bg;

    public Voucher() {
    }

    public Voucher(String amount, String place, int bg) {
        this.amount = amount;
        this.place = place;
        this.bg = bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getBg() {
        return bg;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
