import javax.swing.*;
import java.awt.*;

//рисунок треугольника
class DrawATriangle extends JPanel {
    private int Bx;
    private int By;
    private int Cx;
    private int Cy;
    private double ax;
    public void setBx(int Bx){
        this.Bx = Bx;
    }
    public int getBx(){
        return Bx;
    }
    public void setBy(int By){
        this.By = By;
    }
    public int getBy(){
        return By;
    }
    public void setCx (int Cx){
        this.Cx = Cx;
    }
    public int getCx(){
        return Cx;
    }
    public void setCy (int Cy){
        this.Cy = Cy;
    }
    public int getCy(){
        return Cy;
    }
    public void setAx(double ax){
        this.ax = ax;
    }
    public double getAx(){
        return  ax;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke = new BasicStroke(3f);
        int[] xPoints = {(int)getAx(), getCx(), getBx()};  //{A;C;B}
        int[] yPoints = {340, getCy(), getBy()};
        g2d.setColor(Color.green.darker());
        g2d.setStroke(stroke);
        g2d.drawPolygon(xPoints, yPoints, 3);

        g2d.setColor(Color.black);
        Font font  = new Font("Tahoma",Font.BOLD|Font.ITALIC, 30);
        g2d.setFont(font);
        stroke = new BasicStroke(5f);
        g2d.setStroke(stroke);
        g2d.drawString("A", (int)getAx() , 340);
        g2d.drawOval((int)getAx()-1 , 340-1,5,5);
        g2d.drawString("B", getBx() , getBy() );
        g2d.drawOval(getBx()-1 , getBy()-1,5,5);
        g2d.drawString("C", getCx()  , getCy());
        g2d.drawOval(getCx()-1, getCy()-1,5,5);
    }
}