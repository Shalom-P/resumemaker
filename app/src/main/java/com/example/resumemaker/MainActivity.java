package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
/*declare all the objects here from the first activity that is the input page*/
    EditText name,address,jobtitle,emailid,phonenum,intros,UGstartyear,UGendyear,UGmarks,t12Start,t12End,t12Marks,tenstart,tenend,tenmarks;
    EditText linkedinlink,githublink;
    List<String> skillslist =new ArrayList<>();
    List<String> hobbieslist = new ArrayList<>();
    List<String> languageslist = new ArrayList<>();
    List<String> projecttitlelist = new ArrayList<>();
    List<String> projectdetaillist = new ArrayList<>();
    List<String> achievementstitlelist = new ArrayList<>();
    List<String> achievementdetaillist = new ArrayList<>();
    LinearLayout layoutLang;
    Button btnadd;
    LinearLayout layoutskills;
    Button btnaddskills;
    LinearLayout layouthobb;
    Button btnaddhob;
    LinearLayout layoutproject;
    Button btnproject;
    LinearLayout layoutachievements;
    Button btnachieve;
    Button btnresume;
    Bundle bundlex = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*here the objects are then linked to the actual fields in the xml files*/
        intros = findViewById(R.id.intro);
        btnresume = findViewById(R.id.btn_resume);
        name = findViewById(R.id.name);
        address = findViewById(R.id.Address);
        jobtitle = findViewById(R.id.jobtitlev);
        emailid = findViewById(R.id.emailid);
        phonenum = findViewById(R.id.phonenum);
        UGstartyear = findViewById(R.id.UGstart);
        UGendyear = findViewById(R.id.UGend);
        UGmarks = findViewById(R.id.marks);
        t12Start = findViewById(R.id.t12start);
        t12End = findViewById(R.id.t12end);
        t12Marks = findViewById(R.id.t12marks);
        tenstart = findViewById(R.id.tenthstart);
        tenend = findViewById(R.id.tenthend);
        tenmarks = findViewById(R.id.tenthmarks);
        layoutLang = findViewById(R.id.languageslayout);
        btnadd = findViewById(R.id.btn_add);
        layoutskills = findViewById(R.id.skillslayout);
        btnaddskills = findViewById(R.id.btn_skills);
        layouthobb = findViewById(R.id.hobbieslayout);
        btnaddhob = findViewById(R.id.btn_hobbies);
        layoutproject = findViewById(R.id.projectLayout);
        btnproject = findViewById(R.id.btn_projects);
        layoutachievements = findViewById(R.id.achievelayout);
        btnachieve = findViewById(R.id.btn_achieve);
        btnresume.setOnClickListener(this);
        btnachieve.setOnClickListener(this);
        btnproject.setOnClickListener(this);
        btnaddhob.setOnClickListener(this);
        btnaddskills.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnresume.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        /*this switch statement is basically used to realise which button is being pressed so that appropriate action can be taken*/
        switch (v.getId()){
            /*this button refers to addlanguage*/
            case R.id.btn_add:
                /*this view will be used to get a field from add_row.xml file and put it in the layout left for language*/
                View lan = getLayoutInflater().inflate(R.layout.add_row,null,false);/*we use add_row because we need only on column*/
                addView(lan,layoutLang,2);
                break;
            /*this button is to add skills*/
            case R.id.btn_skills:
                final View skills = getLayoutInflater().inflate(R.layout.add_row,null,false);
                addView(skills,layoutskills,1);
                break;
            /*this button is used to add skills*/
            case R.id.btn_hobbies:
                View hobbies = getLayoutInflater().inflate(R.layout.add_row,null,false);
                addView(hobbies,layouthobb,3);
                break;
            /*this button is used to add projects done by user*/
            case R.id.btn_projects:
                /*we have used addtwocol column because we need two columns one for title and one for details*/
                View projects = getLayoutInflater().inflate(R.layout.addtwocol,null,false);
                addmulView(projects,layoutproject,11);
                break;
            /*this button is used to add acievements*/
            case R.id.btn_achieve:
                View achievements = getLayoutInflater().inflate(R.layout.addtwocol,null,false);
                addmulView(achievements,layoutachievements,12);
                break;
            /*this button is used to switch to the resume activity and submit the bundle which contains the info from this input page*/
            case R.id.btn_resume:
                bundlex.putString("name",name.getText().toString());
                bundlex.putString("address",address.getText().toString());
                bundlex.putString("job_position",jobtitle.getText().toString());
                bundlex.putString("email",emailid.getText().toString());
                bundlex.putString("phone",phonenum.getText().toString());
                bundlex.putString("intro",intros.getText().toString());
                bundlex.putString("UGstarty",UGstartyear.getText().toString());
                bundlex.putString("UGendy",UGendyear.getText().toString());
                bundlex.putString("uGmarks",UGmarks.getText().toString());
                bundlex.putString("t12startyear",t12Start.getText().toString());
                bundlex.putString("t12endyear",t12End.getText().toString());
                bundlex.putString("t12marksdis",t12Marks.getText().toString());
                bundlex.putString("t10start",tenstart.getText().toString());
                bundlex.putString("t10end",tenend.getText().toString());
                bundlex.putString("t10marks",tenmarks.getText().toString());
                bundlex.putStringArrayList("hobbies",(ArrayList<String>) hobbieslist);
                bundlex.putStringArrayList("languages",(ArrayList<String>) languageslist);
                bundlex.putStringArrayList("skills" , (ArrayList<String>) skillslist);
                bundlex.putStringArrayList("projecttitle",(ArrayList<String>) projecttitlelist);
                bundlex.putStringArrayList("projectdetails",(ArrayList<String>) projectdetaillist);
                bundlex.putStringArrayList("achievementtitle",(ArrayList<String>) achievementstitlelist);
                bundlex.putStringArrayList("achievementdetail",(ArrayList<String>) achievementdetaillist);
                openresume();
                break;

        }
    }
    private void openresume() {
        Intent intent = new Intent(this,resume.class);
        intent.putExtras(bundlex);
        startActivity(intent);
    }

    private void addmulView(View projects, LinearLayout layoutproject,int n) {
        EditText title = (EditText)projects.findViewById(R.id.title);
        EditText details = (EditText)projects.findViewById(R.id.details);
        details.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    if(n == 11){
                        projecttitlelist.add(title.getText().toString());
                        projectdetaillist.add(details.getText().toString());
                    }
                    else if(n == 12){
                        achievementstitlelist.add(title.getText().toString());
                        achievementdetaillist.add(details.getText().toString());
                    }
                }
                return false;
            }
        });
        ImageView imageclose = (ImageView)projects.findViewById(R.id.image_close);
        imageclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removemulView(projects,layoutproject,n,title.getText().toString(),details.getText().toString());
            }
        });
        layoutproject.addView(projects);
    }

    private void removemulView(View projects, LinearLayout layoutproject,int n,String title,String details) {
        if(n == 11){
            projecttitlelist.remove(title);
            projectdetaillist.remove(details);
        }
        else if(n == 12){
            achievementstitlelist.remove(title);
            achievementdetaillist.remove(details);
        }
        layoutproject.removeView(projects);
    }


    private void addView(View text,LinearLayout field,int n) {
        /*View languages = getLayoutInflater().inflate(R.layout.row_add_language,null,false);*/
        EditText content = (EditText)text.findViewById(R.id.edit_text);
        content.setId(skillslist.size()+1);
        content.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    if(n == 1){
                        skillslist.add(content.getText().toString());

                    }
                    else if(n == 2){
                        languageslist.add(content.getText().toString());
                    }
                    else if (n == 3){
                        hobbieslist.add(content.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
        ImageView imageclose =(ImageView)text.findViewById(R.id.image_remove);
        imageclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(text,field,n,content.getText().toString());
            }
        });

        field.addView(text);
    }
    private void removeView(View view,LinearLayout field,int n,String content){
        if(n==1){
            skillslist.remove(content);
        }
        else if(n==2){
            languageslist.remove(content);
        }
        else if(n==3){
            hobbieslist.remove(content);
        }
        field.removeView(view);
    }

}