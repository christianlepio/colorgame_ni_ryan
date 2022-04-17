package com.example.color_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LuckyWheel luckyWheel;
    List<WheelItem> wheelItemList = new ArrayList<>();
    String points, clicked_color;
    Button btngreen, btnred, btnblue, btnpink, btnwhite, btnyellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngreen = findViewById(R.id.btngreen);
        btnred = findViewById(R.id.btnred);
        btnblue = findViewById(R.id.btnblue);
        btnpink = findViewById(R.id.btnpink);
        btnwhite = findViewById(R.id.btnwhite);
        btnyellow = findViewById(R.id.btnyellow);

        btngreen.setOnClickListener(this);
        btnred.setOnClickListener(this);
        btnblue.setOnClickListener(this);
        btnpink.setOnClickListener(this);
        btnwhite.setOnClickListener(this);
        btnyellow.setOnClickListener(this);

        luckyWheel = findViewById(R.id.luckywheel);

        WheelItem wheelItem1 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.red,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "0");
        wheelItemList.add(wheelItem1);

        WheelItem wheelItem2 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.white,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "1");
        wheelItemList.add(wheelItem2);

        WheelItem wheelItem3 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.green,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "2");
        wheelItemList.add(wheelItem3);

        WheelItem wheelItem4 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.pink,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "3");
        wheelItemList.add(wheelItem4);

        WheelItem wheelItem5 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.blue,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "4");
        wheelItemList.add(wheelItem5);

        WheelItem wheelItem6 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.yellow,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.upload), "5");
        wheelItemList.add(wheelItem6);

        luckyWheel.addWheelItems(wheelItemList);

        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem itemSelected = wheelItemList.get(Integer.parseInt(points) -1);

                if(itemSelected.text == "0"){
                    itemSelected.text = "RED";
                }else if(itemSelected.text == "1"){
                    itemSelected.text = "WHITE";
                }else if(itemSelected.text == "2"){
                    itemSelected.text = "GREEN";
                }else if(itemSelected.text == "3"){
                    itemSelected.text = "PINK";
                }else if(itemSelected.text == "4"){
                    itemSelected.text = "BLUE";
                }else if(itemSelected.text == "5"){
                    itemSelected.text = "YELLOW";
                }

                if(itemSelected.text.equals(clicked_color)){
                    Toast.makeText(MainActivity.this,"You WON!!!",Toast.LENGTH_SHORT).show();
                }else if(!(itemSelected.text.equals(clicked_color))){
                    Toast.makeText(MainActivity.this,"You LOSE!!!",Toast.LENGTH_SHORT).show();
                }

                String points_amount = itemSelected.text;

                Toast.makeText(MainActivity.this,points_amount,Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void btnClick(View v){
        Random random = new Random();
        points = String.valueOf(random.nextInt(10));

        if(points.equals("0")){
            points = String.valueOf(1);
        }
        luckyWheel.rotateWheelTo(Integer.parseInt(points));
    }

    @Override
    public void onClick(View v) {

        TextView selectedColor = findViewById(R.id.txtSelectedColor);

        switch (v.getId()){
            case R.id.btngreen:
                clicked_color = "GREEN";
                selectedColor.setText(clicked_color.toString());
                break;
            case R.id.btnred:
                clicked_color = "RED";
                selectedColor.setText(clicked_color.toString());
                break;
            case R.id.btnblue:
                clicked_color = "BLUE";
                selectedColor.setText(clicked_color.toString());
                break;
            case R.id.btnpink:
                clicked_color = "PINK";
                selectedColor.setText(clicked_color.toString());
                break;
            case R.id.btnwhite:
                clicked_color = "WHITE";
                selectedColor.setText(clicked_color.toString());
                break;
            case R.id.btnyellow:
                clicked_color = "YELLOW";
                selectedColor.setText(clicked_color.toString());
                break;
            default:
                clicked_color = "NONE";
                break;
        }
    }
}