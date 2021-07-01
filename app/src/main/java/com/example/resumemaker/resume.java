 package com.example.resumemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class resume extends AppCompatActivity {
    LinearLayout skillslayout;
    LinearLayout hobbieslayout;
    LinearLayout langeslayout;
    LinearLayout projectlayout;
    LinearLayout achievementlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        Bundle bundle = getIntent().getExtras();
        skillslayout = findViewById(R.id.skillslayoutt);
        hobbieslayout = findViewById(R.id.layouthobbiesd);
        langeslayout = findViewById(R.id.layoutlanguagessd);
        projectlayout = findViewById(R.id.layoutproject);
        achievementlayout = findViewById(R.id.layoutachievement);


        /*for name*/
        updatesome(bundle.getString("name").toUpperCase(),(TextView)findViewById(R.id.name));
        /*for address*/
        updatesome(bundle.getString("address"),(TextView)findViewById(R.id.addresstextview));
        /*for jobtitle*/
        updatesome(bundle.getString("job_position").toUpperCase(),(TextView) findViewById(R.id.jobtitleTextview));
        /*for email id*/
        updatesome(bundle.getString("email"),(TextView) findViewById(R.id.emailview));
        /*for phone number*/
        updatesome(bundle.getString("phone"),(TextView) findViewById(R.id.phonenum));
        /*for introduction*/
        updatesome(bundle.getString("intro"),(TextView) findViewById(R.id.introductiontextview));
        /*for the start of ug year (UG being under graduate)*/
        updatesome(bundle.getString("UGstarty"),(TextView)findViewById(R.id.ugstart));
        /*for UG end*/
        updatesome(bundle.getString("UGendy"),(TextView)findViewById(R.id.ugend));
        /*for UG marks*/
        updatesome("Secured an overall CGPA of " + bundle.getString("uGmarks"),(TextView)findViewById(R.id.ugmarks));
        /*the 12th start year*/
        updatesome(bundle.getString("t12startyear"),(TextView)findViewById(R.id.t12STTart));
        /*this is for 12th end year*/
        updatesome(bundle.getString("t12endyear"),(TextView)findViewById(R.id.t12ENd));
        /*this is for 12th marks*/
        updatesome("Secured "+bundle.getString("t12marksdis")+"%",(TextView)findViewById(R.id.t12MArks));
        /*this is for 10th start year*/
        updatesome(bundle.getString("t10start"),(TextView)findViewById(R.id.t10STTart));
        /*this is for 10th end year*/
        updatesome(bundle.getString("t10end"),(TextView)findViewById(R.id.t10ENd));
        /*this is for 10th marks*/
        updatesome("Secured "+bundle.getString("t10marks")+"%",(TextView)findViewById(R.id.t10MArks));
        /*this is for languages*/
        pastethetext(bundle.getStringArrayList("languages"),langeslayout);
        /*for skills*/
        pastethetext(bundle.getStringArrayList("skills"),skillslayout);
        /*for hobbies*/
        pastethetext(bundle.getStringArrayList("hobbies"),hobbieslayout);
        /*for the projects*/
        List<String> protitle = bundle.getStringArrayList("projecttitle");
        List<String> prodetaile = bundle.getStringArrayList("projectdetails");
        titledetailtext(protitle,prodetaile,projectlayout);
        /*for achievements*/
        List<String> achtitle = bundle.getStringArrayList("achievementtitle");
        List<String> achdetail = bundle.getStringArrayList("achievementdetail");
        titledetailtext(achtitle,achdetail,achievementlayout);


    }

    private void titledetailtext(List<String> title,List<String> detail,LinearLayout layout) {
        for(int i = 0;i<= title.size()-1;i++){
            View titledeta = getLayoutInflater().inflate(R.layout.title_detail,null,false);
            TextView tview = (TextView)titledeta.findViewById(R.id.titless);
            TextView dview = (TextView)titledeta.findViewById(R.id.detailss);
            tview.setText(title.get(i).toUpperCase());
            dview.setText(detail.get(i));
            layout.addView(titledeta);
        }
    }

    private void updatesome(String name, TextView view) {
        view.setText(name);
    }

    private void pastethetext(List<String> listoftext,LinearLayout layoutt) {
        for (int i = 0;i <= listoftext.size()-1;i++ ){
            View skillview = getLayoutInflater().inflate(R.layout.add_textview,null,false);
            TextView vv =(TextView)skillview.findViewById(R.id.addtextview);
            vv.setText(listoftext.get(i));
            layoutt.addView(skillview);

        }
    }
}