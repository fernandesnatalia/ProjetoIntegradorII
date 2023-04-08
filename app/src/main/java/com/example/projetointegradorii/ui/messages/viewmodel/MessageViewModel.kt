package com.example.projetointegradorii.ui.messages.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.tana.domain.singleliveevent.SingleLiveEvent
import com.example.projetointegradorii.data.AppApplication
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.domain.repository.RoomDatabaseRepository
import com.example.projetointegradorii.domain.viewState.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MessageViewModel: ViewModel() {
    val list = SingleLiveEvent<ViewState<List<Message>>>()
    private val dao = AppApplication.getDatabase().piDAO()
    private val repository = RoomDatabaseRepository(dao)

    fun getList(){
        viewModelScope.launch {
            list.value = ViewState.loading(null)
            try{
                val withContext = withContext(Dispatchers.Default){
                    val list = repository.getMessages()
                    ViewState.success(list)
                }
                withContext.let {
                    list.value = ViewState.success(it.data)
                }
            }catch(e:Exception){
                list.value = ViewState.error(null,e.message)
            }
        }
    }
}