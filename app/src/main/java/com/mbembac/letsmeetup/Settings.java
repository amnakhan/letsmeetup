package com.mbembac.letsmeetup;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;
import java.util.ArrayList;

import com.parse.ParseUser;

public class Settings extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_settings, container, false);

        return v;

    }
}

