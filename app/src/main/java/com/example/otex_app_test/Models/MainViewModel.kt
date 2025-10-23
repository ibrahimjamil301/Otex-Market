package com.example.otex_app_test.Models

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.otex_app_test.R
import com.example.otex_app_test.data.local.AppDatabase
import com.example.otex_app_test.data.local.entities.Brand
import com.example.otex_app_test.data.local.entities.Filtering
import com.example.otex_app_test.data.local.entities.Item
import com.example.otex_app_test.data.local.entities.Plan
import com.example.otex_app_test.data.local.entities.Recommended
import com.example.otex_app_test.data.repository.MainRepository
import kotlinx.coroutines.launch
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MainRepository
    @SuppressLint("StaticFieldLeak")
    var items: LiveData<List<Item>>
    var brands: LiveData<List<Brand>>
    var recommended: LiveData<List<Recommended>>
    var plans: LiveData<List<Plan>>
    var filtering: LiveData<List<Filtering>>
    init {
        val db = AppDatabase.getDatabase(application)
        repository = MainRepository(db)

        items = repository.getAllItems()
        brands = repository.getAllBrands()
        recommended = repository.getAllRecommended()
        plans = repository.getAllPlans()
        filtering = repository.getAllFiltering()

        loadItems()
        loadBrands()
        loadRecommended()
        loadPlans()
        loadFiltering()
    }
    fun loadItems() {
        viewModelScope.launch {
            val sampleItems = listOf(
                Item(1, "كل العروض"),
                Item(2, "ملابس"),
                Item(3, "أكسسوارات"),
                Item(4, "الكترونيات"),
                Item(5, "ساعات"),
                Item(6, "موبايلات")
            )
            repository.insertItems(sampleItems)
        }
    }
    fun loadBrands() {
        viewModelScope.launch {
            val sampleBrands = listOf(
                Brand(1, "موضه رجالي", R.drawable.brand1),
                Brand(2, "ساعات", R.drawable.brand2),
                Brand(3, "موبايلات", R.drawable.brand3),
                Brand(4, "منتجات تجميل", R.drawable.brand4),
                Brand(5, "عقارات", R.drawable.brand5)
            )
            repository.insertBrands(sampleBrands)
        }
    }
    fun loadRecommended() {
        viewModelScope.launch {
            val sampleRecommended = listOf(
                Recommended(1, R.drawable.shirit2),
                Recommended(2, R.drawable.shirt),
                Recommended(3, R.drawable.shirt),
                Recommended(4, R.drawable.shose),
                Recommended(5, R.drawable.shirt),
                Recommended(6, R.drawable.shose),
                Recommended(7, R.drawable.shirit2),
                Recommended(8, R.drawable.shirt)
            )
            repository.insertRecommended(sampleRecommended)
        }
    }
    fun loadPlans() {
        viewModelScope.launch {
            val samplePlan = listOf(
                Plan(
                    1,
                    "الباقة الأساسية",
                    "3000ج.م",
                    "صلاحية الأعلان 30 يوم"
                ),
                Plan(
                    2,
                    "أكسترا",
                    "4000ج.م", "صلاحية الأعلان 30 يوم",
                    "رفع لأعلى القائمة كل 3 أيام",
                    "تثبيت فى مقاول صحى",
                    "( خلال ال48 ساعة القادمة)",
                    "",
                    "",
                    "",
                    "7",
                    "ضعف عدد\nالمشاهدات"
                ),
                Plan(
                    3,
                    "بلس",
                    "5000ج.م",
                    "صلاحية الأعلان 30 يوم",
                    "رفع لأعلى القائمة كل 2 أيام",
                    "تثبيت فى مقاول صحى",
                    "( خلال ال48 ساعة القادمة)",
                    "ظهور فى كل محافظات مصر",
                    "أعلان مميز",
                    "تثبيت فى مقاول صحى فى\n الجهراء",
                    "18",
                    "ضعف عدد\nالمشاهدات",
                    "أفضل قيمة مقابل سعر      "
                ),
                Plan(
                    4,
                    "سوبر",
                    "7000ج.م",
                    "صلاحية الأعلان 30 يوم",
                    "رفع لأعلى القائمة كل 2 أيام",
                    "تثبيت فى مقاول صحى",
                    "( خلال ال48 ساعة القادمة)",
                    "ظهور فى كل محافظات مصر",
                    "أعلان مميز",
                    "تثبيت فى مقاول صحى فى\n الجهراء",
                    "24",
                    "ضعف عدد\nالمشاهدات",
                    "أعلى مشاهدات"
                )
            )
            repository.insertPlans(samplePlan)
        }
    }
    fun loadFiltering() {
        viewModelScope.launch {
            val sampleFiltering = listOf(

                Filtering(1, "الكل", "type"),
                Filtering(2, "توين هاوس", "type"),
                Filtering(3, "فيلا منفصلة", "type"),
                Filtering(4, "تاون هاوس", "type"),

                Filtering(5, "4 غرف", "numberOfRooms"),
                Filtering(6, "5 غرف+", "numberOfRooms"),
                Filtering(7, "الكل", "numberOfRooms"),
                Filtering(8, "غرفتين", "numberOfRooms"),
                Filtering(9, "3 غرف", "numberOfRooms"),

                Filtering(10, "أي", "paymentMethod"),
                Filtering(11, "تقسيط", "paymentMethod"),
                Filtering(12, "كاش", "paymentMethod"),

                Filtering(13,"أي" , "propertyCondition"),
                Filtering(14, "جاهز", "propertyCondition"),
                Filtering(15, "قيد الأنشاء", "propertyCondition")
            )
            repository.insertFiltering(sampleFiltering)
        }
    }
    fun getFilteringByType(type: String): LiveData<List<Filtering>> {
        return repository.getFilteringByType(type)
    }
}
