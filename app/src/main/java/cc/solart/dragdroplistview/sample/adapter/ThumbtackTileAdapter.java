package cc.solart.dragdroplistview.sample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cc.solart.dragdrop.IDragEntity;
import cc.solart.dragdrop.adapter.AbsTileAdapter;
import cc.solart.dragdroplistview.sample.R;
import cc.solart.dragdroplistview.sample.TileView;


public class ThumbtackTileAdapter extends AbsTileAdapter {
    private TileView.OnSelectedListener mListener;
    public ThumbtackTileAdapter(Context context, DragDropListener dragDropListener, TileView.OnSelectedListener listener) {
        super(context, dragDropListener);
        mListener = listener;
        setTilesStartLimit(1);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TileView tileView = null;

        if (convertView != null && convertView instanceof TileView) {
            tileView = (TileView) convertView;
        }

        if (tileView == null) {
            tileView = (TileView) View.inflate(mContext,
                    R.layout.simple_tile_view, null);
        }

        tileView.setListener(mListener);

        tileView.renderData(getItem(position));
        ImageView pin = (ImageView) tileView.findViewById(R.id.tile_pin);
        if(position <=1){
            pin.setVisibility(View.VISIBLE);
        }else {
            pin.setVisibility(View.GONE);
        }

        return tileView;
    }

    @Override
    protected IDragEntity getDragEntity(View view) {
        return ((TileView)view).getDragEntity();
    }
}
