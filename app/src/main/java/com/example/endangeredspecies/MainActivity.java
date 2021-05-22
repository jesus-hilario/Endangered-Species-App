package com.example.endangeredspecies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Integer[] Animals = {R.drawable.american_eagle,R.drawable.asian_elephant, R.drawable.black_panther,
        R.drawable.giant_panda, R.drawable.mountain_gorilla, R.drawable.polar_bear};

        ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pics = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),"Selected Species" + (position +1), Toast.LENGTH_SHORT).show();
                pics.setImageResource(Animals[position]);
            }
        });

    }

    public class ImageAdapter extends BaseAdapter{

        private Context context; //context holds all data within the data source that grid provides
        public ImageAdapter (Context c) {
                context = c;
        }

        @Override
        public int getCount() {
            return Animals.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        //onItemClick listens to actions, and setImageResource() method is the method that actually displays the given resource
        //The Singular AdapterView wouldn't be able to show anything without this method that establishes the layout of how the image will be displayed
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Animals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new ViewGroup.LayoutParams(330,300));
            return pic;
        }
    }

}