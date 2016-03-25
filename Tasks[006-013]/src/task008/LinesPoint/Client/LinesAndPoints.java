package task008.LinesPoint.Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task008.LinesPoint.Client.GComponents.GHorizontalLine;
import task008.LinesPoint.Client.GComponents.GPoint;
import task008.LinesPoint.Client.GComponents.GSquare;
import task008.LinesPoint.Client.GComponents.GVerticalLine;
import task008.LinesPoint.Coordinates;
import task008.LinesPoint.Step;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Denis on 25.11.15.
 */
public class LinesAndPoints extends JFrame {

    public static JPanel gamePanel;
    public static JPanel infoPanel;
    public static JPanel gameFieldPanel;
    public static JLabel infoLabel;
    static ApplicationContext appContext;

    private static int size;

    public LinesAndPoints(int size) {

        appContext = new ClassPathXmlApplicationContext("task008/LinesPoint/Client/spring-config-task008-client.xml");

        this.size = size*2+2;

        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        drawLayout();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                Client.sendCoordinates(new Coordinates(-1, -1)); // Отправка о завершении
                System.out.print("TERMINATE");
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

    }

    public static int getFieldSize() {
        return size;
    }

    public void drawLayout() {

        GridBagConstraints c = (GridBagConstraints) appContext.getBean("constraints");

        /* Игровая панель */
        gamePanel = (JPanel) appContext.getBean("gridPanel");

        gameFieldPanel = (JPanel) appContext.getBean("gridPanelField");  // Панель игрового поля

        for (int i=1; i<size; i++) { // Номер строки

            for (int j=1; j<size; j++) { // Номер столбца
                c.gridx = j;
                c.gridy = i;

                if (i%2!=0) {
                    if (j%2!=0) gameFieldPanel.add(new GPoint(c.gridx, c.gridy), c);
                    else gameFieldPanel.add(new GHorizontalLine(c.gridx, c.gridy), c);
                }
                else {
                    if (j%2!=0) gameFieldPanel.add(new GVerticalLine(c.gridx, c.gridy), c);
                    else gameFieldPanel.add(new GSquare(c.gridx, c.gridy), c);
                }
            }

            if (i%2==0) {
                c.gridx = i;
                c.gridy = 1;
                gameFieldPanel.add(new GHorizontalLine(c.gridx, c.gridy), c);
            }
            else {
                c.gridx = i;
                c.gridy = 1;
                gameFieldPanel.add(new GPoint(c.gridx, c.gridy), c);
            }

        }

        c = (GridBagConstraints) appContext.getBean("constraints");

        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 150;

        c.fill = GridBagConstraints.HORIZONTAL;

        gamePanel.add(gameFieldPanel, c);

        infoPanel = (JPanel) appContext.getBean("borderPanel");

        infoLabel = (JLabel) appContext.getBean("label");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        infoLabel.setForeground(Color.BLACK);

        infoPanel.add(infoLabel, BorderLayout.CENTER);

        /*

        JButton startButton = new JButton("Начать заново");
        infoPanel.add(startButton, BorderLayout.PAGE_END);

        JRadioButton button1 = new JRadioButton("sdf");

        JRadioButton button2 = new JRadioButton("ggg");
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);

        infoPanel.add(button1, BorderLayout.PAGE_START);

        */

        c = (GridBagConstraints) appContext.getBean("constraints");

        c.gridx = 1;
        c.gridy = 2;

        c.fill = GridBagConstraints.HORIZONTAL;

        gamePanel.add(infoPanel, c);

        this.add(gamePanel);

        this.setVisible(true);

        //// Пока не присоединится противник
        infoLabel.setText("Ждите соперника...");
        setEnabled(false);

    }

}
