package com.example.easy_learning.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easy_learning.R;
import com.example.easy_learning.adapter.TodoAdapter;
import com.example.easy_learning.database.DatabaseTodo;
import com.example.easy_learning.databinding.FragmentUserBinding;
import com.example.easy_learning.model.Todo;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {
    private RecyclerView view;
    private int user;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1="param1";
    private static final String ARG_PARAM2="param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment=new UserFragment();
        Bundle args=new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1=getArguments().getString(ARG_PARAM1);
            mParam2=getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentUserBinding binding= DataBindingUtil.inflate(inflater,
                R.layout.fragment_user,container,false);

        user=getActivity().getIntent().getIntExtra("user",0);
        getTodo();

        view=binding.view;
        view.setLayoutManager(new LinearLayoutManager(getContext()));




        return binding.getRoot();
    }

    private void getTodo()
    {
        class GetTodo extends AsyncTask<Void, Void, List<Todo>>
        {
            @Override
            protected List<Todo> doInBackground(Void... voids)
            {
                return DatabaseTodo.getInstance(getContext()).getDatabase().todoDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Todo> todos)
            {
                super.onPostExecute(todos);

                TodoAdapter todoAdapter=new TodoAdapter(todos, getContext(),user);;
                view.setAdapter(todoAdapter);
            }
        }

        GetTodo getTodo=new GetTodo();
        getTodo.execute();
    }

}