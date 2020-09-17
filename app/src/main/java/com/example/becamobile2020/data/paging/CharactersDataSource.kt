package com.example.becamobile2020.data.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.becamobile2020.data.MarvelServices
import com.example.becamobile2020.data.response.Character
import io.reactivex.disposables.CompositeDisposable


class CharactersDataSource(
    private val marvelServices: MarvelServices,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, Character>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        val numberOfItems = params.requestedLoadSize
        createObservable(0,1, numberOfItems,callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        val page = params.key
        val numberOfItems = params.requestedLoadSize
        createObservable(page,page+1, numberOfItems,null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        val page = params.key
        val numberOfItems = params.requestedLoadSize
        createObservable(page,page-1, numberOfItems,null, callback)
    }

    private fun createObservable(requestedPage:Int,
                              adjacentPage: Int,
                              requestedLoadSize:Int,
                              initialCallback: LoadInitialCallback<Int, Character>?,
                              callback: LoadCallback<Int, Character>?){

        compositeDisposable.add(
            marvelServices.getHeroesPaging((requestedPage*requestedLoadSize)).subscribe({
                Log.d("NGVL" , "loading page: $requestedPage")
                initialCallback?.onResult(it.data.results, null , adjacentPage)
                callback?.onResult(it.data.results, adjacentPage)
            }, {
                Log.d("NGVL" , "error loading page: $requestedPage" , it)
            })
        );
    }
}


