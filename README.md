
## Suggested Tests

1) Verify, stories has image, headline, theAbstract and byLine on index screen
 - Implemented and passed
2) Verify, index screen has no more than 10 articles
 - Implemented and passed
3) Verify, tapping a story should take user to full article
 - Implemented and passed
 
 ## Submission Notes

* Design pattern : I have not used any design pattern in perticular as it is such a small app with only two screens. However, I would typically 
  implement a page object pattern for larger apps. In page object pattern, there is one class with set of methods that represents a screen. 
  Then, there is a wrapper class that contains methods containing calls to different methods of a class representing a screen.
  
* Explain what each test does in code comments or in document
  Explanation is given in code comment.
  
* Test report, it could be generated or simply in document with pass/fail status
  All 3 tests passed.
  
* If you had to modify Application/Product code for testability, mention the changes you made
  I had to make below change in application code so that each itemView can be easily located and test can be made more robust.
  
   In file - NewsListAdapter.java

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, int position) {
        holder.itemView.setId(position); // Added this line to set Id for each itemView
        mNewsListPresenter.onBindViewHolderAtPosition(holder, position);
    }


* Any 3rd party libraries used and rational ?
  only had to use hemcrest library for matcher functions
  
* Any additional tests done ? -- apart mentioned in 'suggested tests'
  No. There is one test that can be possibly added which will verify the actual content on the screen. It can be implemented two ways
  (1) : add a function that will make a service call and store response in some object. then use data from it to assert content on the screen.
  (2) : use mock data and inject it in the view. then assert against known values.
  
* Any missing test automation coverage, because it couldn't be easily verified ?
  - test to verify that items are displayed more recent to less recent. it can be implemented but it is more complex and need either of the above two approaches.
  
