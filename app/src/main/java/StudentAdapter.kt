import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liststudent.R

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var filteredStudents: List<Student> = students

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        //val mssvTextView: TextView = itemView.findViewById(R.id.tvMssv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = filteredStudents[position]
        holder.nameTextView.text = "${student.name} - ${student.mssv}"
    }

    override fun getItemCount(): Int {
        return filteredStudents.size
    }

    fun filter(query: String) {
        filteredStudents = if (query.length > 2) {
            students.filter { it.name.contains(query, ignoreCase = true) || it.mssv.contains(query) }
        } else {
            students
        }
        notifyDataSetChanged()
    }
}
