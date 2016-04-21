/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cc.solart.dragdroplistview.sample;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import cc.solart.dragdrop.DragDropListView;
import cc.solart.dragdrop.IDragEntity;
import cc.solart.dragdrop.adapter.AbsTileAdapter;
import cc.solart.dragdroplistview.sample.model.SimpleDragEntity;


/**
 * A TileView displays a picture and name
 */
public class TileView extends CardView {
    private final static String TAG = TileView.class.getSimpleName();
    private static final ClipData EMPTY_CLIP_DATA = ClipData.newPlainText("", "");
    private ImageView mPin;
    private TextView mName;
    protected OnSelectedListener mListener;
    private IDragEntity mIDragEntity;

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mName = (TextView) findViewById(R.id.tile_name);
        mPin = (ImageView) findViewById(R.id.tile_pin);

        setOnClickListener(createClickListener());

        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // NOTE The drag shadow is handled in the ListView.
                v.startDrag(EMPTY_CLIP_DATA, new DragShadowBuilder(),
                        DragDropListView.DRAG_FAVORITE_TILE, 0);
                return true;
            }
        });
    }


    protected OnClickListener createClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) {
                    return;
                }

                mListener.onTileSelected(mIDragEntity);
            }
        };
    }

    public IDragEntity getDragEntity() {
        return mIDragEntity;
    }

    public void renderData(IDragEntity entity) {
        mIDragEntity = entity;

        if (entity != null && entity != AbsTileAdapter.BLANK_ENTRY) {

            if(entity instanceof SimpleDragEntity) {
                mName.setText(((SimpleDragEntity) mIDragEntity).getName());
            }
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.INVISIBLE);
        }
    }

    public void setListener(OnSelectedListener listener) {
        mListener = listener;
    }



    public interface OnSelectedListener {
        /**
         * Notification that the tile was selected; no specific action is dictated.
         */
        void onTileSelected(IDragEntity entity);
    }
}
