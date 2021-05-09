package teamawesome.smartreg;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import teamawesome.smartreg.dummy.RoomListContent;

    /*
    * TODO: Make prettier
    * TODO: Get methods to display the actual temperatures from a Room
    * */


/**
 * A fragment representing a single Room detail screen.
 * This fragment is either contained in a {@link RoomListActivity}
 * in two-pane mode (on tablets) or a {@link RoomDetailActivity}
 * on handsets.
 */
public class RoomDetailFragment extends Fragment {

    TextView actuationTempValue = null;
    SeekBar actuationTempControl = null;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private RoomListContent.Room mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RoomDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = RoomListContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.room_name);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.room_detail, container, false);

        if (mItem != null) {

            //Instantiate Actuation Temperature Control SeekBar & Current Temperature TextView
            actuationTempValue =  rootView.findViewById(R.id.text_room_detail_actuation_temp_value);
            actuationTempControl =  rootView.findViewById(R.id.seekBar_room_detail_actuation_temp);

            //Display current actuation temperature value
            actuationTempValue.setText(Integer.toString(mItem.actuation_temp) + "°C");

            //Create a listener for the Actuation Temperature Control SeekBar
            actuationTempControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    //Update actuation temp for the room from SeekBar progress
                    //Minimum actuation temperature is added to the progress
                    mItem.actuation_temp = progress + mItem.min_actuation_temp;
                    actuationTempValue.setText(Integer.toString(mItem.actuation_temp) + "°C");

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }

        return rootView;
    }

}
