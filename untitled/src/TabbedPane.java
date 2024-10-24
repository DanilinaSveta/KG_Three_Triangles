import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Objects;

public class TabbedPane extends JFrame {
    private JLabel label, label2, label2_2, label2_3,label2_4, label3_2;

    private int dividerMain = 100;
    private int Bx = 150;
    private int By = 100;
    private int Cx = 250;
    private int Cy =200;
    private int ax = 20;
    public TabbedPane() throws IOException, URISyntaxException {
        super("3 задачи построения 3-угольника, заданного длиной и наклоном первой стороны");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Главная разделяемая панель
        final JSplitPane splitHorizontal = new JSplitPane();
        splitHorizontal.setOneTouchExpandable(true);
        splitHorizontal.setDividerSize(8);
        // Положение разделяемой панели
        splitHorizontal.setDividerLocation(920);
        JTabbedPane pnlMain = new JTabbedPane();
        // Правая панель с вкладками
        JTabbedPane tabsRight = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        // Создание вкладок
        for (int i = 1; i < 4; i++) {
            // Создание панели
            JPanel panel1 = new JPanel(new VerticalLayout());
            JPanel panel_img = new JPanel();

            final JSplitPane panel = new JSplitPane();
            panel.setOneTouchExpandable(true);
            // Положение разделяемой панели
            panel.setDividerLocation(100);
            // Вертикальная разделяемая панель
            JSplitPane panel2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
            panel.setLayout(new FlowLayout());
            if (i == 1) {
                JSlider slider1 = new JSlider(0,10,0);
                JSlider slider2 = new JSlider(0,360,0);
                JSlider slider3 = new JSlider(0,10,0);
                JSlider slider4 = new JSlider(-360,360,0);
                // Настройка внешнего вида ползунков
                slider1.setPaintLabels(true);
                slider1.setMajorTickSpacing(1);
                slider1.setPaintTicks(true);

                slider3.setPaintLabels(true);
                slider3.setMajorTickSpacing(1);
                slider3.setPaintTicks(true);

                panel1.add(new JLabel("Длина стороны AB"));
                panel1.add(slider1);
                panel1.add(new JLabel("<html><i>Угол &#966 ")); //угол фи
                panel1.add(slider2);
                panel1.add(fun_slider(slider2,label,0));

                panel1.add(new JLabel("Длина стороны AC"));
                panel1.add(slider3);
                panel1.add(new JLabel("<html><i>Угол &#945")); //угол альфа
                panel1.add(slider4);
                panel1.add(fun_slider(slider4,label2,1));

                Button(panel1, pnlMain, 1, slider1,slider2, slider3,slider4);  //кнопка
                Image img = new ImageIcon ((Objects.requireNonNull(getClass().getResource("image/tr1.png")))).getImage();
                JLabel pic = new JLabel(new ImageIcon(img));
                panel_img.add(pic);
            } else if (i == 2) {
                JSlider slider2_1 = new JSlider(0,10,0);
                JSlider slider2_2 = new JSlider(0,360,0);
                JSlider slider2_3 = new JSlider(-180,180,0);
                JSlider slider2_4 = new JSlider(-180,180,0);

                slider2_1.setPaintLabels(true);
                slider2_1.setMajorTickSpacing(1);
                slider2_1.setPaintTicks(true);

                panel1.add(new JLabel("Длина стороны AB"));
                panel1.add(slider2_1);
                panel1.add(new JLabel("<html><i>Угол &#966")); //угол фи
                panel1.add(slider2_2);
                panel1.add(fun_slider(slider2_2,label2_2,0));
                panel1.add(new JLabel("<html><i>Угол &#946;")); //угол бетта
                panel1.add(slider2_3);
                panel1.add(fun_slider(slider2_3,label2_3,0));
                panel1.add(new JLabel("<html><i>Угол &#945")); //угол альфа
                panel1.add(slider2_4);
                panel1.add(fun_slider(slider2_4,label2_4,0));

                Button(panel1, pnlMain, 2,slider2_1,slider2_2, slider2_3,slider2_4);  //кнопка
                Image img = new ImageIcon((Objects.requireNonNull(getClass().getResource("image/tr2.png")))).getImage();
                JLabel pic = new JLabel(new ImageIcon(img));
                panel_img.add(pic);

            } else {
                JSlider slider3_1 = new JSlider(0,10,0);
                JSlider slider3_2 = new JSlider(0,360,0);
                JSlider slider3_3 = new JSlider(0,10,0);
                JSlider slider3_4 = new JSlider(0,10,0);

                slider3_1.setPaintLabels(true);
                slider3_1.setMajorTickSpacing(1);
                slider3_1.setPaintTicks(true);

                slider3_3.setPaintLabels(true);
                slider3_3.setMajorTickSpacing(1);
                slider3_3.setPaintTicks(true);
                slider3_4.setPaintLabels(true);
                slider3_4.setMajorTickSpacing(1);
                slider3_4.setPaintTicks(true);

                panel1.add(new JLabel("Длина стороны AB"));
                panel1.add(slider3_1);

                panel1.add(new JLabel("<html><i>Угол &#966")); //угол фи
                panel1.add(slider3_2);
                panel1.add(fun_slider(slider3_2,label3_2,0));
                panel1.add(new JLabel("Длина стороны AC"));
                panel1.add(slider3_3);
                panel1.add(new JLabel("Длина стороны BC"));
                panel1.add(slider3_4);

                Button(panel1, pnlMain, 3, slider3_1,slider3_2,slider3_3,slider3_4);  //кнопка
                Image img = new ImageIcon((Objects.requireNonNull(getClass().getResource("image/tr3.png")))).getImage();
                JLabel pic = new JLabel(new ImageIcon(img));
                panel_img.add(pic);
            }
            // Создание панелей
            panel2.setTopComponent(panel1);
            panel2.setBottomComponent(panel_img);
            // Положение разделяемой панели
            panel2.setDividerLocation(400);
            // Добавление панели во вкладку
            tabsRight.addTab("<html><i>&#11205 №" + i, panel2);

        }
        // Настройка главной панели
        splitHorizontal.setLeftComponent(new JScrollPane(pnlMain));
        splitHorizontal.setRightComponent(tabsRight);
        // Размещение панели в интерфейсе и вывод окна на экран
        getContentPane().add(splitHorizontal);
        // Вывод окна на экран
        setSize(1200, 800);
        setVisible(true);
    }
    //создание кнопки
    public void Button (JPanel panel1, JTabbedPane pnlMain, int i, JSlider slider1, JSlider slider2, JSlider slider3, JSlider slider4){
        JButton button = new JButton("построить");
        panel1.add(button);
        if (i == 1){
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int ab = slider1.getValue();
                    int fi = slider2.getValue();
                    int ac = slider3.getValue();
                    int al = slider4.getValue();
                    if ( ab > 0 && ac > 0){
                        Math_tr math = new Math_tr();
                        math.setAb(ab);
                        math.setFi(fi);
                        math.setAc(ac);
                        math.setAl(al);
                        math.my_fun();
                        Bx = (int) math.getBX();
                        By = (int) math.getBY();
                        Cx = (int) math.getCX();
                        Cy = (int) math.getCY();
                        ax = (int) math.getAX();
                        pnlMain.removeAll();
                        treug(pnlMain);
                    }else if (ab == 0 || ac == 0) {
                        String text = "Ошибка! Треугольник не существует \nДлина стороны не может быть равна 0 ";
                        JOptionPane.showMessageDialog(TabbedPane.this, text);
                    }

                }
            });
        }
        if (i == 2){
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int ab = slider1.getValue();
                    int fi = slider2.getValue();
                    int bt = slider3.getValue();
                    int al = slider4.getValue();
                    Math_tr math = new Math_tr();
                    if (bt * al > 0 && Math.abs(bt + al) < 180 && ab > 0){
                        math.setAb(ab);
                        math.setFi(fi);
                        math.setBt(bt);
                        math.setAl(al);
                        math.my_fun2();
                        Bx = (int) math.getBX();
                        By = (int) math.getBY();
                        Cx = (int) math.getCX();
                        Cy = (int) math.getCY();
                        ax = (int) math.getAX();
                        pnlMain.removeAll();
                        treug(pnlMain);
                    }else if (Math.abs(bt + al) >= 180) {
                        String text = "Ошибка! Треугольник не существует \nСумма углов больше 180 ";
                        JOptionPane.showMessageDialog(TabbedPane.this, text);
                    }else if (ab == 0) {
                        String text = "Ошибка! Треугольник не существует \nДлина стороны не может быть равна 0 ";
                        JOptionPane.showMessageDialog(TabbedPane.this, text);
                    }
                    else if (bt * al <= 0) {
                        String text = "Ошибка! Треугольник не существует \nУглы треугольника разнонаправленны ";
                        JOptionPane.showMessageDialog(TabbedPane.this, text);
                    }

                }
            });
        }
        if (i == 3){
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int ab = slider1.getValue();
                    int fi = slider2.getValue();
                    int ac = slider3.getValue();
                    int bc = slider4.getValue();
                    if (ab < ac +bc && ac < bc + ab && bc < ac+ ab && ab > 0 && ac > 0 && bc > 0) {
                        Math_tr math = new Math_tr();
                        math.setAb(ab);
                        math.setFi(fi);
                        math.setAc(ac);
                        math.setBc(bc);
                        math.my_fun3();
                        Bx = (int) math.getBX();
                        By = (int) math.getBY();
                        Cx = (int) math.getCX();
                        Cy = (int) math.getCY();
                        ax = (int) math.getAX();
                        pnlMain.removeAll();
                        treug(pnlMain);
                    } else {
                        String text = "Ошибка! Треугольник не существует \nСумма двух сторон треугольника должна быть больше третьей";
                        JOptionPane.showMessageDialog(TabbedPane.this, text);
                    }

                }
            });
        }

    }
    public void treug (JTabbedPane pnlMain){
        CartesianPanel cartesianPanel = new CartesianPanel();
        cartesianPanel.setBx(Bx);
        cartesianPanel.setBy(By);
        cartesianPanel.setCx(Cx);
        cartesianPanel.setCy(Cy);
        cartesianPanel.setAx(ax);
        pnlMain.add(cartesianPanel);

    }
    public JLabel fun_slider (JSlider slider, JLabel label, int i){
        slider.setPaintLabels(true);
        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        if (i == 0){
            slider.setMajorTickSpacing(60);
            slider.setMinorTickSpacing(10);

        } else {
            slider.setMajorTickSpacing(120);
            slider.setMinorTickSpacing(20);

        }

        label = new JLabel(String.valueOf(slider.getValue()));
        JLabel finalLabel = label;
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // меняем надпись
                int value = ((JSlider)e.getSource()).getValue();
                String str = "Значение угла:  " + String.valueOf(value);
                finalLabel.setText(str);
            }
        });
        return label;
    }
}