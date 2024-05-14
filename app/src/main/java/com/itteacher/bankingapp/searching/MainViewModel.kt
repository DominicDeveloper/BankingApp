package com.itteacher.bankingapp.searching

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel:ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _persons = MutableStateFlow(allPersonCards)
    val persons = searchText
        .combine(_persons){ text, persons ->
            if (text.isBlank()){
                persons
            }else{
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
            _persons.value)

    fun onSearchTextChange(text:String){
        _searchText.value = text
    }

}
data class PersonCards(
    val name:String,
    val card:String
){
    fun doesMatchSearchQuery(query:String):Boolean{
        val matchingCombinations = listOf(
            "$name",
            "$card",
            "${name.first()} ${card.first()}"
        )
        return matchingCombinations.any{
            it.contains(query,ignoreCase = true)
        }
    }
}
private val allPersonCards = listOf(
    PersonCards(
        name = "DOMINIC",
        card = "9860060523431232"
    ),
    PersonCards(
        name = "BOBUR",
        card = "9860080513439638"
    ),
    PersonCards(
        name = "MARYAM",
        card = "8600989593499932"
    ),
    PersonCards(
        name = "FERUZ",
        card = "9862485573439630"
    ),
    PersonCards(
        name = "SHAHINA",
        card = "8600785573479737"
    )

)