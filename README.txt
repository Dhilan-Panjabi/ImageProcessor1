Model: 
	ImageModel: 
	
The interface with the methods to be used in the model.

	ImageModelImpl:

The model is the where the ppm files are edited they hold the manipulation images in a hash map with the edited function applied. The model has the two methods which allows the user to either save or load the image given the path and name of the image. This is also where the image command is given and processes it with the image and pixels. 

	Pixel class: 

The pixel class represents a single pixel that has the red, green and blue components which are then edited and called upon in the model to be edited or run upon. The class itself has return methods and calculations as provided in the assignment.

View: 
	ImageView:

The interface for the view which has the methods of the view class

	ImageViewImpl:

The implementation of the methods which has the toString, renderMessage and renderImage functions. The toString shows the image to the render board which outputs the image. 

Controller:
	ImageController: 

The image controller interface which has the single public method which is called to run the program. 

	ImageControllerImpl:

Withholds the helper methods which helps with the main function to run the program. The controller runs all the commands given by the user, this edits the pixels of the given image with the given command, 

Commands: 
	ImageCommands: 

The image commands interface which has the methods called on all of the command types 

	ImageState:

The command interface for images that are being horizontally flipped or vertically flipped 

	ImageStateImpl:

Implementation of the image state interface, which takes the image as a whole and rotates either vertically or horizontally, this is done differently as this uses the entire image to change the state. 

	Greyscale:

This has the commands for changing the colour of the image, for each of the RGB colour it has the ability to change the other corresponding pixels to the same value to make it grey. 

	Lighting:

This has the commands to either brighten the image or darken the image given a value to increase or decrease it by. This then takes the value of the rgb components of the pixel and increases each to make it brighter. 

Main: 
	-This class was made to run the program which takes in the controller with a model and view and runs the program given the different models and views. 


Program: 

	Run the program in the main method

	With the given instructions the given user inputs can be the following:

		load image (imageName, destination) 

		save image(imageName, destination)

		quit

		red-component(imageName, destination)

		green-component(imageName, destination)
	
 		blue-component(imageName, destination)

		value-component(imageName, destination)
	
		intensity-component(imageName, destination)

		luma-component(imageName, destination)

		brighten(integer, imageName, destination)

		darken(integer, imageName, destination)


Type this script when the program runs: 
	load image rec/Koala.ppm img
	red-component Koala.ppm res/red-koala.ppm
	quit

The image we used: https://www.princeton.edu/news/2022/02/02/what-your-dogs-lifespan-you-might-be-surprised


 





 
