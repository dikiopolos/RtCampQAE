# QA ASSIGNMENT


## MANUAL TESTING
Open file:  rtCampQAE_ManualTestResults.odt  using Word or other document reader.  

- This document is a basic test results log, with expected/actual and pass/fail notation for each item in the Manual Test assignment.  Each defect is cross-referenced with the Git Issue #.  
<br>
<br>

## AUTOMATION TESTING

The automation frameworks use Selenium with Java, and JUnit.  The tests are to be executed in Eclipse.  
 
- There are 4 .java test files that perform the 6 Test Cases.  

   - AlbumTest_rtCamp.java :  Creates a new album, sets privacy to "Private", uploads 5 photos to the album.  Opens one of the photos in the album and performs assertion to confirm if a photo within the album is set to "private" with lock icon.  If 'private', prints confirmation with extracted actual setting to console log.  If setting is not private, test will end with no confirmation printout.   
   
   - CoverTest_rtCamp.java :  Changes the cover photo, extracts the actual status message and compares it to the expected message to confirm whether the cover successfully changed.  If change was successful, prints confirmation with extracted actual status message to console log.  If change was not successful, prints "Test Failed" to console. After confirmation, it changes cover to rtCamp logo photo.  
   
   - LoginTest_rtCamp.java :  a) Performs valid credentials test and extracts/prints the title of the landing page.  If successfully logged in to expected landing page, confirmation prints to log.  If user is not logged in with valid credentials and lands on login page, will print 'Test1 Failed' to log.  b) Performs invalid credentials test and extracts/prints the title of the landing page.  Extracts/prints bad-password error message.  If user is not logged in and lands on login page, prints confirmation and 'Test2 passed'.  If user is logged in with invalid credentials, prints "Test2 failed"  c) Following initial failure, performs re-login with valid credentials and extracts title of landing page.  If logged in and actual landing matches expected landing, prints 'Test3 Passed'.  If not, prints "Test3 Failed". --See Issue #63.

   - MediaPrivacyLikes_rtCamp.java : a) Adds a new post with uploaded photo, sets privacy to 'private'.  Opens photo and extracts actual privacy setting, prints to console.  b) On the open unliked photo, performs assertion that 'Like' button is displayed, prints confirmation to console.  If unliked photo displays "Unlike" button, test will end with no confirmation printout.  Clicks "Like" and performs asssertion that "Unliked" button is displayed, prints confirmation.  c) Navigates to "Liked Media" page.  Confirms the photo liked in previous test step is displayed on Liked page, prints confirmation to console.   

<br>

### DEPENDENCIES & SETUP

Test was built and executed using the following.  Older versions might work, but I have not tested them.  
- Java 12: JRE/JDK
- JUnit5
- Selenium 
- Eclipse 2019  Eclipse IDE for Java Developers  Version: 2019-06 (4.12.0)


1. JAVA 
   - Download and install JDK   https://www.oracle.com/technetwork/java/javase/downloads/index.html
  
2. Selenium


3.  JUnit5


4. Eclipse 2019 - 
   - Download and Install       https://www.eclipse.org/downloads/
   <br><br>
   
 ### LOCAL CONFIGURATION INSTRUCTIONS
 
 1. Import the RtCampQAE package from Git into Eclipse
    - In Eclipse, click File > Import > from Git > RtCampQAE > 
   
    - The imported package should have the following structure in the Package Explorer

      ![Eclipse project file structure](https://user-images.githubusercontent.com/49427009/61268624-a0072580-a761-11e9-87b9-0892bcba5569.jpg)
    <br><br>
 2. ADD JARs to RtCampQAE Build Path
    - Right-click on RtCampQAE > click Build Path > Configure Build Path
    - Click Libraries tab > Classpath > Add External JARs
    - Navigate to the local folder where you extracted/saved the JARs.
      - Add Selenium and JUnit JARs: 
        - selenium-server-standalone-3.141.59.jar
        - hamcrest-all-1.3.jar
        - hamcrest-core-2.1.jar
        - junit-4.12.jar
      - Verify "JRE System Library [JavaSE-12]" is listed under Modulepath
      - Click Apply & Close
      <br><br>
  3. Edit DriverFactory.java with your local Firefox webdriver path
      - Identify the local file path of your geckodriver.exe
      - In Eclipse, open src > utilities > DriverFactory.java .  Replace the [String driverPath] value with your local path
      
        ![image](https://user-images.githubusercontent.com/49427009/61272317-79022100-a76c-11e9-9368-0efccd7786ff.png)
      
  4. Edit the following 3 test java files with your local Media path
     - Identify the local file path of the (9) imported .jpeg files 
      
     - In Eclipse, open src > tests > AlbumTest_rtCamp.java.  Replace [String mediaPath] value with your local path 
     
       ![image](https://user-images.githubusercontent.com/49427009/61274357-473f8900-a771-11e9-817e-980e4be27412.png)
       
     - In Eclipse, open src > tests > CoverTest_rtCamp.java.  Replace [String mediaPath] value with your local path
     
        ![image](https://user-images.githubusercontent.com/49427009/61274579-b87f3c00-a771-11e9-9040-d593beb39be1.png) 
        
     - In Eclipse, open src > tests>  MediaPrivacyLikesTest_rtCamp.java.  Replace [String mediaPath] valuse with your local path
       
       ![image](https://user-images.githubusercontent.com/49427009/61275487-b4ecb480-a773-11e9-823b-b45eeba236f5.png)
     
    

   
   


