package com.example.testoptosensor;

import java.util.List;

import javax.crypto.spec.OAEPParameterSpec;

import android.support.v7.app.ActionBarActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements SensorEventListener {
	
    private TextView tvLight;
    private TextView tvSensors;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获得SensorManager对象
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
 
        // 注册光线传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_FASTEST);
 
 
        tvLight = (TextView) findViewById(R.id.tv_show_content);
//        tvSensors = (TextView) findViewById(R.id.tv_show_sensor);
        // 获得当前手机支持的所有传感器
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_LIGHT);
//        for (Sensor sensor : sensors) {
//            // 输出当前传感器的名称
//            tvSensors.append(sensor.getName() + "\n");
//        }
    }
 
    @Override
    public void onSensorChanged(SensorEvent event) {
        // 通过getType方法获得当前传回数据的传感器类型
            tvLight.setText("亮度：" + event.values[0]);
    }
 
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

 } 

 