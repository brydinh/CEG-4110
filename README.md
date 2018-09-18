# CEG4110_HW1

<b>CEG-4110 HW 1: Random Color Selector & Drawing Pad</b>

This android application was made for the first homework assignment of CEG-4110: Intro to Software Engineering at Wright State University. It is a relatively simple app consisting of two activities: a random color selector and a drawing pad. 

The random color selector allows the user to enter text and changes the text to a random color and 
the drawing pad allows the user to draw images onto the screen with different colors. There is also save functionality implemented onto the drawing pad where the users can save their pictures. Users can switch between activities by swiping left or right or selecting the respective tab.

Before this homework assignment I had very little experience working with Android Studio, so it was very time consuming trying to get used to the Android Studio IDE and the gimmicks behind it. I also did not know how to import libraries so that was also a huge learning curve. I used many resources to help complete this project (credited in Resources I Used).

# App Information:

<b>App SETUP:</b>

-Copy the APK from the bin folder (provided by PILOT deliverable) onto USB and you should be good

If you want to save your drawings you MUST first grant app permissions for storage.

1) Select the app & select app info
2) Select permissions
3) Toggle the switch for storage
   
  ![](screenshots/Screenshot_1537279293.png)
  ![](screenshots/Screenshot_1537279324.png)
  ![](screenshots/Screenshot_1537279329.png)
  
Now you can save your awesome drawings!!

<b>Activity 1- Random Color Selector:</b>

 This is the first activity where the user can enter a string in the textfield. Once the user selects the "CHANGE COLOR" button the string will change to a random color and display its respective RGB and Hex values. The textfield will only change text color as long as it is populated. Else, it will throw an error message and prompt the user for input.
       
 ![](screenshots/Screenshot_1537274000.png)
 ![](screenshots/Screenshot_1537274007.png)
 ![](screenshots/Screenshot_1537274016.png)
 ![](screenshots/Screenshot_1537274048.png)
      
<b>ACTIVITY 2- Drawing Pad:</b>
 
 This is the second activity where the user can draw images onto the screen. Besides drawing, the user can also change brush color, save pictures (as long as they followed APP SETUP instructions), and clear their drawings. If the user did not follow the APP SETUP instructions, they will not be able to save their picture (An error message will pop up indicating that they need external permissions). The user can also draw many paths with different colors.
           
![](screenshots/Screenshot_1537273935.png)
![](screenshots/Screenshot_1537274144.png)
![](screenshots/Screenshot_1537286974.png)
![](screenshots/Screenshot_1537287012.png)

# Software Design Discussion:

 <b>Random Color Selector-</b>
        I implemented the random color generator by declaring a random and generated random int values for 3 ints (These are for the RGB values). I then used the 3 RGB values to declare the new color. Finally I set the text color to the new color and got its hex representation by calling Integer.toHexString(color). To display the RGB and hex values, I set those variables to be dislpayed on a label.
 
<b>Drawing Pad-</b>
        The Drawing Pad actvity implements a custom view called PaintView that was created solely for the drawing functionality. There are several methods that contribute to PaintView's functionality: 
        
   * setColor()- Set the paint to a new color if the user wants to change color
   * reset()- Will clear out the canvas
   * onDraw()- Involved with touch event
   * onTouchEvent()- Involved with touch event

onDraw() and onTouchEvent() will keep track whether or not the user has started drawing, is in motion, or stopped and handles accordingly. As the user draws paths, onTouchEvent() keeps tracks of the starting and ending points of the path and adds it to the bitmap. onDraw() handles the rest and actually draws the picture.

In my DrawingPad activity, I have the clear button call reset() in the custom view accordingly. I also implement the external Color Picker library where if it executes it will call setColor(). For save, I handled the logic in that handler seperately.

 # Resources I Used:
 
 These are the sources I used to help implement the application (I give credit to them okay):
 
  <b> What I used to implement the drawing pad:</b>
            https://code.tutsplus.com/tutorials/android-sdk-create-a-drawing-app-touch-interaction--mobile-19202

  <b>AmbilWarna Color Picker Library: </b>  
            https://github.com/yukuku/ambilwarna
  
  
  # Dependencies:
  <b>TO USE AMBILWARNA COLOR PICKER LIBRARY:</b>
            Include this line in build.gradle or build.gradle(Module: app)--
            
                dependencies {
                implementation 'com.github.yukuku:ambilwarna:2.0.1'
                }


      
    


