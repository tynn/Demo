package demo.img.app.ui.list

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import demo.img.app.R.color.colorPrimaryLight
import demo.img.app.color.PaletteTarget.Companion.into
import demo.img.app.databinding.ViewThumbnailBinding
import demo.img.app.model.Image
import xyz.tynn.hoppa.binding.BindingViewHolder
import xyz.tynn.hoppa.recycler.setOnClickListener

internal class ListAdapter(
    private val picasso: Picasso,
) : ListAdapter<Image, BindingViewHolder<ViewThumbnailBinding>>(
    ListItemCallback,
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = BindingViewHolder(
        parent,
        ViewThumbnailBinding::inflate,
    ) {
        setOnClickListener {
            it.findNavController().navigate(
                ListFragmentDirections.showDetailScreen(
                    getItem(bindingAdapterPosition),
                )
            )
        }
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<ViewThumbnailBinding>,
        position: Int,
    ) = with(holder.binding) {
        with(getItem(position)) {
            listItemCaption.text = author
            picasso.load(thumbnail)
                .placeholder(colorPrimaryLight)
                .into(listItemThumbnail, listItemCaption)
        }
    }
}
