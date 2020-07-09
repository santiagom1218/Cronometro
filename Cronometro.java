import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends TimerTask{
  
  private Hora hor = new Hora (0,24);
  private Minuto min = new Minuto(0,60);
  private Segundo seg = new Segundo(0,60);
  private Timer t;

  public Cronometro(){
    this.hor = new Hora(0,24);
    this.min = new Minuto(0,60);
    this.seg = new Segundo(0,60);
  }

  public void run(){
    seg.avanzar();
    if(seg.getValor()==0){
      min.avanzar();
    if(min.getValor()==0){
      hor.avanzar();
    }}
  }

  public void Temporizador(){
    Cronometro c = new Cronometro();
    t = new Timer();
    t.scheduleAtFixedRate(c,0,1000);
  }

  public String actualizar() {
    String text=String.valueOf(hor.getValor()<=9?"0":"")+hor.getValor()+":"+(min.getValor()<=9?"0":"")+min.getValor()+":"+(seg.getValor()<=9?"0":"")+seg.getValor();
    return text;
  }
}