package mx.creator.gymchron.chronometro;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class inicio extends AppCompatActivity {

    Button btn_start, btn_stop, btn_reset;
    Button btnserie1, btnserie2, btnserie3, btnserie4,btndescanso;
    Chronometer chronometro, cronserie1, cronserie2, cronserie3, cronserie4;
    Boolean correr = false;
    TextView txtTiempo, txtSerieBerofe, txtDescanso;
    long detenerse;
    long tiempo = 20000; //20 secs
    String serieBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_inicio);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_reset = findViewById(R.id.btn_reset);
        chronometro = findViewById(R.id.chronometro);

        txtTiempo = findViewById(R.id.txttiempo);
        txtSerieBerofe = findViewById(R.id.txtseriebef);
        btnserie1 =  findViewById(R.id.btnSerie1);
        btnserie2 =  findViewById(R.id.btnSerie2);
        btnserie3 =  findViewById(R.id.btnSerie3);
        btnserie4 =  findViewById(R.id.btnSerie4);
        txtDescanso = findViewById(R.id.txtdescanso);
        btndescanso = findViewById(R.id.btnDescanso);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChronometro();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChronometro();
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetChronometro();
            }
        });

    }

    private void resetChronometro() {
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
    }

    private void stopChronometro() {
        if (correr) {
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr = false;
        }
    }

    private void startChronometro() {
        if (!correr) {
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            correr = true;
        }
    }

    //Para boton de reset series, aun no agregado.
    private void resetSeries() {
        cronserie1.setBase(SystemClock.elapsedRealtime());
        cronserie2.setBase(SystemClock.elapsedRealtime());
        cronserie3.setBase(SystemClock.elapsedRealtime());
        cronserie4.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        //correr=false;
    }

    public void StartDownSerie1(){
        DesactivaBotones();
        txtDescanso.setText(" ");
        new CountDownTimer(50000, 1000) { //Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Segundos: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTiempo.setText("Done!");
                txtSerieBerofe.setText("Hiciste la serie 1(50s)!");
                ActivaBotones();
            }
        }.start();
    }

    public void StartDownSerie2(){
        DesactivaBotones();
        txtDescanso.setText(" ");
        new CountDownTimer(40000, 1000) { //Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Segundos : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTiempo.setText("Done!");
                txtSerieBerofe.setText("Hiciste la serie 2(40s)!");
                ActivaBotones();
            }
        }.start();
    }

    public void StartDownSerie3(){
        DesactivaBotones();
        txtDescanso.setText(" ");
        new CountDownTimer(30000, 1000) { //Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Segundos: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTiempo.setText("Done!");
                txtSerieBerofe.setText("Hiciste la serie 3(30s)!");
                ActivaBotones();
            }
        }.start();
    }


    public void StartDownSerie4(){
        DesactivaBotones();
        txtDescanso.setText(" ");
        new CountDownTimer(20000, 1000) { //Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Segundos: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTiempo.setText("Done!");
                txtSerieBerofe.setText("Hiciste la serie 4(20s)!");
                ActivaBotones();
            }
        }.start();
    }

    public void StartDownDescanso(){
        DesactivaBotones();
        txtDescanso.setText(" ");
        new CountDownTimer(60000, 1000) { //Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Segundos: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTiempo.setText("Done!");
                txtDescanso.setText("Haz descansado 60s!");
                ActivaBotones();
            }
        }.start();
    }

    public void DesactivaBotones(){
        btnserie1.setEnabled(false);
        btnserie2.setEnabled(false);
        btnserie3.setEnabled(false);
        btnserie4.setEnabled(false);
        btndescanso.setEnabled(false);

    }
    public void ActivaBotones(){
        btnserie1.setEnabled(true);
        btnserie2.setEnabled(true);
        btnserie3.setEnabled(true);
        btnserie4.setEnabled(true);
        btndescanso.setEnabled(true);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSerie1:
                StartDownSerie1();
                break;
            case R.id.btnSerie2:
                StartDownSerie2();
                break;
            case R.id.btnSerie3:
                StartDownSerie3();
                break;
            case R.id.btnSerie4:
                StartDownSerie4();
                break;
            case R.id.btnDescanso:
                StartDownDescanso();
                break;
        }
    }
}