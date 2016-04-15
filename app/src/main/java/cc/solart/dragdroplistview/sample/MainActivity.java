package cc.solart.dragdroplistview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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

public class MainActivity extends AppCompatActivity implements AbsTileAdapter.DragDropListener {

    DragDropListView mListView;
    SimpleTileAdapter mSimpleTileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleTileAdapter = new SimpleTileAdapter(this, this,
                new TileView.OnSelectedListener() {
                    @Override
                    public void onTileSelected(IDragEntity entity) {
                        Toast.makeText(MainActivity.this, ((SimpleDragEntity) entity).getName(), Toast.LENGTH_SHORT).show();
                    }
                });
        //TODO :set data source
        mSimpleTileAdapter.setData(obtainData());

        mListView = (DragDropListView) findViewById(R.id.list_view);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setVerticalScrollbarPosition(View.SCROLLBAR_POSITION_RIGHT);
        mListView.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        mListView.getDragDropController().addOnDragDropListener(mSimpleTileAdapter);
        final ImageView dragShadowOverlay =
                (ImageView) findViewById(R.id.contact_tile_drag_shadow_overlay);
        mListView.setDragShadowOverlay(dragShadowOverlay);

        final LayoutAnimationController controller = new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        controller.setDelay(0);
        mListView.setLayoutAnimation(controller);
        mListView.setAdapter(mSimpleTileAdapter);
    }

    private List<IDragEntity> obtainData() {
        List<IDragEntity> list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            SimpleDragEntity entry = new SimpleDragEntity();
            entry.setId(i);
            entry.setName("name " + i);
            list.add(entry);
        }
        return list;
    }

    @Override
    public DragDropListView getDragDropListView() {
        return mListView;
    }

    @Override
    public void onDataSetChangedForResult(ArrayList<IDragEntity> list) {
        // TODO you can save the result
    }
}
