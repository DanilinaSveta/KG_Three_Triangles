import java.awt.*;

public class Math_tr extends Component {

    public int ab, fi, al, bt, bc, leg = 30;
    double ac;
    double b_x, b_y, c_x, c_y, d_al, a_x = 350, a_y=340;
    public void my_fun(){
        b_x = a_x + getAb() * leg * (Math.cos(Math.toRadians(getFi())));
        b_y = a_y - getAb() * leg * (Math.sin(Math.toRadians(getFi())));
        c_x = a_x + getAc() * leg * (Math.cos(Math.toRadians(getFi() + getAl())));
        c_y = a_y - getAc() * leg * (Math.sin(Math.toRadians(getFi() + getAl())));
    }
    public void my_fun2(){
        ac =  getAb() * Math.sin(Math.toRadians(getBt()))/Math.sin(Math.toRadians(180 - getAl() - getBt()));
        b_x = a_x + getAb() * leg * (Math.cos(Math.toRadians(getFi())));
        b_y = a_y - getAb() * leg * (Math.sin(Math.toRadians(getFi())));
        c_x = a_x + ac * leg * (Math.cos(Math.toRadians(getFi() + getAl())));
        c_y = a_y - ac * leg * (Math.sin(Math.toRadians(getFi() + getAl())));

    }
    public void my_fun3(){
        d_al = Math.acos((Math.pow(getAc(),2) + Math.pow(getAb() ,2) - Math.pow(getBc(),2))/(2*getAc()*getAb()));
        b_x = a_x + getAb() * leg * (Math.cos(Math.toRadians(getFi())));
        b_y = a_y - getAb() * leg * (Math.sin(Math.toRadians(getFi())));
        c_x = a_x + getAc() * leg *  (Math.cos(Math.toRadians(getFi() + Math.toDegrees(d_al))));
        c_y = a_y - getAc() * leg * (Math.sin(Math.toRadians(getFi() + Math.toDegrees(d_al))));
    }
    public void setAb(int ab){
        this.ab = ab;
    }
    public int getAb(){
        return ab;
    }
    public void setAc(int ac){
        this.ac = ac;
    }
    public double getAc(){
        return ac;
    }
    public int getBc(){
        return bc;
    }
    public void setBc(int bc){
        this.bc = bc;
    }
    public void setFi(int fi){
        this.fi = fi;
    }
    public int getFi(){
        return fi;
    }
    public void setAl(int al){
        this.al = al;
    }
    public int getAl(){
        return al;
    }
    public void setBt(int bt){
        this.bt = bt;
    }
    public int getBt(){
        return bt;
    }
    public double getBX(){
        return b_x;
    }
    public double getBY(){
        return b_y;
    }
    public double getCX(){
        return c_x;
    }
    public double getCY(){
        return c_y;
    }
    public double getAX(){
        return a_x;
    }
}
