package com.comsic.orawon.myfristapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03, R.drawable.traffic_04,
            R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
            R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
            R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
            R.drawable.traffic_20} ;

    private String[] titlestrings, detailStrings,shortStrings ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial view
        listView = (ListView) findViewById(R.id.livTraffic) ;

        //Get volue
        titlestrings = getResources().getStringArray(R.array.title) ;
        detailStrings = getResources().getStringArray(R.array.detail);

        //substring detailstring arry ตัดข้อความไม่เกิน 30 ตัว
        shortStrings = new String[detailStrings.length];
        for (int i=0;i< detailStrings.length; i++) {
            shortStrings[i] = detailStrings[i].substring(0,29)+ "..."; // แสลงรายละเอียดข้อมูลที่เหลือ...


        } //end for , i ตัวสีแดงคือยังไม่ได้ประกาศค่า

        //Create Lisreview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titlestrings, shortStrings) ;
        listView.setAdapter(myAdapter);

        // ลิงค์ไปหน้าดีเทลเลือกคลิกไอเทม Active when click List View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,Detail.class) ;
                intent.putExtra("Title",titlestrings[position]) ;
                intent.putExtra("Detail",detailStrings[position]);
                intent.putExtra("Image",ints[position]);
                startActivity(intent);

            } // เมื่อมีการคลิกข้อมูลที่ตำแหน่งใดจะเก็บตำแหน่งข้อมูลจากการคลิก
        });

    }//main Method onCreate
     public void onCickMoreInfo(View view) {
         Intent intent = new Intent(Intent.ACTION_VIEW) ;
         intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111")) ;
         startActivity(intent);
     }

} // main Class
