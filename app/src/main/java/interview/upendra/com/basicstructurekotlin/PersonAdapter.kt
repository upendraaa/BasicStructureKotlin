package interview.upendra.com.basicstructurekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(personList : ArrayList<Person>): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    var persons:ArrayList<Person>  = personList;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false);

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return persons.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}



