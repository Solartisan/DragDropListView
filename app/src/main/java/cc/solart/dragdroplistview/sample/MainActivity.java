package cc.solart.dragdroplistview.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cc.solart.dragdrop.DragDropListView;
import cc.solart.dragdrop.IDragEntity;
import cc.solart.dragdrop.adapter.AbsTileAdapter;
import cc.solart.dragdroplistview.sample.adapter.SimpleTileAdapter;
import cc.solart.dragdroplistview.sample.model.SimpleDragEntity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button simple = (Button) findViewById(R.id.simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SimpleActivity.class);
                startActivity(intent);
            }
        });
        Button thumbtack = (Button) findViewById(R.id.thumbtack);
        thumbtack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThumbtackActivity.class);
                startActivity(intent);
            }
        });
    }
}
