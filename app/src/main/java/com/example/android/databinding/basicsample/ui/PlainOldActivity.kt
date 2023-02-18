import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.SimpleViewModel
import com.example.android.databinding.basicsample.databinding.PlainActivityBinding

/**
 * Plain old activity with lots of problems to fix.
 */
class PlainOldActivity : AppCompatActivity() {
    lateinit var binding: PlainActivityBinding
    private val viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(
        application
    )
    private val viewModel by lazy {
        viewModelFactory.create(SimpleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.plain_activity)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
