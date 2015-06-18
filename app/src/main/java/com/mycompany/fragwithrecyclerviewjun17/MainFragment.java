package com.mycompany.fragwithrecyclerviewjun17;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Callbacks} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "com.mycompany.fragwithrecyclerviewjun17.NAME";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private Callbacks callbacks;
    private RecyclerView carsRecyclerView;
    private CarAdapter carAdapter;

    OnClickListener setHomePage = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = ((EditText) getView().findViewById(R.id.mainfragment_name)).getText().toString();

            callbacks.setHomePage(name);
        }
    };

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_NAME);
        }

    }

    private static List<Car> getCarsDataset() {
        List<Car> cars = new ArrayList<>();

        String[] makes = {"Ford", "GM", "BMW", "Toyota", "Honda", "Mercedes"};
        String[] model = {"F150", "Corvette", "M8", "Camry", "Accord", "S65"};

        for(int i=0; i<makes.length && i<model.length; i++) {
            Car car = new Car(makes[i], model[i]);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        carsRecyclerView = (RecyclerView) view.findViewById(R.id.cars);

        List<Car> carsDataset = getCarsDataset();

        carAdapter = new CarAdapter(carsDataset);

        carsRecyclerView.setAdapter(carAdapter);

        carsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Button sd = (Button) view.findViewById(R.id.mainfragment_send);
        sd.setOnClickListener(setHomePage);

        TextView setCity = (TextView) view.findViewById(R.id.mainfragment_city);
        setCity.setText(mParam1);
        return view;
    }

    public void getCity(String city) {
        ((TextView) getView().findViewById(R.id.mainfragment_city)).setText(city);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String name) {
        if (callbacks != null) {
            callbacks.setHomePage(name);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface Callbacks {
        // TODO: Update argument type and name
        public void setHomePage(String name);
    }

}
