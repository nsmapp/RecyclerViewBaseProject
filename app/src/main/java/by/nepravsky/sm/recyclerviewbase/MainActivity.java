package by.nepravsky.sm.recyclerviewbase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import by.nepravsky.sm.recyclerviewbase.databinding.ActivityMainBinding;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new MainViewModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.viewModel, viewModel);
        binding.recycler.addItemDecoration(new DividerItemDecoration(this,1));


    }
}
