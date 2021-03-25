package com.example.myboard.Adapter

import com.example.myboard.Model.Photo

//class PostAdapter (val postList : PostDTO, val context : Context)
//    : RecyclerView.Adapter<PostAdapter.ViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return PostAdapter.ViewHolder(LayoutInflater.from(context)
//                .inflate(R.layout.list_photo_view,parent ,false))
//
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(postList[position],context)
//    }
//
//    override fun getItemCount(): Int {
//        return postList.count()
//    }
//
//
//    class ViewHolder (itemView: View? ) : RecyclerView.ViewHolder(itemView!!){
//
//        val photo = itemView?.findViewById<ImageView>(R.id.image_photo)
//        val title = itemView?.findViewById<TextView>(R.id.text_Title)
//        val size  = itemView?.findViewById<TextView>(R.id.text_size)
//        val url =   itemView?.findViewById<TextView>(R.id.text_url)
//        val date =  itemView?.findViewById<TextView>(R.id.text_date)
//
//        fun bind(itemPhoto : Photo? , context: Context){
//            val urlString = itemPhoto?.url.toString()
//            if(!urlString.isEmpty()){
//                photo?.setImageResource(R.mipmap.ic_launcher)
//
//            }else{
//                photo?.visibility = View.GONE
//            }
//            title?.text = itemPhoto?.title
//            size?.text = itemPhoto?.width.toString()
//            size?.append("x${itemPhoto?.height}")
//            url?.text=urlString
//            date?.text=itemPhoto?.date_token
//        }
//
//    }
//}