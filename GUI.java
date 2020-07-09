import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends JFrame implements ActionListener{
  private JPanel botones;
  private JButton iniciar;
  private JButton detener;
  private JLabel tablero;
  private Cronometro c;
  private Timer t;
  private int contador;

  public GUI(){
    botones= new JPanel();
    iniciar= new JButton(">");
    detener= new JButton("||");
    c=new Cronometro();
    tablero=new JLabel(c.actualizar(),JLabel.CENTER);
    iniciar.setActionCommand("iniciar");
    detener.setActionCommand("detener");
    iniciar.addActionListener(this);
    detener.addActionListener(this);
    botones.setLayout(new GridLayout(1,2));
    botones.add(iniciar);
    botones.add(detener);
    this.getContentPane().setLayout(new GridLayout(2,1));
    this.getContentPane().add(tablero);
    this.getContentPane().add(botones);
    this.pack();
    this.setVisible(true);
  } 

  public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("iniciar")){
      Tarea tarea = new Tarea();
      t = new Timer();
      t.scheduleAtFixedRate(tarea,0,1000);
      presionarBoton(false);
    }
    if(e.getActionCommand().equals("detener")){
      t.cancel();
      presionarBoton(true);
    }  
  }

  public void presionarBoton(boolean valor){
      iniciar.setEnabled(valor);        
  }
  
  class Tarea extends TimerTask{
    //@override
    public void run(){
      c.run();
      tablero.setText(c.actualizar());
    }
  }
}