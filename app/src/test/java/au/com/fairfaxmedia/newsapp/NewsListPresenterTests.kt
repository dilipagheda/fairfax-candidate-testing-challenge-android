package au.com.fairfaxmedia.newsapp

import au.com.fairfaxmedia.newsapp.model.Asset
import au.com.fairfaxmedia.newsapp.presenter.NewsListPresenter
import au.com.fairfaxmedia.newsapp.presenter.NewsListState
import au.com.fairfaxmedia.newsapp.usecase.NewsListUseCase
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks

/**
 * Unit tests for the {@link NewsListPresenter}.
 */
class NewsListPresenterTests {

    @Mock
    var mNewsListView: NewsListContract.View? = null

    @Mock
    var mNewsListUseCase: NewsListUseCase? = null

    @Mock
    var mAssetList: List<Asset>? = null

    @Before
    fun setup() {
        initMocks(this)
    }

    /**
     * Test case that checks the app retrieves data from server if there is no saved instance state
     *
     * @preconditions
     * @result
     *
     */
    @Test
    fun showLoadingFromRemoteIfSavedStateNotExist() {
        // given
        `when`(mNewsListUseCase!!.loadFromRemoteDataSource()).thenReturn(Observable.just(mAssetList!!))
        val presenter = NewsListPresenter(mNewsListUseCase)

        // when
        presenter.attachView(mNewsListView)

        // then
        verify<NewsListContract.View>(mNewsListView).showLoadingView()
        verify<NewsListUseCase>(mNewsListUseCase).loadFromRemoteDataSource()
    }

    /**
     * Test case that checks the app retrieves cached data if there is saved instance state
     *
     * @preconditions
     * @result
     *
     */
    @Test
    fun showLoadingFromSavedStateIfSavedStateExist() {
        // given
        val presenter = NewsListPresenter(mNewsListUseCase)
        presenter.savedState = NewsListState(0)
        val asset = Asset()
        asset.url = "http://google.com"
        presenter.setItems(listOf(asset))

        // when
        presenter.attachView(mNewsListView)

        // then
        verify<NewsListContract.View>(mNewsListView, never()).showLoadingView()
        verify<NewsListUseCase>(mNewsListUseCase, never()).loadFromRemoteDataSource()
        verify<NewsListContract.View>(mNewsListView).showResult()
        verify<NewsListContract.View>(mNewsListView).scrollToPosition(0)
    }

    /**
     * Test case that checks the app shows error if there is network error
     *
     * @preconditions
     * @result
     *
     */
    @Test
    fun showErrorIfNetworkErrorHappens() {
        // given
        `when`(mNewsListUseCase!!.loadFromRemoteDataSource()).thenReturn(Observable.error(Exception("server is down")))
        val presenter = NewsListPresenter(mNewsListUseCase)

        // when
        presenter.attachView(mNewsListView)

        // then
        verify<NewsListContract.View>(mNewsListView, never()).showResult()
        verify<NewsListContract.View>(mNewsListView).showError("server is down")
        verify<NewsListContract.View>(mNewsListView).hideLoadingView()
    }

    /**
     * Test case that checks the app shows detail page if an item is clicked {@link NewsListPresenter#onItemClicked}
     *
     * @preconditions
     * @result
     *
     */
    @Test
    fun shouldOpenDetailScreenOnListItemClick() {
        // given
        val presenter = NewsListPresenter(mNewsListUseCase)
        presenter.savedState = NewsListState(0)
        val asset = Asset()
        asset.url = "http://google.com"
        presenter.setItems(listOf(asset))

        // when
        presenter.attachView(mNewsListView)
        presenter.onItemClicked(0)

        // then
        verify<NewsListContract.View>(mNewsListView).openArticleScreen("http://google.com")
    }
}
