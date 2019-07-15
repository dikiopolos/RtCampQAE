# QA ASSIGNMENT


## MANUAL TESTING
Open file:  rtCampQAE_ManualTestResults.odt  using Word or other document reader.  

- This document is a basic test results log, with expected/actual and pass/fail notation for each item in the Manual Test assignment.  Each defect is cross-referenced with the Git Issue #.  
<br>
<br>

## AUTOMATION TESTING

The automation frameworks use Selenium with Java, and JUnit.  The tests are to be executed in Eclipse.  
 
- There are 4 .java test files used to perform the 6 Test Cases.  

   - AlbumTest_rtCamp.java :  Creates a new album, sets privacy to "Private", uploads 5 photos to the album.  Opens one of the photos in the album and performs assertion to confirm whether a photo within the album is set to "private" with lock icon.  If 'private', prints confirmation with extracted actual setting to console log.  If setting is not private, test will end with no confirmation printout.   
   
   - CoverTest_rtCamp.java :  Changes the cover photo, extracts the actual status message and compares it to the expected message to confirm whether or not the cover successfully changed.  If change was successful, prints confirmation with extracted actual status message to console log.  If change was not successful, prints "Test Failed" to console. After confirmation, it reverts cover back to rtCamp logo photo.  
   
   - LoginTest_rtCamp.java :  a) Performs valid credentials test and extracts the title of the landing page and prints the page title to console log.  If user is successfully logged in to expected landing page, confirmation will print to log.  If user is not logged in with valid credentials and lands on login page, will print 'Test1 Failed' to log.  b) Performs invalid credentials test and extracts the title of the landing page.  If user is not logged in and lands on login page, prints confirmation and 'Test2 passed'.  If user is logged in with invalid credentials, prints "Test2 failed"  c) Performs re-login with valid credentials following initial failure and extracts title of landing page.  I
   
