package com.example.oxitic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import java.util.Random;

import android.net.Uri;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler();
    private Runnable mTimer1;
    private Runnable mTimer2;
    private LineGraphSeries<DataPoint> mSeries1;
    private LineGraphSeries<DataPoint> mSeries2;
    private double grafo1UltimoValorX = 5d;
    private double grafo2UltimoValorX = 5d;

    private Button botonSOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*   Este presenta otro tipo de grafifación usando el generateData()

        GraphView vistaSpO2 = (GraphView) findViewById(R.id.viewSpO2);
        mSeries1 = new LineGraphSeries<>(generateData());
        vistaSpO2.addSeries(mSeries1);
        */

        GraphView vistaSpO2 = (GraphView) findViewById(R.id.viewSpO2);
        mSeries1 = new LineGraphSeries<>();
        vistaSpO2.addSeries(mSeries1);
        vistaSpO2.getViewport().setXAxisBoundsManual(true);
        vistaSpO2.getViewport().setMinX(0);
        vistaSpO2.getViewport().setMaxX(40);

        GraphView vistaRR = (GraphView) findViewById(R.id.viewRR);
        mSeries2 = new LineGraphSeries<>();
        vistaRR.addSeries(mSeries2);
        vistaRR.getViewport().setXAxisBoundsManual(true);
        vistaRR.getViewport().setMinX(0);
        vistaRR.getViewport().setMaxX(40);


        //Llamada a SOS con botón
        botonSOS = findViewById(R.id.botonEmergencia);
        botonSOS.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String number = "911";

                // Se podría usar un Intent para efectuar una llamada.

                // Intent callIntent = new Intent(Intent.ACTION_CALL);
                //callIntent.setData(Uri.parse("tel:"+number));
                //startActivity(callIntent);

                Context context = getApplicationContext();
                CharSequence mensajeSOS = "Llamando a 911...";
                int duracionToast = Toast.LENGTH_SHORT;

                Toast toastSOS = Toast.makeText(context, mensajeSOS, duracionToast);
                toastSOS.show();
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();

        mTimer1 = new Runnable() {
            @Override
            public void run() {
                //mSeries1.resetData(generateData());
                //mHandler.postDelayed(this, 300);
                grafo1UltimoValorX += 1d;
                mSeries1.appendData(new DataPoint(grafo1UltimoValorX, getRandom()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer1, 1000);

        mTimer2 = new Runnable() {
            @Override
            public void run() {
                grafo2UltimoValorX += 1d;
                mSeries2.appendData(new DataPoint(grafo2UltimoValorX, getRandom()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer2, 1000);
    }

    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer1);
        mHandler.removeCallbacks(mTimer2);
        super.onPause();
    }

    private DataPoint[] generateData() {
        int count = 30;
        DataPoint[] values = new DataPoint[count];
        for (int i=0; i<count; i++) {
            double x = i;
            double f = mRand.nextDouble()*0.15+0.3;
            double y = Math.sin(i*f+2) + mRand.nextDouble()*0.3;
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    double mLastRandom = 2;
    Random mRand = new Random();

    private double getRandom() {
        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
    }
}
